package com.ccur.mgtsys.requestrouter.client;

public class StreamingGatewayConfig {
    
	private SettingsConfig[] settings;

    public SettingsConfig[] getSettings ()
    {
        return settings;
    }

    public void setSettings (SettingsConfig[] settings)
    {
        this.settings = settings;
    }

    @Override
    public String toString()
    {
        return "StreamingGatewayConfig [settings = "+settings+"]";
    }
}
