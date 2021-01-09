package com.kafkaspringboot.KafkaPr2Cs3.config;

public class datakafka {

    private int id;
    private String mydatakafka;

    public datakafka(String mydatakafka) {
        this.mydatakafka = mydatakafka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMydatakafka() {
        return mydatakafka;
    }

    public void setMydatakafka(String mydatakafka) {
        this.mydatakafka = mydatakafka;
    }

    @Override
    public String toString() {
        return "datakafka{" +
                "id=" + id +
                ", mydatakafka='" + mydatakafka + '\'' +
                '}';
    }
}
