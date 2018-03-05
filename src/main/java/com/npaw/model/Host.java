package com.npaw.model;

public class Host {

	private String hostName;
	private int percentTraffic;
	
	public Host() {
		super();
	}

	public Host(String hostName, int percentTraffic) {
		super();
		this.hostName = hostName;
		this.percentTraffic = percentTraffic;
	}

	@Override
	public String toString() {
		return "Host [hostName=" + hostName + ", percentTraffic=" + percentTraffic + "]";
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPercentTraffic() {
		return percentTraffic;
	}

	public void setPercentTraffic(int percentTraffic) {
		this.percentTraffic = percentTraffic;
	}
	
	
}
