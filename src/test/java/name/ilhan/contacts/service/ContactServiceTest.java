package name.ilhan.contacts.service;

import name.ilhan.contacts.model.Contact;
import name.ilhan.contacts.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @Test
    void shouldReturnfindAll() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Fred", "Flintstones"));
        contactList.add(new Contact(2, "Barney", "Rubble"));

        given(contactRepository.findAll()).willReturn(contactList);

        List<Contact> expected = contactService.findAll();
        assertEquals(expected, contactList);
    }
}
