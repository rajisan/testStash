package com.ccur.mgtsys.requestrouter.client;

public class TokenTypeConfig {

	private TokenType token_types;

    public TokenType getTokenType ()
    {
        return token_types;
    }

    public void setTokenType (TokenType tokenType)
    {
        this.token_types = tokenType;
    }

    @Override
    public String toString()
    {
        return "TokenAuthConfig [token_auth = "+token_types+"]";
    }
}