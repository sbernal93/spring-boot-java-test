package com.npaw.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author santiagobernal
 *
 */
public class Plugin {

	private String targetDevice;
	private String version;
	private int pingTime;
	private List<Host> hosts;
	
	@Override
	public String toString() {
		return "Plugin [version=" + version + ", pingTime=" + pingTime + ", host=" + hosts + ", targetDevice=" + targetDevice+ "]";
	}

	public Plugin() {
		super();
		this.hosts = new ArrayList<>();
	}

	public Plugin(String targetDevice, String version, int pingTime, List<Host> hosts) {
		super();
		this.targetDevice = targetDevice;
		this.version = version;
		this.pingTime = pingTime;
		this.hosts = hosts;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getPingTime() {
		return pingTime;
	}

	public void setPingTime(int pingTime) {
		this.pingTime = pingTime;
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	public String getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}
	
	
}
