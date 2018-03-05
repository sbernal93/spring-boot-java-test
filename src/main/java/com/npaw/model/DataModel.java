package com.npaw.model;

import java.util.Arrays;

/**
 * Class for getting the system storage information
 * @author santiagobernal
 *
 */
public class DataModel {
	
	/**
	 * Gets a {@link Client} from the data source, returns null if no client was found
	 * @param accountCode
	 * @param targetDevice
	 * @return
	 */
	public Client getClient(String accountCode, String targetDevice) {
		//TODO: get client from other source, not hard coded
		if(accountCode.equals("clienteA")) {
			if(targetDevice.equals("Xbox") || targetDevice.equals("Panasonic")) {
				return new Client(accountCode, targetDevice);
			}
			return null;
		}
		if(accountCode.equals("clienteB")) {
			if(targetDevice.equals("osmf")) {
				return new Client(accountCode, targetDevice);
			}
		}
		return null;
	}
	
	/**
	 * Gets a {@link Plugin} based on the version and client received
	 * @param version
	 * @param client
	 * @return
	 */
	public Plugin getPlugin(String version, Client client) {
		//TODO: get plugin info from other source, not hard coded
		if(version.equals("3.3.1")) {
			if(client.getAccountCode().equals("clienteA")) {
				return new Plugin(version, 10, Arrays.asList(new Host("clusterA.com", 70), new Host("clusterB.com", 30)));
			} 
			if(client.getAccountCode().equals("clienteB")) {
				return new Plugin(version, 5, Arrays.asList(new Host("clusterA.com", 50), new Host("clusterB.com", 50)));		
			}
		}
		if(version.equals("3.3.2")) {
			if(client.getAccountCode().equals("clienteA")) {
				return new Plugin(version, 5, Arrays.asList( new Host("clusterB.com", 100)));
			}
		}
		
		return null;
	}
}
