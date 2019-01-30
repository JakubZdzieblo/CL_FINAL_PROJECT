package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.GameDetailsDTO;
import pl.coderslab.dto.GamesSearchListElementDTO;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.Platform;
import pl.coderslab.entity.User;
import pl.coderslab.repository.*;
import pl.coderslab.service.DBService;
import pl.coderslab.service.GBQuery;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GBQuery gbQuery;

    @Autowired
    DBService dbService;

    @RequestMapping("")
    public String home(Model model){
        Game game = dbService.randomGame();
        model.addAttribute("game", game);
        return "/index";
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam String query){
        List<GamesSearchListElementDTO> list = gbQuery.gameSearchResult(query, 20);
        model.addAttribute("list", list);
        return "results";
    }

    @GetMapping("/filter")
    public String filter(Model model){
        List<Platform> platforms = platformRepository.findAll();
        model.addAttribute("platforms", platforms);
        return("filter");
    }

    @PostMapping("/filter")
    public String filter(Model model, @RequestParam int platform, @RequestParam String dateFrom, @RequestParam String dateTo){

        LocalDate date1 = LocalDate.parse(dateFrom);
        LocalDate date2 = LocalDate.parse(dateTo);
        List<GamesSearchListElementDTO> list = gbQuery.gameFilterResult(platform, date1, date2, 20);
        model.addAttribute("list", list);
        return "results";
    }

    @Transactional
    @GetMapping("/details")
    public String details(Model model, @RequestParam Long gbId){
        Game game = dbService.getGame(gbId);
        Hibernate.initialize(game.getPlatforms());
        Hibernate.initialize(game.getConcepts());
        Hibernate.initialize(game.getGenres());
        Hibernate.initialize(game.getGameObjects());
        Hibernate.initialize(game.getLocations());
        Hibernate.initialize(game.getPublishers());
        Hibernate.initialize(game.getThemes());
        model.addAttribute("game", game);
        return("details");
    }

    @Transactional
    @GetMapping("/addToBacklog")
    public String addToBacklog(@RequestParam Long gbId, Model model) {

        User user = userRepository.findByLogin("jdoe");
        dbService.addToBacklog(gbId, user.getId());
        Hibernate.initialize(user.getGames());
        // Hibernate.initialize(user.getCompletedGames());
        model.addAttribute("user", user);
        return "backlog";
    }
}
