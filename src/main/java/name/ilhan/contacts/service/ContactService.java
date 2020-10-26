package name.ilhan.contacts.service;

import name.ilhan.contacts.model.Contact;
import name.ilhan.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactsRepository;

    public List<Contact> findAll() {
        var it = contactsRepository.findAll();
        var contacts = new ArrayList<Contact>();
        it.forEach(e -> contacts.add(e));
        return contacts;
    }

    public Contact findById(Integer id) {
        Contact contact = contactsRepository.findById(id).get();
        return contact;
    }
}
