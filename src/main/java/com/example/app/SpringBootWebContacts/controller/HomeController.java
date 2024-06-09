package com.example.app.SpringBootWebContacts.controller;

import com.example.app.SpringBootWebContacts.entity.Contact;
import com.example.app.SpringBootWebContacts.service.ContactService;
import com.example.app.SpringBootWebContacts.service.ResortService;
import com.example.app.SpringBootWebContacts.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class HomeController {

    private final PlaceService placeService;
    private final ResortService resortService;
    private final ContactService contactService;

    @Autowired
    public HomeController(PlaceService placeService, ResortService resortService, ContactService contactService) {
        this.placeService = placeService;
        this.resortService = resortService;
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String getHome(Model model) throws URISyntaxException, IOException {
        List<Contact> contacts = contactService.fetchAll();
        model.addAttribute("places", placeService.getTours());
        model.addAttribute("resorts", resortService.getResorts());
        model.addAttribute("contacts", contacts);
        model.addAttribute("contact", new Contact()); // Додали пустий об'єкт для форми додавання
        return "home";
    }

    @PostMapping("/add-contact")
    public String createContact(@ModelAttribute Contact contact, Model model) {
        contactService.create(contact);
        return "redirect:/"; // Після додавання контакту перенаправляємо на домашню сторінку
    }

    @GetMapping("/update-contact/{id}")
    public String showUpdateContactForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.fetchById(id);
        model.addAttribute("contact", contact);
        return "contacts/update";
    }

    @PostMapping("/update-contact")
    public String updateContact(@ModelAttribute Contact contact) {
        contactService.update(contact);
        return "redirect:/";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.delete(id);
        return "redirect:/"; // Після видалення контакту перенаправляємо на домашню сторінку
    }
}
