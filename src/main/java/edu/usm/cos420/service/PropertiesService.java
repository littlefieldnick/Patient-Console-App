package edu.usm.cos420.service;

import java.util.*;
import java.io.*;


public class PropertiesService {
	private final Properties instance;

	private PropertiesService() {
		instance = new Properties();

		try {
			instance.load(getClass().getClassLoader().getResourceAsStream("database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return instance.getProperty(key);
	}

	public static class DatabaseProperties{
		private final static PropertiesService dbPropInstance = new PropertiesService();

		public static PropertiesService getInstance() {
			return dbPropInstance;
		}
	}

}
