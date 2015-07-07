package com.ccur.mgtsys.requestrouter.client;

public class SettingsConfig {

	 private String media_ext;

	    private String media_path;

	    private String url_pattern;

	    private String redirect_code;

	    private String key_id;

	    private String signature;

	    public String getMedia_ext ()
	    {
	        return media_ext;
	    }

	    public void setMedia_ext (String media_ext)
	    {
	        this.media_ext = media_ext;
	    }

	    public String getMedia_path ()
	    {
	        return media_path;
	    }

	    public void setMedia_path (String media_path)
	    {
	        this.media_path = media_path;
	    }

	    public String getUrl_pattern ()
	    {
	        return url_pattern;
	    }

	    public void setUrl_pattern (String url_pattern)
	    {
	        this.url_pattern = url_pattern;
	    }

	    public String getRedirect_code ()
	    {
	        return redirect_code;
	    }

	    public void setRedirect_code (String redirect_code)
	    {
	        this.redirect_code = redirect_code;
	    }

	    public String getKey_id ()
	    {
	        return key_id;
	    }

	    public void setKey_id (String key_id)
	    {
	        this.key_id = key_id;
	    }

	    public String getSignature ()
	    {
	        return signature;
	    }

	    public void setSignature (String signature)
	    {
	        this.signature = signature;
	    }

	    @Override
	    public String toString()
	    {
	        return "Setting [media_ext = "+media_ext+", media_path = "+media_path+", url_pattern = "+url_pattern+", redirect_code = "+redirect_code+", key_id = "+key_id+", signature = "+signature+"]";
	    }
}
