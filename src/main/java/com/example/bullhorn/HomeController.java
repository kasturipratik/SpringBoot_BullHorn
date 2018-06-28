package com.example.bullhorn;


import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    BullHornRepository bullHornRepository;

    @Autowired
    CloudinaryConfig cloudc;

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
    public String processTwits(@Valid @ModelAttribute("twits") BullHorn twits,
                               BindingResult result, @RequestParam("file")MultipartFile file){

        if(result.hasErrors() ){
            return "twitsForm";
        }

        if(file.isEmpty()){
            return "redirect:/add";
        }
        try {

            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));

            twits.setHeadshot(uploadResult.get("url").toString());

            bullHornRepository.save(twits);
        }catch (IOException e) {
            e.printStackTrace();
            return "redirect:/add";
        }

        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showTwits(@PathVariable("id") long id, Model model){
        model.addAttribute("twits",bullHornRepository.findById(id).get());
        return "showTwits";
    }

}
