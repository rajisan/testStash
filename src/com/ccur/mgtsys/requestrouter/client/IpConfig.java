package com.ccur.mgtsys.requestrouter.client;

public class IpConfig {
	private Ip ip;

	public Ip getIp ()
	{
		return ip;
	}

	public void setIp (Ip ip)
	{
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "IpConfig [ip = "+ip+"]";
	}
}