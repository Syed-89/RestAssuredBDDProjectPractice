package com.users.api.utils;

import java.io.File;
import java.util.Objects;

public final class FileSystem {
	
	public static void deleteOldReports(){
		
	     File reportDir = new File("C:\\Users\\Syed Danish\\eclipse-workspace\\RestassuredBDDPractice\\target\\allure-results");
	        if (reportDir.exists()) {
	            for (File f : Objects.requireNonNull(reportDir.listFiles())) {
	                f.delete();
	            }
	        }
	    }
		
		
	}

