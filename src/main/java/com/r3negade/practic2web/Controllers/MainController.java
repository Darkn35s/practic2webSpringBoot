package com.r3negade.practic2web.Controllers;
import com.r3negade.practic2web.models.Model1;
import com.r3negade.practic2web.repos.Model1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private Model1Repository m1Rep;
    @GetMapping("/")
    public String greeting( Model model){
        model.addAttribute("name", "Главная страница");
        return "home";
    }

    @PostMapping("/home")
    public String blogItemAdd(@RequestParam String title,@RequestParam String fullTask, @RequestParam String priority, @RequestParam String type,  Model model){
        Model1 model1= new Model1(title, fullTask, priority, type);
        m1Rep.save(model1);
        return "redirect:/";
    }

}
