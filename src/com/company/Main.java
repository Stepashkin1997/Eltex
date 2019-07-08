package com.company;

public class Main {

    public static void main(String[] args) {
        final String Type;
        int count;
        try {
            Type = args[0];
            count = Integer.parseInt(args[1]);
        } catch (Exception ex) {
            System.err.println("ERROR");
            return;
        }

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

        for (int i = 0; i < count; i++) {
            action.create();
        }

        System.out.println(Drinks.count);

        action.update();
        action.read();
        action.delete();
        action.read();
    }
}
