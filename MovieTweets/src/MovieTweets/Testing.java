package MovieTweets;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Testing {

		
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String location = "83440";
		URL url = new URL("http://www.google.com/movies?hl=en&near=" + location);
		
		System.out.println(url);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(url, Map.class);
		
		for (String key : map.keySet())
		{
		System.out.println(key + ": " + map.get(key));
		}
	}		
}
	