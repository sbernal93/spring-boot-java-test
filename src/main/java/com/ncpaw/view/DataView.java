package com.ncpaw.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataView {
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	String getData(@RequestParam("accountCode") String accountCode,
			@RequestParam("targetDevice") String targetDevice,
			@RequestParam("pluginVersion") String pluginVersion) {
		
		if(accountCode == null || accountCode.isEmpty() || targetDevice == null ||
				targetDevice.isEmpty() || pluginVersion == null || 
				pluginVersion.isEmpty()) {
			return "empty inputs";
		}
		
		
		return "Hello World!";
	}

}
