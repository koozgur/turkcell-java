package com.example.springproject1.dataAccess.abstracts;

import com.example.springproject1.entities.concretes.Language;


import java.util.List;


public interface LanguageRepository {
    List<Language> getAll();
    String addLanguage(String name);
    String getLanguage(int id);
    String deleteLanguage(int id);
    String updateLanguage(int id, String name);
}
