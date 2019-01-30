package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dto.GameDetailsDTO;
import pl.coderslab.entity.Concept;
import pl.coderslab.entity.Game;
import pl.coderslab.repository.*;
import pl.coderslab.service.DBService;
import pl.coderslab.service.GBQuery;

@Controller
public class HomeController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ConceptRepository conceptRepository;

    @Autowired
    GameObjectRepository gameObjectRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    GBQuery gbQuery;

    @Autowired
    DBService dbService;

    @RequestMapping("")
    @ResponseBody
    public String home(){
        GameDetailsDTO gameDetailsDTO = gbQuery.gameDetails(45148L);
        Game game = dbService.getGameFromDTO(gameDetailsDTO);

        System.out.println(game.getId());
        System.out.println(game.getGbId());
        System.out.println(game.getName());

        for (Concept concept : game.getConcepts()) {
            System.out.println(concept.getName());
        }
        return game.getDescription();
    }
}
