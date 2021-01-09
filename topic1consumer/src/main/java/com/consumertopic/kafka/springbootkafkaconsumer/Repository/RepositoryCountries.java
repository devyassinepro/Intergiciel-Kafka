package com.consumertopic.kafka.springbootkafkaconsumer.Repository;

import com.consumertopic.kafka.springbootkafkaconsumer.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCountries extends JpaRepository<Countries,Long> {
}
