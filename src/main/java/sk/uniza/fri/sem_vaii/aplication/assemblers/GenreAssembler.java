package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.domain.Genre;

@Data
@RequiredArgsConstructor
public class GenreAssembler {
    public static GenreDTO toDto(Genre genre) {
        var genreDto = new GenreDTO();

        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        genreDto.setBooks(genre.getBooks());

        return genreDto;
    }

    public Genre fromDto(GenreDTO genreDTO) {
        var genre = new Genre();

        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        genre.setBooks(genreDTO.getBooks());

        return genre;
    }
}
