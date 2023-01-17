package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AuthorAssembler;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ContactAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.ContactDTO;
import sk.uniza.fri.sem_vaii.aplication.services.ContactService;

import javax.validation.Valid;
import java.util.Comparator;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping()
    Iterable<ContactDTO> getContacts() {
        return contactService.getContacts().stream()
                .map(ContactAssembler::toDto)
                .sorted(Comparator.comparing(ContactDTO::getSolved))
                .toList();
    }

    @PutMapping("{id}")
    ContactDTO replaceContact(@Valid @RequestBody ContactDTO contactDTO, @PathVariable Long id) {
        return ContactAssembler.toDto(contactService.updateContact(id, contactDTO));
    }

    @PostMapping()
    ContactDTO newContact(@Valid @RequestBody ContactDTO contactDTO) {
        if (contactService.getContact(contactDTO.getId()) != null) {
            throw new RuntimeException();
        }

        return ContactAssembler.toDto(contactService.addContact(contactDTO));
    }

    @DeleteMapping("{id}")
    void deleteAuthor(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
