package com.kafkaSpringboot.KafkaSpringbootCs2Pr3.Consumer;


import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.Repository.RepositoryCountries;
import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.Repository.RepositoryGlobal;
import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.model.Countries;
import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.model.Globale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequestMapping("kafka")
public class consumer2 {

    private static final Logger log = LoggerFactory.getLogger(consumer2.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaall;

    private static final String TOPIC = "Kafka_topic3";

    @Autowired
    private RepositoryGlobal repositoryGlobal;

    @Autowired
    private RepositoryCountries repositoryCount;

    @KafkaListener(topics = "Kafka_topic2", groupId = "group_id",
            containerFactory = "kafkaListenerContainerFactory")

    public void consumeJson(String request) {


        String result = request.replaceAll("^[\"']+|[\"']+$", "");
        System.out.println(result); // => some string
        Globale myinnn = repositoryGlobal.findById(1L);

     //   repositoryCount.findByCountry(result);

        if(result.equals("globaldata")){
            String Printallglobale =  myinnn.toString();
            kafkaall.send(TOPIC,Printallglobale);

        }
        else if(result.equals("confirmedavg")){
            int gTotalConfirmed = myinnn.getTotalConfirmed();
            int confirmed_avg=gTotalConfirmed/192;
            String stringconfirmed_avg=String.valueOf(confirmed_avg);
            kafkaall.send(TOPIC,stringconfirmed_avg);

           // System.out.println("moyenne des cas confirmés : :: " +confirmed_avg);

        }
        else if(result.equals("deathsavg")){
            int gTotalDeaths = myinnn.getTotalDeaths();
            int deathallavg=gTotalDeaths/192;
            String strindeathallavg=String.valueOf(deathallavg);

            kafkaall.send(TOPIC,strindeathallavg);

          //  System.out.println("moyenne des Décès : :: " +strindeathallavg);

        }
        else if (result.equals("countriesdeathspercent")){
            int gTotalConfirmed = myinnn.getTotalConfirmed();
            int gTotalDeaths = myinnn.getTotalDeaths();
            int deathspercent=gTotalDeaths*100/gTotalConfirmed;
            String strindeathspercent=String.valueOf(deathspercent);

            kafkaall.send(TOPIC,strindeathspercent);

           // System.out.println("pourcentage de Décès : :: " +deathspercent+"%");

        }
        else{

            String countryall =repositoryCount.toString();
          //  kafkaall.send(TOPIC,countryall);
            System.out.println("Error Commande Not Found"+countryall);

        }




    }



}
