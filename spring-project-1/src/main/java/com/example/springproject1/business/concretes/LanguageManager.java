package com.example.springproject1.business.concretes;

import com.example.springproject1.business.abstracts.LanguageService;
import com.example.springproject1.dataAccess.abstracts.LanguageRepository;
import com.example.springproject1.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //this annotation tells to Spring that this class is a business class
public class LanguageManager implements LanguageService {
    LanguageRepository languageRepository; //It will use dataAccess ,also, dependency injection, do not make new
    //@Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        super(); //parent's constructor is called
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        //business rules
        return languageRepository.getAll();
    }

    @Override
    public String addLanguage(String name) {
        String x = languageRepository.addLanguage(name);
        return x;
    }

    @Override
    public String getLanguage(int id) {
        return languageRepository.getLanguage(id);
    }

    @Override
    public String deleteLanguage(int id) {
        return languageRepository.deleteLanguage(id);
    }

    @Override
    public String updateLanguage(int id, String name){
        return languageRepository.updateLanguage(id, name);
    }


}
