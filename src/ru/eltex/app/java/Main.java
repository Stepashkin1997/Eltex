package ru.eltex.app.java;

public class Main {

    public static void main(String[] args) {
        String TYPE="";
        int count=0;

        try {
            TYPE = args[1];
            count = Integer.parseInt(args[0]);
        }
        catch (Exception ex){
            System.err.println("ERROR");
            return;
        }

        ICrudAction action = null;
        for (int i=0;i<count;i++) {

            switch (TYPE) {
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
            System.out.println(Drinks.count);
            action.update();
            action.read();
            action.delete();
            action.read();
        }
    }
}
