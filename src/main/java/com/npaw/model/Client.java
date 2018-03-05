package com.npaw.model;


/**
 * 
 * @author santiagobernal
 *
 */
public class Client {

	private String accountCode;
	private String targetDevice;
	
	@Override
	public String toString() {
		return "Client [accountCode=" + accountCode + ", targetDevice=" + targetDevice + "]";
	}
	public Client() {
		super();
	}
	public Client(String accountCode, String targetDevice) {
		super();
		this.accountCode = accountCode;
		this.targetDevice = targetDevice;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getTargetDevice() {
		return targetDevice;
	}
	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}
	
	
}
