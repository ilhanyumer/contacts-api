package name.ilhan.contacts.controller;

import io.swagger.annotations.ApiOperation;
import name.ilhan.contacts.dto.ContactInput;
import name.ilhan.contacts.model.Contact;
import name.ilhan.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all contacts")
    public List<Contact> allContacts() {
        return contactService.findAll();
    }

    @GetMapping(value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a contact")
    public Contact getContact(
            @PathVariable Integer id
    ) {
        return contactService.findById(id);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(
            @PathVariable Integer id
    ) {
        contactService.deleteById(id);
    }

    @PostMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a contact")
    public Contact createContact(
            @RequestBody
            ContactInput contact
    ) {
        return contactService.createContact(contact);
    }

    @PutMapping(value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update the contact with all attributes")
    public Contact fullyUpdateContact(
            @PathVariable
            Integer id,

            @RequestBody
            ContactInput contact
    ) {
        return contactService.fullyUpdateContact(id, contact);
    }

    @PatchMapping(value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update the contact with all attributes")
    public Contact partialUpdateContact(
            @PathVariable Integer id,
            @RequestBody ContactInput contact
    ) {
        return contactService.partialUpdateContact(id, contact);
    }
}
