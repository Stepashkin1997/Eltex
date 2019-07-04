package com.company;

public class Main {

    public static void main(String[] args) {
        final String Type = args[0];
        int count = Integer.parseInt(args[1]);
        Drinks.count = count;


        ICrudAction action;

        switch (Type) {
            case "Coffee": {
                action = new Coffee();//создание объекта типа Coffee
                break;
            }
            case "Tea": {
                action = new Tea();//создание объекта типа Tea
                break;
            }
            default: {
                System.err.println("Wrong object name");//выод ошибки
                return;
            }
        }


        action.create();
        action.update();
        action.read();
        action.delete();
        action.read();
    }
}
