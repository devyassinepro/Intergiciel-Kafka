package com.kafkaSpringboot.KafkaSpringbootCs2Pr3.Repository;

import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCountries extends JpaRepository<Countries,Long> {

    //Countries findByCountry(String Country);
    //List<Countries> findByCountry(String Country);

    //List<Countries> findByNameCount(String Country);

}
