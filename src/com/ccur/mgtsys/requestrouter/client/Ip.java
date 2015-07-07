package com.ccur.mgtsys.requestrouter.client;

public class Ip {
    private String redirect_url; 

    private String log_prefix;

    private Boolean restrict;

    public String getRedirect_url ()
    {
        return redirect_url;
    }

    public void setRedirect_url (String redirect_url)
    {
        this.redirect_url = redirect_url;
    }

    public String getLog_prefix ()
    {
        return log_prefix;
    }

    public void setLog_prefix (String log_prefix)
    {
        this.log_prefix = log_prefix;
    }

    public Boolean isRestrict ()
    {
        return restrict;
    }

    public void setRestrict (Boolean restrict)
    {
        this.restrict = restrict;
    }

    @Override
    public String toString()
    {
        return "GeoConfig [redirect_url = "+redirect_url+", log_prefix = "+log_prefix+", restrict = "+restrict+"]";
    }
}