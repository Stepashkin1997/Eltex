package ru.eltex.app.java.lab8.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eltex.app.java.lab2.Credentials;

import java.util.UUID;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, String> {

}
