package com.users.api.utils;

import java.io.InputStream;

public class ReadJsonFile {

	
	public InputStream readFile(String path) {
		
		InputStream jsonPath = getClass().getClassLoader()
	    .getResourceAsStream(ConfigManager.getInstance().getString(path));
	
		return jsonPath;
	}
}
