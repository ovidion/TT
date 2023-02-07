package com.touch.t;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sachag
 *
 */
@Service
public class JukeboxDao {
	
	public List<Jukebox> getJukeboxes() {
		try {
			URL url = new URL("http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			InputStream responseStream = connection.getInputStream();

			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(responseStream, new TypeReference<List<Jukebox>>(){});

		} catch (IOException e) {
			return Collections.emptyList();
		}
	}

}