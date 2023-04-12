package com.users.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	private static ConfigManager manager=null;
	private static Properties pro;
	
	public ConfigManager() throws IOException
	{
		
		pro=new Properties();
		FileInputStream fls= new FileInputStream("C:\\Users\\Syed Danish\\eclipse-workspace\\RestassuredBDDPractice\\src\\main\\java\\com\\user\\api\\configuration\\config.properties");		
		pro.load(fls);
		
		
	}
	
	public static ConfigManager getInstance()
	{
		if(manager==null)
		{
			
			synchronized(ConfigManager.class){
				
				try {
					manager=new ConfigManager();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		
			
		}
		
		return manager;
		
		
		
	}
	
	public String getString(String key)
	{
		
		
		return pro.getProperty(key);
		
	}
}



