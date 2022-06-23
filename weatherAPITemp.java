// package com.javainterviewpoint;

import java.io.*;
import java.net.*;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONObject;

class ReadURL
{
	public static void main(String[] args)
	{
		try
		{
			PrintInput obj = new PrintInput();
			String city = obj.input("Enter City Name: ");
			URL url = new URL ("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=e6b7427f8bf97526adf2869093c7509c&units=metric");
			
			URLConnection connec = url.openConnection();
			InputStream isr = connec.getInputStream();

			// Dictionary<Integer, String> input = new Hashtable<Integer, String>();

			String input = IOUtils.toString(isr, StandardCharsets.UTF_8);
			
			JSONObject jsonObj = new JSONObject(input);
			JSONObject jo = (JSONObject)jsonObj.get("main");
			System.out.println(jo.get("temp"));
			
			// System.out.println(input);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
































// // package com.javainterviewpoint;

// import java.io.*;
// import java.net.*;
// import org.apache.commons.io.IOUtils;
// import java.nio.charset.StandardCharsets;

// class ReadURL
// {
// 	public static void main(String[] args)
// 	{
// 		try
// 		{
// 			URL url = new URL ("https://api.openweathermap.org/data/2.5/weather?q=Warangal&appid=e6b7427f8bf97526adf2869093c7509c&units=metric");
			
// 			URLConnection connec = url.openConnection();
// 			InputStream isr = connec.getInputStream();

// 			String input = IOUtils.toString(isr, StandardCharsets.UTF_8);
// 			System.out.println(input);
// 		}
// 		catch (Exception e)
// 		{
// 			System.out.println(e);
// 		}
// 	}
// }
























// "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=e6b7427f8bf97526adf2869093c7509c&units=metric"
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// // import org.
// import org.apache.http.HttpResponse;
// import org.apache.http.client.ClientProtocolException;
// import org.apache.http.client.HttpClient;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.impl.client.DefaultHttpClient;
// class Test {
//  public static void main(String[] args) throws ClientProtocolException, IOException {
//   HttpClient client = new DefaultHttpClient();
//   HttpGet request = new HttpGet("http://localhost:3161/devices/simulator/stop");
//   HttpResponse response = client.execute(request);
//   BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
//   String line = "";
//   while ((line = rd.readLine()) != null) {
//     System.out.println(line);
//   }
//  }
// }