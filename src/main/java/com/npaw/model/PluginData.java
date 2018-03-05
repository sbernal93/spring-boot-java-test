package com.npaw.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * @author santiagobernal
 *
 */
@JacksonXmlRootElement(localName = "q")
public class PluginData {

	@JsonProperty("h")
	private String host;
	
	@JsonProperty("pt")
	private int pingTime;
	
	@JsonProperty("c")
	private String viewCode;
	
	public PluginData(String host, int pingTime, String viewCode) {
		super();
		this.host = host;
		this.pingTime = pingTime;
		this.viewCode = viewCode;
	}

	public PluginData() {
		super();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPingTime() {
		return pingTime;
	}

	public void setPingTime(int pingTime) {
		this.pingTime = pingTime;
	}

	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	
	
}
