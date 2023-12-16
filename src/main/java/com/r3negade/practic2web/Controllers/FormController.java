package com.r3negade.practic2web.Controllers;

import com.r3negade.practic2web.models.Model1;
import com.r3negade.practic2web.repos.Model1Repository;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class FormController {


    @Autowired
    private Model1Repository m1Rep;
    @GetMapping("/formredactor")
    public  String formRedactor(Model model){
        Iterable<Model1> records = m1Rep.findAll();
        model.addAttribute("items", records);
        return  "formredactor";
    }


    @GetMapping("/formredactor/{id}/edit")
    public  String formEdit(@PathVariable(value = "id") long id, Model model){
        if(!m1Rep.existsById(id)){
            return "redirect:/home";
        }
        Optional<Model1> task = m1Rep.findById(id);
        ArrayList<Model1> tsk = new ArrayList<>();
        task.ifPresent(tsk::add);
        model.addAttribute("item",tsk);
        return "edit";
    }

    @PostMapping("/formredactor/{id}/edit")
    public  String formPostEdit(@PathVariable(value = "id") long id,
                                @RequestParam String title, @RequestParam String fullTask,
                                @RequestParam String priority, @RequestParam String type, Model model){
        Model1 model1=m1Rep.findById(id).orElseThrow();
        model1.setTitle(title);
        model1.setFullTask(fullTask);
        model1.setType(type);
        model1.setPriority(priority);
        m1Rep.save(model1);
        return "redirect:/formredactor";
    }

    @PostMapping("/formredactor/{id}/delete")
    public  String formPostDelete(@PathVariable(value = "id") long id, Model model){
        Model1 model1=m1Rep.findById(id).orElseThrow();
        m1Rep.delete(model1);
        return "redirect:/formredactor";
    }
}
