package ru.eltex.app.java;

import java.util.Scanner;
import java.util.UUID;

public abstract class Drinks implements ICrudAction {
    private UUID ID;//ID товара
    private StringBuilder Name;//Название
    private double Coast;//Цена
    private StringBuilder Company;//Фирма поставщик
    private StringBuilder Developer;//Страна производитель

    static int count = 0;//счетчик объектов

    /*конструктор по умолчанию*/
    public Drinks() {
    }

    /*перегруженный конструктор*/
    public Drinks(StringBuilder name, double coast, StringBuilder company, StringBuilder developer) {
        this.ID = UUID.randomUUID();
        Name = name;
        Coast = coast;
        Company = company;
        Developer = developer;
        count++;
    }

    /*заполнение объекта случайными значениями и инкремент счётчика*/
    @Override
    public void create() {
        this.ID = UUID.randomUUID();
        Name = null;
        Coast = Math.random();
        Company = null;
        Developer = null;
        count++;
    }

    /*принудительное зануление данных в объекте и декремент счетчика*/
    @Override
    public void delete() {
        this.ID = null;
        Name = null;
        Coast = 0;
        Company = null;
        Developer = null;
        count--;
    }

    /*вывод данных на экран*/
    @Override
    public void read() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);
        System.out.println("Coast: " + Coast);
        System.out.println("Company: " + Company);
        System.out.println("Developer: " + Developer);
    }

    /*ввод данных с клавиатуры*/
    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название:");
        Name = new StringBuilder(scanner.nextLine());

        System.out.println("Введите ценник:");
        Coast = Double.parseDouble(scanner.nextLine());

        System.out.println("Введите название компании:");
        Company = new StringBuilder(scanner.nextLine());

        System.out.println("Введите название страны производителя:");
        Developer = new StringBuilder(scanner.nextLine());
    }
}
