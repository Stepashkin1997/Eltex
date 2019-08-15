package ru.eltex.app.java.lab1;

import com.google.gson.annotations.Expose;
import ru.eltex.app.java.lab2.ShoppingCart;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Drinks")
public abstract class Drinks implements ICrudAction, Serializable {
    @Id
    @Expose
    private UUID id;//id товара
    @Expose
    private StringBuilder name;//Название
    @Expose
    private double coast;//Цена
    @Expose
    private StringBuilder company;//Фирма поставщик
    @Expose
    private StringBuilder developer;//Страна производитель

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "fk_id")
    private ShoppingCart<?> cart;//Агрегация ссылка на ShoppingCart

    static int count = 0;//счетчик объектов

    /**
     * Конструктор по умолчанию
     */
    public Drinks() {
        this.id = UUID.randomUUID();
        this.name = new StringBuilder("");
        this.coast = 0;
        this.company = new StringBuilder("");
        this.developer = new StringBuilder("");
        count++;
    }


    public Drinks(ShoppingCart<?> cart) {
        this.id = UUID.randomUUID();
        this.name = new StringBuilder("");
        this.coast = 0;
        this.company = new StringBuilder("");
        this.developer = new StringBuilder("");
        this.cart = cart;
        count++;
    }

    /**
     * перегруженный конструктор
     *
     * @param name      Название
     * @param coast     Цена
     * @param company   Фирма поставщик
     * @param developer Страна производитель
     */
    public Drinks(StringBuilder name, double coast, StringBuilder company, StringBuilder developer) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.coast = coast;
        this.company = company;
        this.developer = developer;
        count++;
    }

    public Drinks(StringBuilder name, double coast, StringBuilder company, StringBuilder developer, ShoppingCart<?> cart) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.coast = coast;
        this.company = company;
        this.developer = developer;
        this.cart = cart;
        count++;
    }

    public UUID getId() {
        return id;
    }

    public void setCart(ShoppingCart<?> cart) {
        this.cart = cart;
    }

    /**
     * Заполнение объекта случайными значениями и инкремент счётчика
     */
    @Override
    public void create() {
        this.id = UUID.randomUUID();
        name = null;
        coast = Math.random();
        company = null;
        developer = null;
    }


    /**
     * Принудительное зануление данных в объекте и декремент счетчика
     */
    @Override
    public void delete() {
        this.id = null;
        name = null;
        coast = 0;
        company = null;
        developer = null;
        count--;
    }

    /**
     * Вывод данных на экран
     */
    @Override
    public void read() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("coast: " + coast);
        System.out.println("company: " + company);
        System.out.println("developer: " + developer);
    }


    /**
     * Ввод данных с клавиатуры
     *
     * @throws IOException
     */
    @Override
    public void update() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название:");
        name = new StringBuilder(scanner.nextLine());

        System.out.println("Введите ценник:");
        coast = Double.parseDouble(scanner.nextLine());

        System.out.println("Введите название компании:");
        company = new StringBuilder(scanner.nextLine());

        System.out.println("Введите название страны производителя:");
        developer = new StringBuilder(scanner.nextLine());
    }
}
