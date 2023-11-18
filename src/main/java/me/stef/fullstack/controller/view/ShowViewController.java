package me.stef.fullstack.controller.view;

import me.stef.fullstack.dto.ShowDTO;
import me.stef.fullstack.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShowViewController {

    @Autowired
    private ShowService service;

    @GetMapping("/shows")
    public String getShows(Model model) {
        List<ShowDTO> shows = service.getShows();
        model.addAttribute("stef", shows);
        return "shows";
    }

    @GetMapping("/shows/create")
    public String getShowsCreat(Model model) {
        return "admin";
    }
}
