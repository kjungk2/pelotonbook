package com.pelotonbook.controllers;

import com.pelotonbook.models.RaceDayEntity;
import com.pelotonbook.models.data.RaceDayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin on 4/30/2017.
 */
@Controller
@RequestMapping("pelotonbook")
public class HomeController {

    @Autowired
    private RaceDayDao raceDayDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        // get top ten ranked riders for the race
        ArrayList<RaceDayEntity> topTen = new ArrayList<RaceDayEntity>();
        String raceday = "";
        for (RaceDayEntity raceDayEntity : raceDayDao.findAll()) {

            // if this rider's rank is 1-5, add him to the list of names to send to view
            int rank = Integer.parseInt(raceDayEntity.getRank());
            if (0 < rank && rank < 11) {
                topTen.add(raceDayEntity);
                raceday = raceDayEntity.getRaceday();
            }
        }

        //RaceDayEntity rider = raceDayDao.findOne(200);
        //model.addAttribute("results", rider.getName());

        model.addAttribute("raceday", raceday);
        model.addAttribute("topTenRiders", topTen);
        model.addAttribute("title", "PelotonBook");
        return "pelotonbook/index";
    }

    @RequestMapping(value = "results/{raceday}", method = RequestMethod.GET)
    private String viewResults(Model model, @PathVariable("raceday") String raceday) {

        //ArrayList<RaceDayEntity> fullResults = new ArrayList<RaceDayEntity>();
        Iterable fullResults = raceDayDao.findAll();
        model.addAttribute("fullResults", fullResults);
        return "pelotonbook/results";
    }

}
