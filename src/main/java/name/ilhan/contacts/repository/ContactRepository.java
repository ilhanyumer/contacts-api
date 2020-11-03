package name.ilhan.contacts.repository;

import name.ilhan.contacts.model.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
    @Override
    default List<Contact> findAll() {
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    List<Contact> findAll(Sort id);
}
