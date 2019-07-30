package ru.eltex.app.java.lab6.Server;

import java.io.IOException;
import java.net.*;

/**
 * Класс рассылающий номер порта для соединения TCP по UDP
 */
public final class UDPAlert extends Thread {
    private byte[] buf;
    private volatile boolean work;

    public UDPAlert(Integer address) {
        this.buf = address.toString().getBytes();
        this.work = true;
    }

    /**
     * Выключение потока
     */
    public void turnOff(){
        work=false;
    }

    @Override
    public void run() {
        super.run();
        while (work) {
            try (DatagramSocket socket = new DatagramSocket()) {
                socket.send(new DatagramPacket(buf, buf.length, InetAddress.getByName("255.255.255.255"), 9999));
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
