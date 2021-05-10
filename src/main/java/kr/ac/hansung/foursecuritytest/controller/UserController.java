package kr.ac.hansung.foursecuritytest.controller;

import kr.ac.hansung.foursecuritytest.entity.Role;
import kr.ac.hansung.foursecuritytest.entity.User;
import kr.ac.hansung.foursecuritytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model) {

        if (userService.checkEmailExists(user.getEmail())) {
            model.addAttribute("emailExists", true);
            return "signup";
        }
        else {
            Role role = userService.findByRolename("ROLE_USER");

            List<Role> userRoles = new ArrayList<>();
            userRoles.add(role);

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }
}
