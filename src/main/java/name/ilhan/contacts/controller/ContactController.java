package name.ilhan.contacts.controller;

import name.ilhan.contacts.model.Contact;
import name.ilhan.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> allContacts() {
        return contactService.findAll();
    }
}
