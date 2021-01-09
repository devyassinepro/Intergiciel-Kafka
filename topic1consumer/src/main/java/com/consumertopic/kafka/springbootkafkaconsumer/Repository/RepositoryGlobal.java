package com.consumertopic.kafka.springbootkafkaconsumer.Repository;


import com.consumertopic.kafka.springbootkafkaconsumer.model.Globale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGlobal extends JpaRepository<Globale,Long> {
}
