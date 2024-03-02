package com.example.springproject1.webApi.controllers;

import com.example.springproject1.business.abstracts.LanguageService;
import com.example.springproject1.entities.concretes.Language;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;
    @Autowired //at newer spring versions this is added automatically
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getall")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/add")
    public String addLanguage(@RequestParam("name") String name){
        name = name.trim(); //remove any misleading empty spaces, prevent user try to insert empty language
        String x;
        if(!name.isEmpty()){
            x = languageService.addLanguage(name);
        }

        else
            x = "The language is empty, failed to add.";
        return x;
    }

    @GetMapping("/find")
    public String getLanguage(@RequestParam("id") int id){
        return languageService.getLanguage(id);
    }

    @GetMapping("/delete")
    public String deleteLanguage(@RequestParam("id") int id){
        return languageService.deleteLanguage(id);
    }

    @GetMapping("/update")
    public String updateLanguage(@RequestParam("id") int id, @RequestParam("name") String name){
        name = name.trim();
        if(name.isEmpty()){
            return "Name is empty, failed to update";
        }
        else{
            return languageService.updateLanguage(id, name);
        }
    }
}
