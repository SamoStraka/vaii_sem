package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ContactAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.ContactDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.ContactRepository;
import sk.uniza.fri.sem_vaii.domain.Contact;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ContactService {
    private final ContactAssembler contactAssembler;
    private final ContactRepository contactRepository;

    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    public Contact addContact(ContactDTO contactDTO) {
        return contactRepository.save(contactAssembler.fromDto(contactDTO));
    }

    public Contact updateContact(Long id, ContactDTO contactDTO) {
        var updated = contactAssembler.fromDto(contactDTO);

        if (contactRepository.existsById(id)) {
            updated.setId(id);
            contactRepository.save(updated);
        }

        return updated;
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
