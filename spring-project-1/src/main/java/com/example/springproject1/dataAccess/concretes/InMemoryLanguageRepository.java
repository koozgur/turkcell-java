package com.example.springproject1.dataAccess.concretes;

import com.example.springproject1.dataAccess.abstracts.LanguageRepository;
import com.example.springproject1.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //this annotation tells to Spring that this class is used for data access.
public class InMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages; //instead of database, we store in memory


    public InMemoryLanguageRepository(){
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "C#"));
        languages.add(new Language(2, "Python"));
        languages.add(new Language(3, "C"));
        languages.add(new Language(4, "Rust"));

    }

    @Override
    public List<Language> getAll() {
        return languages;
    }
    public String addLanguage(String name){
        //stream() helps to process sequence of elements in sequential structures,
        // anyMatch() applies short-circuit evaluation that ends in immediate return if finds true for any element
        String y;
        if( ! languages.stream().anyMatch(el -> el.getName().equals(name))){ //if list does not contain that string already
            languages.add(new Language((languages.size()), name));
            y = "Successfully added the language: " + name;

        }
        else{
            y = "Language: " + name + " already exists, failed to add.";
        }
        return y;
    }

    public String getLanguage(int id){
        for (Language lang: languages)
        {
            if (lang.getId() == id)
                return lang.getName();
        }
        return "Given id does not exists.";
    }

    @Override
    public String deleteLanguage(int id) {
        if(id < languages.size() && id >= 0) {
            languages.remove(id);
            return "Successfully removed the language.";
        }
        return "Id is not valid.";
    }

    @Override
    public String updateLanguage(int id, String name) {
        if(id > 0 && id < languages.size()) {
            if (!languages.stream().anyMatch(el -> el.getName().equals(name))) {
                for (int i = 0; i < languages.size(); i++) {
                    Language lang = languages.get(i);
                    if (lang.getId() == id) {
                        languages.set(i, new Language(id, name));
                        return "Successfully updated the language.";
                    }
                }
                return "Invalid id is given.";
            }
            return "That name already exists.";
        }
        return "Invalid id";

    }


}
