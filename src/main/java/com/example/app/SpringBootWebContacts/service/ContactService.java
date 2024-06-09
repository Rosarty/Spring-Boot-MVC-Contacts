package com.example.app.SpringBootWebContacts.service;

import com.example.app.SpringBootWebContacts.entity.Contact;
import com.example.app.SpringBootWebContacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> fetchAll() {
        return contactRepository.findAll();
    }

    public Contact fetchById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void create(Contact contact) {
        contactRepository.save(contact);
    }

    public void update(Contact contact) {
        if (contact.getId() != null) {
            contactRepository.save(contact);
        }
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
