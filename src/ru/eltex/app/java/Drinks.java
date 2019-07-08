package ru.eltex.app.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.UUID;

public abstract class Drinks implements ICrudAction {
    private UUID id;//id товара
    private StringBuilder name;//Название
    private double coast;//Цена
    private StringBuilder company;//Фирма поставщик
    private StringBuilder developer;//Страна производитель
    static HashSet<UUID> setId= new HashSet<>();

    static int count = 0;//счетчик объектов

    /*конструктор по умолчанию*/
    public Drinks() {
    }

    /*перегруженный конструктор*/
    public Drinks(StringBuilder name, double coast, StringBuilder company, StringBuilder developer) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.coast = coast;
        this.company = company;
        this.developer = developer;
        count++;

        boolean check=false;
        for (; check != true;) {
            this.id = UUID.randomUUID();
            check = setId.add(id);
        }
    }

    public UUID getId() {
        return id;
    }

    /*заполнение объекта случайными значениями и инкремент счётчика*/
    @Override
    public void create() {
        this.id = UUID.randomUUID();
        name = null;
        coast = Math.random();
        company = null;
        developer = null;
        count++;
    }

    /*принудительное зануление данных в объекте и декремент счетчика*/
    @Override
    public void delete() {
        this.id = null;
        name = null;
        coast = 0;
        company = null;
        developer = null;
        count--;
    }

    /*вывод данных на экран*/
    @Override
    public void read() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("coast: " + coast);
        System.out.println("company: " + company);
        System.out.println("developer: " + developer);
    }

    /*ввод данных с клавиатуры*/
    @Override
    public void update() {
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
