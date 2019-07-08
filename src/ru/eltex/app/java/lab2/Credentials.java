package ru.eltex.app.java.lab2;

import java.util.UUID;

/*класс для хранения и обработки персональных данных пользователей*/
public class Credentials {
    private UUID id;
    private StringBuilder name;
    private StringBuilder surname;
    private StringBuilder thirdname;
    private StringBuilder email;

    public Credentials(StringBuilder name, StringBuilder surname, StringBuilder thirdname, StringBuilder email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.thirdname = thirdname;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public StringBuilder getName() {
        return name;
    }

    public StringBuilder getSurname() {
        return surname;
    }

    public StringBuilder getThirdname() {
        return thirdname;
    }

    public StringBuilder getEmail() {
        return email;
    }
}
