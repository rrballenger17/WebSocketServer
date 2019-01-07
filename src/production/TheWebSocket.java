package production;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class TheWebSocket {
    
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Open ID:" + session.getId());        
    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("Close ID:" +  session.getId());
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("From ID:" + session.getId() + " Message:" + message);
        
        try {
            session.getBasicRemote().sendText("Hello Client #" + session.getId() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @OnError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }
}