package com.company;

import java.time.LocalDate;
import java.util.Date;

/*класс заказ*/
public class Order {
    private StringBuilder status;//статус заказа
    private LocalDate ordertime;//время покупки
    private Date waitingtime;//время ожидаия

    public Order(Date waitingtime) {
        this.waitingtime = waitingtime;
        ordertime= LocalDate.now();
    }
}
