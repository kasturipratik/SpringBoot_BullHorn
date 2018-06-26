package com.example.bullhorn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BullHornRepository bullHornRepository;

    @RequestMapping("/")
    public String listTwits(Model model){

        model.addAttribute("bullHorn",bullHornRepository.findAll());
        return "listTwits";
    }

    @GetMapping("/add")
    public String twitsForm(Model model){
        model.addAttribute("twits",new BullHorn());
        return "twitsForm";
    }

    @PostMapping("/process")
    public String processTwits(@Valid BullHorn twits, BindingResult result){
        if(result.hasErrors()){
            return "twitsForm";
        }
        bullHornRepository.save(twits);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showTwits(@PathVariable("id") long id, Model model){
        model.addAttribute("twits",bullHornRepository.findById(id).get());
        return "showTwits";
    }

}
