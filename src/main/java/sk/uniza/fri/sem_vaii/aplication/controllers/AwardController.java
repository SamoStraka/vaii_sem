package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AwardAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AwardDTO;
import sk.uniza.fri.sem_vaii.aplication.services.AwardService;
import sk.uniza.fri.sem_vaii.domain.Award;

import javax.validation.Valid;
import java.util.Comparator;

@RestController
@RequestMapping("/api/award")
@RequiredArgsConstructor
public class AwardController {
    private final AwardService awardService;

    @GetMapping("{id}")
    AwardDTO getAward(@PathVariable Long id) {
        Award award = awardService.getAward(id);
        return AwardAssembler.toDto(award);
    }

    @GetMapping()
    Iterable<AwardDTO> getAwards() {
        return awardService.getAwards().stream()
                .map(AwardAssembler::toDto)
                .sorted(Comparator.comparing(AwardDTO::getPriority))
                .toList();
    }

    @PostMapping()
    AwardDTO newAward(@Valid @RequestBody AwardDTO awardDTO) {
        if (awardService.getAward(awardDTO.getId()) != null) {
            throw new RuntimeException();
        }

        return AwardAssembler.toDto(awardService.addAward(awardDTO));
    }

    @DeleteMapping("{id}")
    void deleteAward(@PathVariable Long id) {
        awardService.deleteAward(id);
    }
}