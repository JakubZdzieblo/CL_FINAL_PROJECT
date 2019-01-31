package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login/login";
    }

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "login/register";
    }

    @PostMapping("/check")
    public String checkLogin(@Valid User user, BindingResult errors, HttpSession session, HttpServletRequest request, Model model){
        if (errors.hasErrors()) {
            return "login/login";
        }

        if (userService.loginUser(user.getLogin(), user.getPassword(), session)){
            return "redirect:"+request.getContextPath()+"/";
        }
        return "login/login";
    }

    @PostMapping("/save")
    private String save(@Valid User user,
                        BindingResult errors,
                        @RequestParam String repeatedPassword,
                        HttpServletRequest request,
                        Model model) {
        if(errors.hasErrors()){
            return "login/register";
        }
        try {
            userService.registerUser(user, repeatedPassword);
        } catch (Exception e) {
            model.addAttribute("error", "Passwords do not match");
            return "login/register";
        }
        return "redirect:"+request.getContextPath()+"/login";
    }

}
