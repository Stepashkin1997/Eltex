package ru.eltex.app.java.lab5;

import java.io.File;

/**
 * абстрактный базовый класс для хранения заказов
 */
public abstract class AManageOrder implements  IOrder {
    protected File file;//файл для сохранения и загрузки
}
