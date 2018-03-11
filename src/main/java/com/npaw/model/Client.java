package com.npaw.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author santiagobernal
 *
 */
public class Client {

	private String accountCode;
	private List<Plugin> plugins;
	
	
	@Override
	public String toString() {
		return "Client [accountCode=" + accountCode + ", plugins=" + plugins + "]";
	}
	public Client(String accountCode, List<Plugin> plugins) {
		super();
		this.accountCode = accountCode;
		this.plugins = plugins;
	}
	public Client() {
		super();
		this.plugins = new ArrayList<>();
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public List<Plugin> getPlugins() {
		return plugins;
	}
	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}
	
	
}
