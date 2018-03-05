package com.npaw.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.npaw.controller.DataController;
import com.npaw.model.PluginData;

@RestController
public class DataView {
	
	@Autowired
	ObjectMapper objectMapper;
	
	private DataController _dataController;
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = "application/xml")
	public PluginData getData(
			@RequestParam("accountCode") String accountCode,
			@RequestParam("targetDevice") String targetDevice,
			@RequestParam("pluginVersion") String pluginVersion) {
		
		if(accountCode == null || accountCode.isEmpty() || targetDevice == null ||
				targetDevice.isEmpty() || pluginVersion == null || 
				pluginVersion.isEmpty()) {
			return null;
		}
		
		return this.getDataController().getData(accountCode, targetDevice, pluginVersion);
	}

	
	private DataController getDataController(){
		if(this._dataController == null) {
			this._dataController = new DataController();
		}
		return this._dataController;
	}
}
