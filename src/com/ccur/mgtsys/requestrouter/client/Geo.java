package com.ccur.mgtsys.requestrouter.client;

public class Geo {
    private String redirect_url;

    private String db_path;

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

    public String getDb_path ()
    {
        return db_path;
    }

    public void setDb_path (String db_path)
    {
        this.db_path = db_path;
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
        return "GeoConfig [redirect_url = "+redirect_url+", db_path = "+db_path+", log_prefix = "+log_prefix+", restrict = "+restrict+"]";
    }
}