package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AuthorAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.AuthorRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorAssembler authorAssembler;
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author addAuthor(AuthorDTO authorDTO) {
        var author = authorAssembler.fromDto(authorDTO);
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, AuthorDTO authorDTO) {
        var updated = authorAssembler.fromDto(authorDTO);

        if (authorRepository.existsById(id)) {
            updated.setId(id);
            authorRepository.save(updated);
        }

        return updated;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
