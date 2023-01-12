package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.GenreRepository;
import sk.uniza.fri.sem_vaii.domain.Genre;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class GenreService {
    private final GenreAssembler genreAssembler;
    private final GenreRepository genreRepository;

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre addGenre(GenreDTO genreDTO) {
        return genreRepository.save(genreAssembler.fromDto(genreDTO));
    }

    public Genre updateGenre(Long id, GenreDTO genreDTO) {
        var updated = genreAssembler.fromDto(genreDTO);

        if (genreRepository.existsById(id)) {
            updated.setId(id);
            genreRepository.save(updated);
        }

        return updated;
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
