package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.LanguageDTO;
import sk.uniza.fri.sem_vaii.domain.Language;

@Data
@RequiredArgsConstructor
public class LanguageAssembler {
    public static LanguageDTO toDto(Language language) {
        var languageDto = new LanguageDTO();

        languageDto.setId(language.getId());
        languageDto.setName(language.getName());
        languageDto.setBooks(language.getBooks());

        return languageDto;
    }

    public Language fromDto(LanguageDTO languageDTO) {
        var language = new Language();

        language.setId(languageDTO.getId());
        language.setName(languageDTO.getName());
        language.setBooks(languageDTO.getBooks());

        return language;
    }
}
