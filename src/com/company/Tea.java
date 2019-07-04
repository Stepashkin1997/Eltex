package com.company;

import java.util.Scanner;

public class Tea extends Drinks {
    private StringBuilder Typebox;//Вид упаковки

    /*конструктор по умолчанию*/
    public Tea() {
    }

    /*перегруженный конструктор*/
    public Tea(String name, double coast, String company, String developer, String Typebox) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer));
        this.Typebox = new StringBuilder(Typebox);
    }

    /*заполнение объекта случайными значениями и инкремент счётчика*/
    @Override
    public void create() {
        super.create();
        Typebox = null;
    }

    /*вывод данных на экран*/
    @Override
    public void read() {
        super.read();
        System.out.println("Вид упаковки: " + Typebox);
    }

    /*ввод данных с клавиатуры*/
    @Override
    public void update() {
        super.update();
        System.out.println("Введите название вида упаковки:");
        Scanner scanner = new Scanner(System.in);
        Typebox = new StringBuilder(scanner.nextLine());
    }

    /*принудительное зануление данных в объекте и декремент счетчика*/
    @Override
    public void delete() {
        super.delete();
        Typebox = null;
    }
}
