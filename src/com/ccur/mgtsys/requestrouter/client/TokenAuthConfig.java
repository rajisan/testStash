package com.ccur.mgtsys.requestrouter.client;

public class TokenAuthConfig
{
    private TokenAuth token_auth;

    public TokenAuth getToken_auth ()
    {
        return token_auth;
    }

    public void setToken_auth (TokenAuth token_auth)
    {
        this.token_auth = token_auth;
    }

    @Override
    public String toString()
    {
        return "TokenAuthConfig [token_auth = "+token_auth+"]";
    }
}