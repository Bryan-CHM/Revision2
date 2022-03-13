package nus.iss.edu.sg.revision2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.iss.edu.sg.revision2.utils.CalculateUtils;

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
        Integer displayNum = 0;
        CalculateUtils cUtils = new CalculateUtils();

        if(!cUtils.isInt(firstNum)){
            model.addAttribute("num",firstNum);
            model.addAttribute("errorCode",1);
            return("numoutofrange");
        }
        if(!cUtils.isInt(secondNum)){
            model.addAttribute("num",secondNum);
            model.addAttribute("errorCode",2);
            return("numoutofrange");
        }
        
        displayNum = cUtils.arithmeticFunc(firstNum, secondNum, ari);
        
        if(cUtils.isWithinRange(displayNum)){
            model.addAttribute("num",displayNum);
            return("number");
        }
        else{
            model.addAttribute("num",displayNum);
            model.addAttribute("errorCode",3);
            return("numoutofrange");
        }
        }
    }
