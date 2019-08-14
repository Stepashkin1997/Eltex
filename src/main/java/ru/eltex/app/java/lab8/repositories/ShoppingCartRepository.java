package ru.eltex.app.java.lab8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eltex.app.java.lab2.ShoppingCart;

import java.util.UUID;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, UUID> {

}
