package pl.tss.WebSocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.Random;

@ServerEndpoint("/chartsocket")
public class ChartWebSocket {

    @OnOpen
    public void onOpen(){
        System.out.println("Open chart ...");
    }

    @OnClose
    public void onClose(){
        System.out.println("Close chart ...");
    }

    @OnMessage
    public int onMessage(String message){
        Random r = new Random();
        return r.nextInt(20);
    }
}
