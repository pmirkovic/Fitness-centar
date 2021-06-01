package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import com.example.FitnessCetnar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TreningController {
  /* @Autowired
    private TreningService treningService;

    @GetMapping("/treninzi")
    public String treninzi(Model model){
        TreningDTO treningDTO=this.treningService.getPodaci();
        model.addAttribute("treningDTO",treningDTO);
        return "treninzi.html";
    }

    @GetMapping("/trening/{id}")
    public String getTrening(@PathVariable(name = "id") Long id,Model model){
        Trening trening = this.treningService.findOne(id);
        model.addAttribute("trening",trening);
        return "trening.html";
    }*/
}
