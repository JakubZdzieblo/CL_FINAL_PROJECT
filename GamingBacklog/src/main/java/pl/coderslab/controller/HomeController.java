package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.GamesSearchListElementDTO;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.Platform;
import pl.coderslab.entity.User;
import pl.coderslab.repository.*;
import pl.coderslab.service.DBService;
import pl.coderslab.service.GBQuery;

import javax.servlet.http.HttpSession;
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
    CommentRepository commentRepository;

    @Autowired
    GBQuery gbQuery;

    @Autowired
    DBService dbService;


    @RequestMapping({"/index"})
    public String index(Model model){
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
        Comment comment = null; //commentRepository.findFirstByGameGbId(gbId);
        Hibernate.initialize(game.getPlatforms());
        Hibernate.initialize(game.getConcepts());
        Hibernate.initialize(game.getGenres());
        Hibernate.initialize(game.getGameObjects());
        Hibernate.initialize(game.getLocations());
        Hibernate.initialize(game.getPublishers());
        Hibernate.initialize(game.getThemes());
        model.addAttribute("comment", comment);
        model.addAttribute("game", game);
        return("details");
    }

    @Transactional
    @GetMapping("/addToBacklog")
    public String addToBacklog(@RequestParam Long gbId, Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        user = userRepository.findByLogin(user.getLogin());
        dbService.addToBacklog(gbId, user.getId());
        Hibernate.initialize(user.getGames());
        model.addAttribute("user", user);
        return "backlog";
    }

    @Transactional
    @GetMapping("/removeFromBacklog")
    public String removeFromBacklog(@RequestParam Long gbId, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        dbService.removeFromBacklog(gbId, user.getId());
        user = userRepository.findByLogin(user.getLogin());
        Hibernate.initialize(user.getGames());
        model.addAttribute("user", user);
        return "redirect:backlog";
    }
    @Transactional
    @GetMapping("/backlog")
    public String backlog(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        user = userRepository.findByLogin(user.getLogin());
        Hibernate.initialize(user.getGames());
        model.addAttribute("user", user);
        return "backlog";
    }
}
