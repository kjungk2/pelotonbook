package com.pelotonbook.controllers;

import com.pelotonbook.models.Rider;
import com.pelotonbook.models.data.RiderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Kevin on 4/17/2017.
 */
@Controller
@RequestMapping("rider")
public class RiderController {

    @Autowired
    private RiderDao riderDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Administrator View");
        model.addAttribute("riders", riderDao.findAll());
        return "rider/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Add a rider to the DB");
        model.addAttribute(new Rider());
        return "rider/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid Rider newRider,
                                 Errors errors,
                                 Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a rider to the DB");
            return "rider/add";
        }

        riderDao.save(newRider);
        return "redirect:";
    }

}
