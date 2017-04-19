package com.pelotonbook.controllers;

import com.pelotonbook.models.Rider;
import com.pelotonbook.models.User;
import com.pelotonbook.models.data.RiderDao;
import com.pelotonbook.models.data.UserDao;
import com.pelotonbook.models.forms.AddFollowedRiderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Kevin on 4/17/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RiderDao riderDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDao.findAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add a user to the DB");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid User newUser,
                                 Errors errors,
                                 Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a user to the DB");
            return "user/add";
        }

        userDao.save(newUser);
        return "redirect:";
    }

    @RequestMapping(value = "view/{userId}", method = RequestMethod.GET)
    private String viewUser(Model model, @PathVariable("userId") int userId) {
        User user = userDao.findOne(userId);
        model.addAttribute("user", user);
        model.addAttribute("title", user.getUsername());
        model.addAttribute("riders", user.getRiders());
        return "user/view";
    }

    @RequestMapping(value = "add-rider/{userId}", method = RequestMethod.GET)
    private String followRider(Model model, @PathVariable("userId") int userId) {
        User user = userDao.findOne(userId);
        AddFollowedRiderForm followedRiderForm = new AddFollowedRiderForm(user, riderDao.findAll());
        model.addAttribute("form", followedRiderForm);
        model.addAttribute("title", "Add rider/s to follow!");
        return "user/add-rider";
    }

    @RequestMapping(value = "add-rider/{userId}", method = RequestMethod.POST)
    private String processFollowRider(Model model, @ModelAttribute AddFollowedRiderForm filledOutForm, @RequestParam int userId) {
        User user = userDao.findOne(userId);
        Rider rider = riderDao.findOne(filledOutForm.getRiderId());
        user.addItem(rider);
        userDao.save(user);
        return "redirect:/user/view/" + userId;

    }


}
