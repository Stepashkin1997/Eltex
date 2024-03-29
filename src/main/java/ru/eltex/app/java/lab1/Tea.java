package ru.eltex.app.java.lab1;

import ru.eltex.app.java.lab2.ShoppingCart;

import javax.persistence.Entity;
import java.io.IOException;
import java.util.Scanner;

@Entity
public final class Tea extends Drinks {
    private StringBuilder typebox;//Вид упаковки

    /**
     * конструктор по умолчанию
     */
    public Tea() {
    }

    /**
     * перегруженный конструктор
     *
     * @param name
     * @param coast
     * @param company
     * @param developer
     * @param Typebox
     */
    public Tea(String name, double coast, String company, String developer, String Typebox) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer));
        this.typebox = new StringBuilder(Typebox);
    }

    public Tea(String name, double coast, String company, String developer, String Typebox, ShoppingCart<?> cart) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer), cart);
        this.typebox = new StringBuilder(Typebox);
    }

    /**
     * заполнение объекта случайными значениями и инкремент счётчика
     */
    @Override
    public void create() {
        super.create();
        typebox = null;
    }

    /**
     * вывод данных на экран
     */
    @Override
    public void read() {
        super.read();
        System.out.println("Вид упаковки: " + typebox);
    }

    /**
     * ввод данных с клавиатуры
     *
     * @throws IOException
     */
    @Override
    public void update() throws IOException {
        super.update();
        System.out.println("Введите название вида упаковки:");
        Scanner scanner = new Scanner(System.in);
        typebox = new StringBuilder(scanner.nextLine());
    }

    /**
     * принудительное зануление данных в объекте и декремент счетчика
     */
    @Override
    public void delete() {
        super.delete();
        typebox = null;
    }
}

