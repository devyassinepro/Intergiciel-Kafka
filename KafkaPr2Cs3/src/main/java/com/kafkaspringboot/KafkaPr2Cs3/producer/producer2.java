package com.kafkaspringboot.KafkaPr2Cs3.producer;


import com.kafkaspringboot.KafkaPr2Cs3.config.datakafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class producer2 {

    @Autowired
    private KafkaTemplate<String, String> kafkaall;

    private static final String TOPIC = "Kafka_topic2";
   // private static final String dataglobal = "globaldata";

    @GetMapping("/globaldata")
    public String postglobalvalues(Model model) {

        kafkaall.send(TOPIC, "globaldata");
        String pr="testYassine";
        model.addAttribute("produit",pr);

        return "Published successfully";
    }

    @GetMapping("/countryvalues/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaall.send(TOPIC, "name");

        return "Published successfully";
    }


    @GetMapping("/confirmedavg")
    public String postconfirmedavg() {

        kafkaall.send(TOPIC, "confirmedavg");

        return "Published successfully";
    }


    @GetMapping("/deathsavg")
    public String postdeathsavg() {

        kafkaall.send(TOPIC, "deathsavg");

        return "Published successfully";
    }



    @GetMapping("/countriesdeathspercent")
    public String postcountriesdeathspercent() {

        kafkaall.send(TOPIC, "countriesdeathspercent");

        return "Published successfully";
    }



}
