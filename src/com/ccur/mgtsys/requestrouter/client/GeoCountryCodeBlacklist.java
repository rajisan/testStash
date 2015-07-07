package com.ccur.mgtsys.requestrouter.client;

import java.util.List;

public class GeoCountryCodeBlacklist
{
    private List<String> geo_country_codes_blacklist;

    public List<String> getGeo_country_codes_blacklist ()
    {
        return geo_country_codes_blacklist;
    }

    public void setGeo_country_codes_blacklist (List<String> geo_country_codes_blacklist)
    {
        this.geo_country_codes_blacklist = geo_country_codes_blacklist;
    }

    @Override
    public String toString()
    {
        return "GeoCountryCodeBlacklist [geo_country_codes_blacklist = "+geo_country_codes_blacklist+"]";
    }
}
	