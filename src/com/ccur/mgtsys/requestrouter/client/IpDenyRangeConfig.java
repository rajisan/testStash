package com.ccur.mgtsys.requestrouter.client;

import java.util.List;

public class IpDenyRangeConfig {

	private List<String> ip_deny_range;

    public List<String> getIp_deny_range ()
    {
        return ip_deny_range;
    }

    public void setIp_deny_range (List<String> ip_deny_range)
    {
        this.ip_deny_range = ip_deny_range;
    }

    @Override
    public String toString() 
    {
        return "IpDenyRange [ip_deny_range = "+ip_deny_range+"]";
    }
}
