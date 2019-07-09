package ru.eltex.app.java.lab2;

import java.io.IOException;

public interface ICrudAction {

    /*заполнение объекта случайными значениями и инкремент счётчика*/
    void create();

    /*вывод данных на экран*/
    void read();

    /*ввод данных с клавиатуры*/
    void update() throws IOException;

    /*принудительное зануление данных в объекте и декремент счетчика*/
    void delete();
}
