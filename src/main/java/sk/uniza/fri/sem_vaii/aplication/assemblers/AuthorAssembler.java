package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.domain.Author;

@Data
@RequiredArgsConstructor
public class AuthorAssembler {
    public static AuthorDTO toDto(Author author) {
        var authorDto = new AuthorDTO();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setLastName(author.getLastName());
        authorDto.setInfo(author.getInfo());
        authorDto.setAuthorBooks(author.getAuthorBooks());

        return authorDto;
    }

    public Author fromDto(AuthorDTO authorDto) {
        var author = new Author();

        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setLastName(authorDto.getLastName());
        author.setInfo(authorDto.getInfo());
        author.setAuthorBooks(authorDto.getAuthorBooks());

        return author;
    }
}
