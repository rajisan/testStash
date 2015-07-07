package com.ccur.mgtsys.requestrouter.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.ccur.mgtsys.data.reqrouter.AuthenticationToken;
import com.ccur.mgtsys.data.reqrouter.ReqRtrRestrictions;
import com.ccur.mgtsys.data.reqrouter.ReqRtrServiceConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




public class ConfigClient {

	private static final String BASEURL = "http://10.76.75.10:8000/api/config";	


	public String getBaseURL() {
		return BASEURL;
	}

	/*public CollectionClient() {
        super();        
        webUrl = getBaseURL() + WS_PATH;
    }*/

	public void postConfig(ReqRtrServiceConfig rrConfig) {    
		
		List<AuthenticationToken> authTokens = rrConfig.getAuthenticationTokens();
		List<String> apiIpRange = rrConfig.getIpRange();
		Boolean debug = (Boolean)rrConfig.getProperties().get("debug");
		Boolean logging = (Boolean)rrConfig.getProperties().get("logging");
		ReqRtrRestrictions geoRestrictions = rrConfig.getGeoRestrictions();
		ReqRtrRestrictions ipRestrictions = rrConfig.getIpRestrictions();
		List<AuthenticationToken> authList = rrConfig.getAuthenticationTokens();
		
		//rrConfig.isTokenAuthenticationEnabled();

		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			
		/*	Client client = Client.create();
			WebResource webResource = client.resource(BASEURL + "/debug");
			WebResource.Builder builder = webResource.type("application/json");
			ClientResponse response = builder.post(ClientResponse.class, debugJson(mapper, debug));
			String res = response.getEntity(String.class);	
			System.out.print("response " + res);

			
			webResource = client.resource(BASEURL + "/logging");
			//builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, loggingJson(mapper, logging));
			res = response.getEntity(String.class);	
			System.out.print("write response " + res);*/
			
			Client client = Client.create();
			WebResource webResource = client.resource(BASEURL + "/geo");
			WebResource.Builder getBuilder = webResource.accept("application/json");
			
			ClientResponse getResponse = getBuilder.get(ClientResponse.class);
			String getRes = getResponse.getEntity(String.class);	
			System.out.print("write response " + getRes);
			
			webResource = client.resource(BASEURL + "/geo");
			WebResource.Builder builder = webResource.type("application/json");
			String test = geoJson(mapper, geoRestrictions, getRes);
			System.out.println("test " + test);
			ClientResponse response = builder.post(ClientResponse.class, geoJson(mapper, geoRestrictions, getRes));
			String res = response.getEntity(String.class);	
			System.out.print("write response " + res);
			
			String geoCodes = geoCountryCodesJson(mapper, geoRestrictions);
			
			if(geoRestrictions.isDefaultBehaviorIsAllow()) {
				webResource = client.resource(BASEURL + "/geo_country_codes");
				builder = webResource.type("application/json");
				response = builder.post(ClientResponse.class, geoCodes);
				res = response.getEntity(String.class);	
				System.out.print("allow geo response " + res);
			} else {
				webResource = client.resource(BASEURL + "/geo_country_codes_blacklist");
				builder = webResource.type("application/json");
				response = builder.post(ClientResponse.class, geoCodes);
				res = response.getEntity(String.class);	
				System.out.print("blacklist geo response " + res);
			}
			
			webResource = client.resource(BASEURL + "/token_auth");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, tokenAuthJson(mapper, (Boolean)rrConfig.getProperties().get("tokenAuthenticationEnabled"), rrConfig.getValidationExpressions()));
			res = response.getEntity(String.class);	
			System.out.print("write token auth response " + res);
	
