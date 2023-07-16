package com.slipkprojects.ultrasshservice.tunnel;

import android.text.format.Time;

import com.slipkprojects.ultrasshservice.logger.SkStatus;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.LocalPortForwarder;
import com.art.vpn.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Random;

//Create Base By TempestVPN, NO MODIFIED
public class Pinger extends Thread {
    private final Connection a;
    private final String b;
    private LocalPortForwarder c;
    private boolean d;
    private Socket f;

    public Pinger(Connection aVar, String str) {
        this.a = aVar;
        this.b = str;
    }
    private long pingTime = 0;
    private long T1 = 0;
    private long T2 = 0;
    private long T3 = 0;
    private long T4 = 0;
    private long T5 = 0;
    private int b() {
        return (new Random().nextInt(6) + 5) * 150;
    }

    public synchronized void close() {
        this.d = false;
        interrupt();
    }

    public void run() {

        try {
            // SkStatus.logInfo("Ping server: " + this.b);
            this.c = this.a.createLocalPortForwarder(9395, this.b, 80);
            this.d = true;
            while (this.d) {
                try {
                    SocketChannel sc = SocketChannel.open();
                    sc.configureBlocking(true);

                    InetAddress addr = InetAddress.getByName(this.b);
                    Date InetAddress = new Date();
                    Date Socket = new Date();
                    Date InetSocketAddress = new Date();
                    if (sc.connect(new InetSocketAddress(addr, 80))) {
                        Date Date = new Date();
                        Time Time = new Time();

                        T1 = (Date.getTime() - InetAddress.getTime());
                        T2 = (Date.getTime() - Socket.getTime());
                        T3 = (Date.getTime() - InetSocketAddress.getTime());
                        T4 = (Date.getSeconds() + Date.getMinutes());
                        T5 = (Time.getWeekNumber());

                        pingTime = (T1 + T2 + T3 + T4 + T5);
                    }
                    this.f = new Socket("127.0.0.1", 9395);
                    this.f.setSoTimeout(20000);
                    OutputStream outputStream = this.f.getOutputStream();
                    InputStream inputStream = this.f.getInputStream();
                    outputStream.write(("HEAD HTTP://" + this.b + "/ HTTP/1.1\r\nHost: " + this.b + "\r\nConnection: close\r\n\r\n\r\n").getBytes());
                    outputStream.flush();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f.getInputStream()));
                    String readLine = bufferedReader.readLine();
                    if (pingTime < 150){
                        SkStatus.logWarning("Ping " + readLine + " " + "<b><font color=\"green\">" + pingTime + "</font>" + " ms" + "</b>");

                    } else if (pingTime < 200){
                        SkStatus.logWarning("Ping " + readLine + " " + "<b><font color=\"#FFA500\">" + pingTime + "</font>" + " ms" + "</b>");

                    } else if (pingTime > 250){
                        SkStatus.logWarning("Ping " + readLine + " " + "<b><font color=\"red\">" + pingTime + "</font>" + " ms" + "</b>");
                    }
                    else {
                        SkStatus.logInfo("Pinger: No Data");
                    }
                    bufferedReader.close();
                    inputStream.close();
                    outputStream.close();
                    this.f.close();
                } catch (Exception e) {
                    //SkStatus.logInfo("Ping Failed: " + e.toString());
                }
                try {
                    sleep((long) b());
                } catch (Exception e2) {
                    SkStatus.logInfo("pinger stopped");
                    this.c.close(); // fixed (address already in use) bug
                    this.c = null; // This is required
                    return;
                }
            }
        } catch (Exception e3) {
            SkStatus.logInfo("Pinger: " + e3.toString());
        }
    }
}


