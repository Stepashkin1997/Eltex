package ru.eltex.app.java.lab2;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.UUID;

/**
 * класс для хранения и обработки персональных данных пользователей
 */
public final class Credentials implements Serializable {
    private UUID id;//ID
    private StringBuilder name;//Имя
    private StringBuilder surname;//Фамилия
    private StringBuilder thirdname;//Отчетсво
    private StringBuilder email;//Почта

    public Credentials(StringBuilder name, StringBuilder surname, StringBuilder thirdname, StringBuilder email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.thirdname = thirdname;
        this.email = email;
    }

    public Credentials(String name, String surname, String thirdname, String email) {
        this.id = UUID.randomUUID();
        this.name = new StringBuilder(name);
        this.surname = new StringBuilder(surname);
        this.thirdname = new StringBuilder(thirdname);
        this.email = new StringBuilder(email);
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

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public void setSurname(StringBuilder surname) {
        this.surname = surname;
    }

    public void setThirdname(StringBuilder thirdname) {
        this.thirdname = thirdname;
    }

    public void setEmail(StringBuilder email) {
        this.email = email;
    }

    /**
     * Вывод данных на экран
     */
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Thirdname: " + thirdname);
        System.out.println("Email:" + email);
    }
}
