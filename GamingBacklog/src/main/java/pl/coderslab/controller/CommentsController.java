package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Game;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.GameRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentsController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("addComment")
    public String addComment(@RequestParam Long gbId, Model model){
        model.addAttribute("gbId", gbId);
        model.addAttribute("comment", new Comment());
        return "commentForm";
    }

    @PostMapping("save")
    public String save(@Valid Comment comment, BindingResult errors,
                       @RequestParam Long gbId, HttpSession session, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("gbId", gbId);
            return "/commentForm";
        }
        Game game = gameRepository.findByGbId(gbId);
        User user = (User) session.getAttribute("user");
        comment.setGame(game);
        comment.setUser(user);
        comment.setText(HtmlUtils.htmlEscape(comment.getText()));
        commentRepository.save(comment);
        return "redirect:/details?gbId="+gbId;
    }


}
