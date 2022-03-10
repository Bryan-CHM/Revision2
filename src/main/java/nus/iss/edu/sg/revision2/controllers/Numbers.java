package nus.iss.edu.sg.revision2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/number")
public class Numbers {
    
    @GetMapping(path="/{randomNumber}")
    public String displayNumber(@PathVariable String randomNumber,Model model){
        Integer toDisplay = 0;
        try{
            toDisplay=Integer.parseInt(randomNumber);
        }catch(NumberFormatException e){
            model.addAttribute("num",randomNumber);
            return "numoutofrange";
        }
        if((toDisplay<0)||(toDisplay>30)){    
            model.addAttribute("num",toDisplay);
            return "numoutofrange";
        }

        model.addAttribute("num",toDisplay);
        return "number";
    }
}
