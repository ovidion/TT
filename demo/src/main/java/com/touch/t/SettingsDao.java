package com.touch.t;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sachag
 *
 */
@Service
public class SettingsDao {
	
	public Settings getSettings() {
		try {
			URL url = new URL("http://my-json-server.typicode.com/touchtunes/tech-assignment/settings");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();

			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(responseStream, Settings.class);

		} catch (IOException e) {
			return null;
		}		
	}

}