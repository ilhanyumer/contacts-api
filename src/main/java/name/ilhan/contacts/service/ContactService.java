package name.ilhan.contacts.service;

import name.ilhan.contacts.dto.ContactInput;
import name.ilhan.contacts.model.Contact;
import name.ilhan.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void deleteById(Integer id) {
        contactsRepository.deleteById(id);
    }

    public Contact createContact(ContactInput contactInput) {
        Contact contact = new Contact();
        contact.setName(contactInput.getName());
        contact.setSurname(contactInput.getSurname());
        return contactsRepository.save(contact);
    }

    public Contact fullyUpdateContact(Integer id, ContactInput contactInput) {
        Contact contact = new Contact();
        contact.setName(contactInput.getName());
        contact.setSurname(contactInput.getSurname());
        contact.setId(id);
        return contactsRepository.save(contact);
    }

    public Contact partialUpdateContact(Integer id, ContactInput contactInput) {
        Optional<Contact> contactOptional = contactsRepository.findById(id);
        Contact contact = contactOptional.get();
        contact.setId(id);
        if(contactInput.getName() != null) {
            contact.setName(contactInput.getName());
        }
        if(contactInput.getSurname() != null) {
            contact.setSurname(contactInput.getSurname());
        }
        return contactsRepository.save(contact);
    }
}
