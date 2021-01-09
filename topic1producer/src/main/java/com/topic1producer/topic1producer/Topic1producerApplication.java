package com.topic1producer.topic1producer;

import com.topic1producer.topic1producer.config.HttpHandler;
import com.topic1producer.topic1producer.model.Countries;
import com.topic1producer.topic1producer.model.Global;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Topic1producerApplication {
	@Autowired
	private KafkaTemplate<String, Countries> kafkacountries;
	@Autowired
	private KafkaTemplate<String, Global> kafadata;

	private static final String TOPIC = "topic1";
	public static void main(String[] args) {

		SpringApplication.run(Topic1producerApplication.class, args);
	}

	@Scheduled(fixedRate=30000)
	@Bean
	CommandLineRunner runner(){
		return args -> {

			HttpHandler sh = new HttpHandler();
			// Making a request to url and getting response
			String url = "https://api.covid19api.com/summary";
			String jsonStr = sh.makeServiceCall(url);
			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);
					//JSONArray global = jsonObj.getJSONArray("Global");
					JSONObject glob = jsonObj.getJSONObject("Global");


					String gNewConfirmed = glob.getString("NewConfirmed");
					String gTotalConfirmed = glob.getString("TotalConfirmed");
					String gNewDeaths = glob.getString("NewDeaths");
					String gTotalDeaths = glob.getString("TotalDeaths");
					String gNewRecovered = glob.getString("NewRecovered");
					String gTotalRecovered = glob.getString("TotalRecovered");


					System.out.println("Global value Touzani = "+gNewConfirmed);
					kafadata.send(TOPIC,new Global(gNewConfirmed,gTotalConfirmed,gNewDeaths,gTotalDeaths,gNewRecovered,gTotalRecovered));


					// JSONObject G = glob.getJSONObject();


					// looping through All Countries
					// Getting JSON Array Countries
					JSONArray Countries = jsonObj.getJSONArray("Countries");

					for (int i = 1; i < Countries.length(); i++) {
						JSONObject c = Countries.getJSONObject(i);
						String country = c.getString("Country");
						String countryCode = c.getString("CountryCode");
						String slug = c.getString("Slug");
						String newConfirmed = c.getString("NewConfirmed");
						String totalConfirmed = c.getString("TotalConfirmed");
						String newDeaths = c.getString("NewDeaths");
						String totalDeaths = c.getString("TotalDeaths");
						String newRecovered = c.getString("NewRecovered");
						String totalRecovered = c.getString("TotalRecovered");
						String date = c.getString("Date");

						kafkacountries.send(TOPIC, new Countries(country,countryCode,slug,newConfirmed,totalConfirmed,newDeaths,totalDeaths,newRecovered,totalRecovered,date));
					}



				} catch (final JSONException e) {
					System.out.println("Json parsing error: " + e.getMessage());
				}

			} else {
				System.out.println("Couldn't get json from server");

			}

		};
	}

}
