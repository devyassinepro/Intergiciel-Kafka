package com.consumertopic.kafka.springbootkafkaconsumer.listener;

import com.consumertopic.kafka.springbootkafkaconsumer.Repository.RepositoryCountries;
import com.consumertopic.kafka.springbootkafkaconsumer.Repository.RepositoryGlobal;
import com.consumertopic.kafka.springbootkafkaconsumer.model.Countries;
import com.consumertopic.kafka.springbootkafkaconsumer.model.Globale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private RepositoryCountries repositoryCountries;


    @Autowired
    private RepositoryGlobal repositoryGlobal;

    @KafkaListener(topics = "topic1", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void countryjson(Countries countries) {



   // String id = countries.getId();
       String Country= countries.getCountry();
        String CountryCode = countries.getCountryCode();
        String Slug = countries.getSlug();
       String NewConfirmed = countries.getNewConfirmed();
        String TotalConfirmed = countries.getTotalConfirmed();
        String NewDeaths = countries.getNewDeaths();
        String TotalDeaths = countries.getTotalDeaths();
        String NewRecovered = countries.getNewRecovered();
        String TotalRecovered = countries.getTotalRecovered();
        String Date = countries.getDate();
        repositoryCountries.save(new Countries(Country,CountryCode,Slug,NewConfirmed,TotalConfirmed,NewDeaths,TotalDeaths,NewRecovered,TotalRecovered,Date));
        System.out.println(countries.toString());

    }


    @KafkaListener(topics = "topic1", group = "group_json1",
            containerFactory = "globalKafkaListenerFactory")
    public void jsonglobal(Globale global) {

        int gNewConfirmed = global.getNewConfirmed();
        int gTotalConfirmed = global.getTotalConfirmed();
        int gNewDeaths = global.getNewDeaths();
        int gTotalDeaths = global.getTotalDeaths();
        int gNewRecovered = global.getNewRecovered();
        int gTotalRecovered = global.getTotalRecovered();

        repositoryGlobal.save(new Globale(gNewConfirmed,gTotalConfirmed,gNewDeaths,gTotalDeaths,gNewRecovered,gTotalRecovered));
        System.out.println(global.toString());
    }




}
