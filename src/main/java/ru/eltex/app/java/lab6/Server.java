package ru.eltex.app.java.lab6;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
         try(ServerSocket server = new ServerSocket(6666)) {
             while (true) {
                 System.out.println("Ждем подключения...");
                 Socket connect = server.accept();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }



    }
}