			webResource = client.resource(BASEURL + "/token_types");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, tokenAuthJson(mapper, (Boolean)rrConfig.getProperties().get("tokenAuthenticationEnabled"), rrConfig.getValidationExpressions()));
			res = response.getEntity(String.class);	
			System.out.print("write token auth response " + res);
			
			webResource = client.resource(BASEURL + "/");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, tokenAuthJson(mapper, (Boolean)rrConfig.getProperties().get("tokenAuthenticationEnabled"), rrConfig.getValidationExpressions()));
			res = response.getEntity(String.class);	
			System.out.print("write token auth response " + res);
			
			webResource = client.resource(BASEURL + "/");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, tokenAuthJson(mapper, (Boolean)rrConfig.getProperties().get("tokenAuthenticationEnabled"), rrConfig.getValidationExpressions()));
			res = response.getEntity(String.class);	
			System.out.print("write token auth response " + res);
			
			
			
			
			
			
			webResource = client.resource(BASEURL + "/ip");
			getBuilder = webResource.accept("application/json");
			
			getResponse = getBuilder.get(ClientResponse.class);
			getRes = getResponse.getEntity(String.class);	
			System.out.print("write ip response " + getRes);
			
			webResource = client.resource(BASEURL + "/ip");
			builder = webResource.type("application/json");
			test = ipJson(mapper, ipRestrictions, getRes);
			System.out.println("test " + test);
			response = builder.post(ClientResponse.class, ipJson(mapper, ipRestrictions, getRes));
			res = response.getEntity(String.class);	
			System.out.print("write response " + res);
			
			String ipRangeJson = ipRangeJson(mapper, ipRestrictions);
			
			if(ipRestrictions.isDefaultBehaviorIsAllow()) {
				webResource = client.resource(BASEURL + "/ip_allow_range");
				builder = webResource.type("application/json");
				response = builder.post(ClientResponse.class, ipRangeJson);
				res = response.getEntity(String.class);	
				System.out.print("ip allow range response " + res);
			} else {
				webResource = client.resource(BASEURL + "/ip_deny_range");
				builder = webResource.type("application/json");
				response = builder.post(ClientResponse.class, ipRangeJson);
				res = response.getEntity(String.class);	
				System.out.print("ip deny response " + res);
			}
			
			
			/*webResource = client.resource(BASEURL + "/token_types");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, getDebugFromDb());
			res = response.getEntity(String.class);	
			System.out.print("write response " + res);*/
			
			webResource = client.resource(BASEURL + "/write");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, "{}" );
			res = response.getEntity(String.class);	
			System.out.print("write response " + res);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*public void postLogging() {    

		try 
		{
			Client client = Client.create();
			WebResource webResource = client.resource(BASEURL + "/logging");
			WebResource.Builder builder = webResource.type("application/json");
			ClientResponse response = builder.post(ClientResponse.class, getDebugFromDb());
			String res = response.getEntity(String.class);	
			System.out.print("response " + res);


			webResource = client.resource(BASEURL + "/write");
			builder = webResource.type("application/json");
			response = builder.post(ClientResponse.class, getDebugFromDb());
			res = response.getEntity(String.class);	
			System.out.print("write response " + res);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
*/
	public String debugJson(ObjectMapper mapper, Boolean debug){
		DebugConfig debugConfig = new DebugConfig();
		debugConfig.setDebug(debug);
		//String debugJson = "{\"debug\": false}";
		String debugJson = null;
		try {
			debugJson = mapper.writeValueAsString(debugConfig);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return debugJson;
	}

	public String loggingJson(ObjectMapper mapper, Boolean logging){
		LoggingConfig loggingConfig = new LoggingConfig();
		loggingConfig.setLogging(logging);
		
		//String debugJson = "{\"logging\": false}";
		
		String loggingJson = null;
		try {
			loggingJson = mapper.writeValueAsString(loggingConfig);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loggingJson;
	}
	
	public String tokenAuthJson(ObjectMapper mapper, Boolean validate, List<String> validExpressions){
		TokenAuth tokenAuth = new TokenAuth();
		tokenAuth.setValidate(validate);
		tokenAuth.setValidateExpressions(validExpressions);
		TokenAuthConfig tokenAuthConfig = new TokenAuthConfig();
		tokenAuthConfig.setToken_auth(tokenAuth);
		
		//String debugJson = "{\"logging\": false}";
		
		String tokenAuthJson = null;
		try {
			tokenAuthJson = mapper.writeValueAsString(tokenAuthConfig);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tokenAuth " + tokenAuthJson);
		return tokenAuthJson;
	}
	
	public String tokenTypeJson(ObjectMapper mapper, List<AuthenticationToken> tokenTypeList){
		
		TokenTypeConfig tokenTypeConfig = new TokenTypeConfig();
		String tokenTypeJson = "";
		
		TokenType tokenType = new TokenType();
		
		for(AuthenticationToken authToken: tokenTypeList) {
			tokenType.add(authToken.getName(), authToken.getType());
			
		}
		
		
		String tokenAuthJson = null;
		try {
			tokenTypeJson = mapper.writeValueAsString(tokenType);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tokenTypeJson " + tokenTypeJson);
		return tokenTypeJson;
	}
	
	public String geoCountryCodesJson(ObjectMapper mapper,  ReqRtrRestrictions geoRestriction){
		String geoCodes = "";
		GeoCountryCode geoCountryCodeAllow = new GeoCountryCode();
		GeoCountryCodeBlacklist geoCountryCodeBlacklist = new GeoCountryCodeBlacklist();
		try {
			if(geoRestriction.isDefaultBehaviorIsAllow()) {
				geoCountryCodeAllow.setGeo_country_codes(geoRestriction.getAllowList());
				geoCodes = mapper.writeValueAsString(geoCountryCodeAllow);

			} else {
				geoCountryCodeBlacklist.setGeo_country_codes_blacklist(geoRestriction.getAllowList());
				geoCodes = mapper.writeValueAsString(geoCountryCodeBlacklist);
			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("geoCodes request " + geoCodes);
		return geoCodes;
	}
	
	
	public String geoJson(ObjectMapper mapper,  ReqRtrRestrictions geoRestriction, String response){
		
		Geo geo = new Geo();
		Geo responseGeo = new Geo();
		GeoConfig geoConfig = new GeoConfig();
		
		System.out.println("testttt response " + response);
		try {
			geoConfig = mapper.readValue(response, GeoConfig.class);
			responseGeo = geoConfig.getGeo();
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		geo.setDb_path(responseGeo.getDb_path());
		geo.setLog_prefix(responseGeo.getLog_prefix());
		
		geo.setRedirect_url(geoRestriction.getRedirectUrl());
		geo.setRestrict(geoRestriction.isRestrict());		
		
		geoConfig.setGeo(geo);
				
		String geoConf = null;
		try {
			geoConf = mapper.writeValueAsString(geoConfig);
			System.out.println("geo conf " + geoConf);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geoConf;
	}
	
	
	public String ipRangeJson(ObjectMapper mapper,  ReqRtrRestrictions ipRestriction){
		String ipRange = "";
		IpAllowRangeConfig ipAllowRangeConfig = new IpAllowRangeConfig();
		IpDenyRangeConfig ipDenyRangeConfig = new IpDenyRangeConfig();
		
		try {
			if(ipRestriction.isDefaultBehaviorIsAllow()) {
				ipAllowRangeConfig.setIp_allow_range(ipRestriction.getAllowList());
				ipRange = mapper.writeValueAsString(ipAllowRangeConfig);

			} else {
				ipDenyRangeConfig.setIp_deny_range(ipRestriction.getAllowList());
				ipRange = mapper.writeValueAsString(ipDenyRangeConfig);
			}

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ipRange request " + ipRange);
		return ipRange;
	}
	
	
	public String ipJson(ObjectMapper mapper,  ReqRtrRestrictions ipRange, String response){
		
		Ip ip = new Ip();
		Ip responseIp = new Ip();
		IpConfig ipConfig = new IpConfig();
		
		System.out.println("testttt response " + response);
		try {
			ipConfig = mapper.readValue(response, IpConfig.class);
			responseIp = ipConfig.getIp();
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		ip.setLog_prefix(responseIp.getLog_prefix());
		
		ip.setRedirect_url(ipRange.getRedirectUrl());
		ip.setRestrict(ipRange.isRestrict());		
		
		ipConfig.setIp(ip);
				
		String ipConf = null;
		try {
			ipConf = mapper.writeValueAsString(ipConfig);
			System.out.println("ip conf " + ipConf);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipConf;
	}
	
	public static void main(String[] args) {
		try {
			
			ReqRtrServiceConfig rrConfig = new ReqRtrServiceConfig();
			Map<String,Object> properties = new HashMap<String, Object>();
			ArrayList<String> allow = new ArrayList<String>();
			allow.add("Canada");
			allow.add("US");			
			
			ReqRtrRestrictions rrGeoRestrictions = new ReqRtrRestrictions();
			rrGeoRestrictions.setRedirectUrl("x");
			rrGeoRestrictions.setRestrict(false);
			rrGeoRestrictions.setDefaultBehaviorIsAllow(false);
			rrGeoRestrictions.setAllowList(allow);
			
			ArrayList<String> allowIp = new ArrayList<String>();
			allowIp.add("10.76.0.0/16");
			allowIp.add("129.75.25.103/32");
			
			ArrayList<String> validationExpressions = new ArrayList<String>();
			validationExpressions.add("/media(/[^/]*)*/Manifest$");
			validationExpressions.add("/media/([^/]*/)*[^.]+\\.(f4m|m3u8)$");
			
			ReqRtrRestrictions rrIpRestrictions = new ReqRtrRestrictions();
			rrIpRestrictions.setRedirectUrl("x");
			rrIpRestrictions.setRestrict(false);
			rrIpRestrictions.setDefaultBehaviorIsAllow(false);
			rrIpRestrictions.setAllowList(allowIp);
			
			AuthenticationToken auth = new AuthenticationToken();
			auth.setExpirationDateRestrict(true);
			auth.setInternalAuth(true);			
			auth.setIpRestrict(true);
			auth.setName("ccur");
			auth.setType("SHA1");
			auth.setTimeToLive(84600);
			auth.addKey("abcd");
			auth.addKey("xyz");
			
			List<AuthenticationToken> authList = new ArrayList<AuthenticationToken>();
			authList.add(auth);
			
			properties.put("siteRoutingMethod", new String("round robin"));
	        properties.put("tokenAuthenticationEnabled",  new Boolean(true));        
		    properties.put("logging",     new Boolean(true));
	        properties.put("debug",       new Boolean(true));	
			
			rrConfig.setProperties(properties);
			
			/*rrConfig.setDebug(false);
			rrConfig.setLogging(true);*/
			rrConfig.setGeoRestrictions(rrGeoRestrictions);
			rrConfig.setIpRestrictions(rrIpRestrictions);
			//rrConfig.setTokenAuthenticationEnabled(false);
			rrConfig.setValidationExpressions(validationExpressions);
			rrConfig.setAuthenticationTokens(authList);
			
			
			
			ObjectMapper mapper = new ObjectMapper();
	        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();		
			
			String configString = writer.writeValueAsString(auth);
			
			System.out.println(configString);
					
		//	System.out.println(Inet4Address.getLocalHost().getHostAddress());
			
			ConfigClient cClient = new ConfigClient();

			cClient.postConfig(rrConfig);


		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
