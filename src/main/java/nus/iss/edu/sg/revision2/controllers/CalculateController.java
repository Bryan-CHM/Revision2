package nus.iss.edu.sg.revision2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculate")
public class CalculateController {
    
    @GetMapping()
    public String getCalculate(Model model){
        return "calculate";
    }

    @PostMapping()
    public String postCalculate(@RequestBody MultiValueMap<String,String> form, Model model){
        String firstNum = form.getFirst("firstNum");
        String secondNum = form.getFirst("secondNum");
        String ari = form.getFirst("ari");
        Integer firstParse = 0;
        Integer secondParse = 0;
        try {
            firstParse = Integer.parseInt(firstNum);
        } catch (NumberFormatException e) {
            //TODO: handle exception
            model.addAttribute("num",firstNum);
            return("numoutofrange");
        }
        try {
            secondParse = Integer.parseInt(secondNum);
        } catch (NumberFormatException e) {
            //TODO: handle exception
            model.addAttribute("num",secondNum);
            return("numoutofrange");
        }
        return "";
    }
}
