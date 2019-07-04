package com.company;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    /*7. Добавить для класса «заказ» поля «время создания» и «время ожидания».
Время создания устанавливается в момент оформления покупки.
Время ожидания – время, через которое заказ должен исчезнуть (должен быть обработан), считая от времени создания.*/
    private StringBuilder status;
    private LocalDate ordertime;
    private Date waitingtime;

    public Order(Date waitingtime) {
        this.waitingtime = waitingtime;
        ordertime= LocalDate.now();
    }
}
