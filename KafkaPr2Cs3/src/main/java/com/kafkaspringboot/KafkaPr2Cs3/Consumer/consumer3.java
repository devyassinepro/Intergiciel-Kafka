package com.kafkaspringboot.KafkaPr2Cs3.Consumer;


import com.kafkaspringboot.KafkaPr2Cs3.config.datakafka;
import org.apache.tomcat.jni.Global;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class consumer3 {


    @KafkaListener(topics = "Kafka_topic3", groupId = "group_id",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(String global) {

   datakafka  data = new datakafka(global);

    System.out.println("Our Global ID "+global);
    }

}
