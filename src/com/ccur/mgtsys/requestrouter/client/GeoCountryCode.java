package com.ccur.mgtsys.requestrouter.client;

import java.util.List;

public class GeoCountryCode
{
    private List<String> geo_country_codes;

    public List<String> getGeo_country_codes ()
    {
        return geo_country_codes;
    }

    public void setGeo_country_codes (List<String> geo_country_codes)
    {
        this.geo_country_codes = geo_country_codes;
    }

    @Override
    public String toString()
    {
        return "GeoCountryCode [geo_country_codes = "+geo_country_codes+"]";
    }
}
	