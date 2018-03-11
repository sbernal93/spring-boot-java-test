package com.npaw.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.npaw.model.Client;
import com.npaw.model.DataModel;
import com.npaw.model.Host;
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
	
	/**
	 * Gets the data from the model and returns the View conversion
	 * @param accountCode
	 * @param targetDevice
	 * @param pluginVersion
	 * @return
	 */
	public PluginData getData(String accountCode, String targetDevice, String pluginVersion) {
		Client clientFound  = this.getDataModel().getClient(accountCode, targetDevice, pluginVersion);
		
		if(clientFound == null || clientFound.getPlugins() == null) {
			return null;
		}
		
		Optional<Plugin> pluginFound = clientFound.getPlugins().stream().filter(p ->
			p.getTargetDevice().equals(targetDevice) && p.getVersion().equals(pluginVersion)).findFirst();
		
		if(!pluginFound.isPresent()) {
			return null;
		}
		
		return getPluginData(pluginFound.get());
	}
	
	/**
	 * Convertes a plugin to a pluginData for the view to show
	 * @param plugin
	 * @return
	 */
	private PluginData getPluginData(Plugin plugin) {
		if(plugin.getHosts() == null || plugin.getHosts().size() < 1) {
			return null;
		}
		
		String uuid = UUID.randomUUID().toString();
		return new PluginData(getHost(plugin.getHosts()).getHostName(), plugin.getPingTime(), uuid);
	}

	/**
	 * Gets a host from a host list based on the traffic %
	 * @param hosts
	 * @return
	 */
	private Host getHost(List<Host> hosts) {
		double rand = Math.random()*100;
		double prob = 0.0;
		for(Host host : hosts) {
			prob += host.getPercentTraffic();
			if(rand <= prob) {
				return host;
			}
		}
		return hosts.get(0);
	}
}
