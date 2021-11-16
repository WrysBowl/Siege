package net.siegerpg.siege.core.miscellaneous;

import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class Discord {

	private static final String DISCORD_TOKEN = "";

	/* True if successful, False if failed */
	public static boolean sendMessage(String messageContent, int channelId) {

		Gson gson = new Gson();

		HttpClient client = HttpClientBuilder
				.create()
				.build();
		try {
			HttpPost request = new HttpPost(
					"https://discord.com/api/v6/channels/" + channelId + "/messages");
			// StringEntity parameters = new StringEntity(jsonObject.toString());
			request.addHeader(HttpHeaders.AUTHORIZATION, "Bot " + DISCORD_TOKEN);
			// request.setEntity(parameters);
			client.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
