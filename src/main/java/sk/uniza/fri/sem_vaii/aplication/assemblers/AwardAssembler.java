package sk.uniza.fri.sem_vaii.aplication.assemblers;

import sk.uniza.fri.sem_vaii.aplication.dtos.AwardDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.domain.Award;
import sk.uniza.fri.sem_vaii.domain.Genre;

public class AwardAssembler {
    public static AwardDTO toDto(Award award) {
        var awardDto = new AwardDTO();

        awardDto.setId(award.getId());
        awardDto.setName(award.getName());
        awardDto.setPriority(award.getPriority());

        return awardDto;
    }

    public Award fromDto(AwardDTO awardDto) {
        var award = new Award();

        award.setId(awardDto.getId());
        award.setName(awardDto.getName());
        award.setPriority(awardDto.getPriority());

        return award;
    }
}
