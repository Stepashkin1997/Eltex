package ru.eltex.app.java.lab8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.eltex.app.java.lab2.Order;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
