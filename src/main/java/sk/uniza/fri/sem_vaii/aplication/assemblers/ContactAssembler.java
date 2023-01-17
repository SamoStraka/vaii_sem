package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.ContactDTO;
import sk.uniza.fri.sem_vaii.domain.Contact;

@Data
@RequiredArgsConstructor
public class ContactAssembler {

    public static ContactDTO toDto(Contact contact) {
        var contactDto = new ContactDTO();

        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setEmail(contact.getEmail());
        contactDto.setSubject(contact.getSubject());
        contactDto.setMessage(contact.getMessage());
        contactDto.setSolved(contact.getSolved());

        return contactDto;
    }

    public static Contact fromDto(ContactDTO contactDto) {
        var contact = new Contact();

        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setSubject(contactDto.getSubject());
        contact.setMessage(contactDto.getMessage());
        contact.setSolved(contactDto.getSolved());

        return contact;
    }
}
