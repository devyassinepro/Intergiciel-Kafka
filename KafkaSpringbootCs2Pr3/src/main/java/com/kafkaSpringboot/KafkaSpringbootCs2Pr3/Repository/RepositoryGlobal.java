package com.kafkaSpringboot.KafkaSpringbootCs2Pr3.Repository;



import com.kafkaSpringboot.KafkaSpringbootCs2Pr3.model.Globale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryGlobal extends JpaRepository<Globale,Long> {

//   List<Globale> findByLastName(String lastName);

    Globale findById(long id);

}
