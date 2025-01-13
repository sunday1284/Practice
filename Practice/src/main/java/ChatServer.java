

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// 웹소켓 서버의 요청명 지정
@ServerEndpoint("/ChatingServer")
public class ChatServer {
	// 접속한 클라이언트의 세션을 저장할 컬렉션 생성
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen  // 클라이언트 접속 시 실행
    public void onOpen(Session session) {
        clients.add(session);  // 세션 추가
    }

    @OnMessage  // 메시지를 받으면 실행
    public void onMessage(String message, Session session) throws IOException {
        synchronized (clients) {
            for (Session client : clients) {  // 모든 클라이언트에 메시지 전달
                if (!client.equals(session)) {  // 단, 메시지를 보낸 클라이언트는 제외
                    client.getBasicRemote().sendText(message);
                }
            }
        }
    }

    @OnClose  // 클라이언트와의 연결이 끊기면 실행
    public void onClose(Session session) {
        clients.remove(session); 
    }

    @OnError  // 에러 발생 시 실행
    public void onError(Throwable e) {
        e.printStackTrace();
    }
}