package com.npaw.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class for getting the system storage information
 * @author santiagobernal
 *
 */
public class DataModel {
	
	private static final String FILE_LOCATION = "./data.json";
	
	/**
	 * Gets the clients from the Json file, and finds one with the corresponding accountCode 
	 * @param accountCode
	 * @param targetDevice
	 * @param version
	 * @return
	 */
	private Client getClientFromJson(String accountCode) {
		Client client = null;
		try {
			File file = new File(FILE_LOCATION);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			String json = inputStreamToString(new FileInputStream(file));
			List<Client> clientList = mapper.readValue(json, new TypeReference<List<Client>>(){});
			client = clientList.stream().filter(c -> c.getAccountCode().equals(accountCode)).findFirst().orElse(null);
		}catch(Exception e) {
			System.out.println("Something went wrong when trying to get the file");
			System.out.println("Error was: " + e.getMessage());
		}
		return client;
	}
	
	private String inputStreamToString(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    br.close();
	    return sb.toString();
	}
	
	/**
	 * If no client was found in the json file, creates a dummy one
	 * @param accountCode
	 * @param targetDevice
	 * @param version
	 * @return
	 */
	private Client getClientFromCode(String accountCode, String targetDevice, String version) {
		Client client = null;
		if(accountCode.equals("clienteA")) {
			if(targetDevice.equals("Xbox") || targetDevice.equals("Panasonic")) {
				List<Plugin> plugins = new ArrayList<>();
				if(version.equals("3.3.1") ) {
					plugins.add(new Plugin(targetDevice, version, 10, Arrays.asList(new Host("clusterA.com", 70), new Host("clusterB.com", 30))));
					client = new Client(accountCode, plugins);
				} else if (version.equals("3.3.2")) {
					plugins.add(new Plugin(targetDevice, version, 5, Arrays.asList( new Host("clusterB.com", 100))));
					client = new Client(accountCode, plugins);
				}	
			}
		}
		if(accountCode.equals("clienteB")) {
			if(targetDevice.equals("osmf") && version.equals("3.3.1")) {
				List<Plugin> plugins = new ArrayList<>();
				plugins.add(new Plugin(targetDevice, version,  5, Arrays.asList(new Host("clusterA.com", 50), new Host("clusterB.com", 50))));		
				client = new Client(accountCode, plugins);
			}
		}
		return client;
	}
	
	/**
	 * Gets a {@link Client} from the data source, returns null if no client was found
	 * @param accountCode
	 * @param targetDevice
	 * @return
	 */
	public Client getClient(String accountCode, String targetDevice, String version) {
		Client client = Optional.ofNullable(getClientFromJson(accountCode)).orElse(getClientFromCode(accountCode, targetDevice, version));
		return client;
	}
}
