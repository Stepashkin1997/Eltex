package ru.eltex.app.java.lab1;

import ru.eltex.app.java.lab2.ShoppingCart;

import javax.persistence.Entity;
import java.io.IOException;
import java.util.Scanner;

@Entity
public final class Coffee extends Drinks {
    private StringBuilder typecofee;//вид кофейных зёрен (арабика, робуста)

    /**
     * конструктор по умолчанию
     */
    public Coffee() {
    }


    /**
     * перегруженный конструктор
     *
     * @param name
     * @param coast
     * @param company
     * @param developer
     * @param typecofee
     */
    public Coffee(String name, double coast, String company, String developer, String typecofee) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer));
        this.typecofee = new StringBuilder(typecofee);
    }

    public Coffee(String name, double coast, String company, String developer, String typecofee, ShoppingCart<?> cart) {
        super(new StringBuilder(name), coast, new StringBuilder(company), new StringBuilder(developer), cart);
        this.typecofee = new StringBuilder(typecofee);
    }

    public StringBuilder getTypecofee() {
        return typecofee;
    }

    public void setTypecofee(StringBuilder typecofee) {
        this.typecofee = typecofee;
    }

    /**
     * заполнение объекта случайными значениями и инкремент счётчика
     */
    @Override
    public void create() {
        super.create();
        typecofee = null;
    }

    /**
     * вывод данных на экран
     */
    @Override
    public void read() {
        super.read();
        System.out.println("Вид кофейных зёрен: " + typecofee);
    }

    /**
     * ввод данных с клавиатуры
     *
     * @throws IOException не корректный ввод
     */
    @Override
    public void update() throws IOException {
        super.update();
        System.out.println("Введите название вида кофейных зёрен:");
        Scanner scanner = new Scanner(System.in);
        typecofee = new StringBuilder(scanner.nextLine());
    }

    /**
     * принудительное зануление данных в объекте и декремент счетчика
     */
    @Override
    public void delete() {
        super.delete();
        typecofee = null;
    }
}
