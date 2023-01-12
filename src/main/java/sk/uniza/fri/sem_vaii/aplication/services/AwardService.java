package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AwardAssembler;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AwardDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.AwardRepository;
import sk.uniza.fri.sem_vaii.aplication.repositories.GenreRepository;
import sk.uniza.fri.sem_vaii.domain.Award;
import sk.uniza.fri.sem_vaii.domain.Genre;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class AwardService {
    private final AwardAssembler awardAssembler;
    private final AwardRepository awardRepository;

    public List<Award> getAwards() {
        return awardRepository.findAll();
    }

    public Award getAward(Long id) {
        return awardRepository.findById(id).orElse(null);
    }

    public Award addAward(AwardDTO awardDTO) {
        return awardRepository.save(awardAssembler.fromDto(awardDTO));
    }

    public void deleteAward(Long id) {
        awardRepository.deleteById(id);
    }
}
