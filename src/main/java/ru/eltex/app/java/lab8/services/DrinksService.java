package ru.eltex.app.java.lab8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eltex.app.java.lab1.Drinks;
import ru.eltex.app.java.lab8.repositories.DrinksRepository;

@Service
public class DrinksService {
    @Autowired
    private DrinksRepository drinksRepository;

    public boolean addToCard(Drinks drinks) {
        try {
            drinksRepository.save(drinks);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
