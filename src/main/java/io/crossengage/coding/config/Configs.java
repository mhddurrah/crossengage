package io.crossengage.coding.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * application configuration handler, load configurations from a property file
 * 
 * @author durrah
 *
 */
public class Configs {
	static Properties PROPERTIES = new Properties();
	public static final String BATCH_SIZE = "batch_size";
	public static final String USER_DATA = "users_file";

	static {
		InputStream is = Configs.class.getClassLoader().getResourceAsStream("io/crossengage/coding/config.properties");
		try {
			PROPERTIES.load(is);
		} catch (IOException e) {
		}
	}

	public static String get(String key) {
		return (String) PROPERTIES.get(key.toLowerCase());
	}

}