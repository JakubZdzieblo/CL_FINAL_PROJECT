package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.GameDetailsDTO;
import pl.coderslab.dto.GamesSearchListElementDTO;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.Platform;
import pl.coderslab.repository.*;
import pl.coderslab.service.DBService;
import pl.coderslab.service.GBQuery;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    GBQuery gbQuery;

    @Autowired
    DBService dbService;

    @RequestMapping("")
    public String home(Model model){
        GameDetailsDTO gameDetailsDTO = gbQuery.randomGameDetails();
        Game game = dbService.getGameFromDTO(gameDetailsDTO);
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
}
