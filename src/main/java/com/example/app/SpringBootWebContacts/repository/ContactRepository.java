package com.example.app.SpringBootWebContacts.repository;


import com.example.app.SpringBootWebContacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}


