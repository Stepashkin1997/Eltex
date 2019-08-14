package ru.eltex.app.java.lab8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eltex.app.java.lab1.Drinks;

import java.util.UUID;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, UUID> {
}
