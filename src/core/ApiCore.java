package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiCore {
	

	/**
	 * Method which connects to a given URL and returns
	 * the text response from the website. The contents of the URL
	 * are returned as a large string.
	 * 
	 * @param String urlString - The URL which you are requesting data from
	 * @return String - The contents of the URL
	 * @throws IOException - There was a problem retrieving the contents
	 */
	public String getApiResponse(String urlString) throws IOException {
		
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
	
	/**
	 * Method which connects to a given URL and returns a JsonObject representing the contents
	 * of the website.
	 * @param jsonURL - The URL which should be contacted to retrieve the API content
	 * @return The JSON contents of the website formatted as a JsonObject with the Gson library
	 * @throws IOException
	 */
	public JsonObject getApiResponseAsJsonObject(String jsonURL) throws IOException {
		
		String json = getApiResponse(jsonURL);
		JsonParser parser = new JsonParser();
		
		JsonObject response = parser.parse(json).getAsJsonObject();
		
		return response;
	}
	

}
