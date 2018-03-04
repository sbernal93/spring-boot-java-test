package com.ncpaw.controller;

import java.util.UUID;

import com.ncpaw.model.Client;
import com.ncpaw.model.DataModel;
import com.ncpaw.model.Plugin;
import com.ncpaw.model.PluginData;

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
