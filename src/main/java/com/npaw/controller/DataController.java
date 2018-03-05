package com.npaw.controller;

import java.util.UUID;

import com.npaw.model.Client;
import com.npaw.model.DataModel;
import com.npaw.model.Plugin;
import com.npaw.model.PluginData;

/**
 * 
 * @author santiagobernal
 *
 */
public class DataController {

	private DataModel _dataModel;
	
	private DataModel getDataModel(){
		if(this._dataModel == null) {
			this._dataModel = new DataModel();
		}
		return this._dataModel;
	}
	
	public PluginData getData(String accountCode, String targetDevice, String pluginVersion) {
		Client clientFound  = this.getDataModel().getClient(accountCode, targetDevice);
		
		if(clientFound == null) {
			return null;
		}
		
		Plugin pluginFound = this.getDataModel().getPlugin(pluginVersion, clientFound);
		
		if(pluginFound == null) {
			return null;
		}
		
		return getPluginData(pluginFound);
	}
	
	private PluginData getPluginData(Plugin plugin) {
		String uuid = UUID.randomUUID().toString();
		return new PluginData(plugin.getHosts().get(0).getHostName(), plugin.getPingTime(), uuid);
	}
}
