package ru.eltex.app.java.lab2;

import java.util.Scanner;

public class Tea extends Drinks {
    private StringBuilder typebox;//Вид упаковки

    /*конструктор по умолчанию*/
    public Tea() {
    }

    /*перегруженный конструктор*/
    public Tea(String name, double coast, String company, String developer, String Typebox) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer));
        this.typebox = new StringBuilder(Typebox);
    }

    /*заполнение объекта случайными значениями и инкремент счётчика*/
    @Override
    public void create() {
        super.create();
        typebox = null;
    }

    /*вывод данных на экран*/
    @Override
    public void read() {
        super.read();
        System.out.println("Вид упаковки: " + typebox);
    }

    /*ввод данных с клавиатуры*/
    @Override
    public void update() {
        super.update();
        System.out.println("Введите название вида упаковки:");
        Scanner scanner = new Scanner(System.in);
        typebox = new StringBuilder(scanner.nextLine());
    }

    /*принудительное зануление данных в объекте и декремент счетчика*/
    @Override
    public void delete() {
        super.delete();
        typebox = null;
    }
}