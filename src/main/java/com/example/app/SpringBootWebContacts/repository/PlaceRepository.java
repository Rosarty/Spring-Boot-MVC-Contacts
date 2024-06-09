package com.example.app.SpringBootWebContacts.repository;

import com.example.app.SpringBootWebContacts.entity.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}
