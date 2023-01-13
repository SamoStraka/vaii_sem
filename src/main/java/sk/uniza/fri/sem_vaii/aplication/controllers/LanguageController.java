package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.fri.sem_vaii.aplication.assemblers.LanguageAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.LanguageDTO;
import sk.uniza.fri.sem_vaii.aplication.services.LanguageService;

@RestController
@RequestMapping("/api/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping()
    Iterable<LanguageDTO> getLanguages() {
        return languageService.getLanguages().stream()
                .map(LanguageAssembler::toDto).toList();
    }
}
