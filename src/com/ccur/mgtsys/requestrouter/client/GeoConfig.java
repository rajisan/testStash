package com.ccur.mgtsys.requestrouter.client;

public class GeoConfig {
	
	    private Geo geo;

	    public Geo getGeo ()
	    {
	        return geo;
	    }

	    public void setGeo (Geo geo)
	    {
	        this.geo = geo;
	    }

	    @Override
	    public String toString()
	    {
	        return "GeoConfig [geo = "+geo+"]";
	    }
	}