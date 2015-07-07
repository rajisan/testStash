package com.ccur.mgtsys.requestrouter.client;

import java.util.List;

public class IpAllowRangeConfig {
	
	
	    private List<String> ip_allow_range;

	    public List<String> getIp_allow_range ()
	    {
	        return ip_allow_range;
	    }

	    public void setIp_allow_range (List<String> ip_allow_range)
	    {
	        this.ip_allow_range = ip_allow_range;
	    }

	    @Override
	    public String toString()
	    {
	        return "IpAllowRange [ip_allow_range = "+ip_allow_range+"]";
	    }
	
}
