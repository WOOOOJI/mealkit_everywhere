package com.admin.frame;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ChatBotUtil {
	private static String secretKey = "eFhWY2RGVGxGeWdjZUNvUmNqTVZHcnV2QU1Tak5ZZmQ=";
	private static String apiUrl = "https://aqshmquekl.apigw.ntruss.com/custom/v1/9260/2314155fd8345119666a2eb1e4a2dd85b8c37e4865ece00c7ef63b2fcf8a5c23";

	
	// NCP의 Chatbot api에 사용자가 입력한 txt를 던져 결과값 받기.
	public static String chat(String txt) throws IOException {
		URL url = new URL(apiUrl);
		String chatMessage = "";
		String message =  getReqMessage(txt);
		String encodeBase64String = makeSignature(message, secretKey);
		
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;UTF-8");
		con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		wr.write(message.getBytes("UTF-8"));
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		

		BufferedReader br;

		if(responseCode==200) { // 정상 호출

			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			String decodedString;
			String jsonString = "";
			while ((decodedString = in.readLine()) != null) {
				jsonString = decodedString;
			}
		
		
			JSONParser jsonparser = new JSONParser();
			try {
				// JSON 형태로 받아 문자열로 형변환 하여 뷰에 뿌린다.
				JSONObject json = (JSONObject)jsonparser.parse(jsonString);
				JSONArray bubblesArray = (JSONArray)json.get("bubbles");
				JSONObject bubbles = (JSONObject)bubblesArray.get(0);
				JSONObject data = (JSONObject)bubbles.get("data");
				String description = "";
				description = (String)data.get("description");
				chatMessage = data.toJSONString();
			} catch (Exception e) {
				System.out.println("error");
				e.printStackTrace();
			}

			in.close();

		} else {  // 에러 발생
			System.out.println("Error");

			chatMessage = con.getResponseMessage();
		}
		
		return chatMessage;
	}	
	
	
	
	
	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

		

			obj.put("version", "v2");
			obj.put("userId", "xxxx");
			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.add(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e){
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}
	public static String makeSignature(String message, String secretKey) {

		 String encodeBase64String = "";

	        try {
	            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

	            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
	            Mac mac = Mac.getInstance("HmacSHA256");
	            mac.init(signingKey);

	            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
	            encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);

	            return encodeBase64String;

	        } catch (Exception e){
	            System.out.println(e);
	        }

	        return encodeBase64String;

	}
}
