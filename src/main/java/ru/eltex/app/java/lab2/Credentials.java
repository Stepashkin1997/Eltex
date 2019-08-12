package ru.eltex.app.java.lab2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * класс для хранения и обработки персональных данных пользователей
 */
@Entity
@Table(name = "Credentials")
public class Credentials implements Serializable {

    @Column(name = "cred_id")
    @Id
    private UUID cred_id;//ID

    @Column(name = "name")
    private StringBuilder name;//Имя

    @Column(name = "surname")
    private StringBuilder surname;//Фамилия

    @Column(name = "thirdname")
    private StringBuilder thirdname;//Отчетсво

    @Column(name = "email")
    private StringBuilder email;//Почта

    @OneToMany(mappedBy = "credentials", targetEntity = Order.class)
    private List<Order> orders = new LinkedList<>();

    public Credentials() {
    }

    public Credentials(StringBuilder name, StringBuilder surname, StringBuilder thirdname, StringBuilder email) {
        this.cred_id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.thirdname = thirdname;
        this.email = email;
    }

    public Credentials(String name, String surname, String thirdname, String email) {
        this.cred_id = UUID.randomUUID();
        this.name = new StringBuilder(name);
        this.surname = new StringBuilder(surname);
        this.thirdname = new StringBuilder(thirdname);
        this.email = new StringBuilder(email);
    }

    public UUID getId() {
        return cred_id;
    }

    public void setId(UUID id) {
        this.cred_id = id;
    }

    public StringBuilder getName() {
        return name;
    }

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public StringBuilder getSurname() {
        return surname;
    }

    public void setSurname(StringBuilder surname) {
        this.surname = surname;
    }

    public StringBuilder getThirdname() {
        return thirdname;
    }

    public void setThirdname(StringBuilder thirdname) {
        this.thirdname = thirdname;
    }

    public StringBuilder getEmail() {
        return email;
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
