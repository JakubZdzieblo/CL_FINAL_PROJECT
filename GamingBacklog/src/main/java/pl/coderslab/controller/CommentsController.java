package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.repository.GameRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/comments")
public class CommentsController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("addComment")
    public String addComment(@RequestParam Long gbId, Model model){
        User user = userRepository.findByLogin("jdoe");
        model.addAttribute("gbId", gbId);
        model.addAttribute("user", user);
        return "commentForm";
    }


}
