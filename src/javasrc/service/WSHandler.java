package javasrc.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WSHandler implements WebSocketHandler {
	
	private List<WebSocketSession> sessions=new Vector<>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		System.out.println("ConnectionClosed");
		sessions.remove(session);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("ConnectionEstablished");
		sessions.add(session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("handleMessage");
		System.out.println(session.getAttributes());
		System.out.println(message);
	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		System.out.println("handleTransportError");
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void pushDate() throws IOException{
		Date date=new Date();
		String now=date.toString();
		for (WebSocketSession session : sessions) {
			
			session.sendMessage(new TextMessage(now));
		}
	}
	
}
