package com.linked.dazhongdianpingapi.system.util.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Linked
 * @date 2020/7/3 22:02
 */
@Component
@Slf4j
@ServerEndpoint(value = "/websocket/{userId}")
public class WebsocketUtil {

    private static CopyOnWriteArrayList<WebsocketUtil> webSocketSet = new CopyOnWriteArrayList<>();

    private Session session;

    private String userId;

    public static void sendInfo(String message)throws IOException {
        for (WebsocketUtil item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId") String userId) throws IOException {
        this.session = session;
        this.userId = userId;
        WebsocketUtil websock = getcurrentWebSocket(this.userId);
        if (websock != null) {
            return;
        }
        webSocketSet.add(this);
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("关闭了一个连接");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("=====发生错误");
        error.printStackTrace();
    }


    public static WebsocketUtil getcurrentWebSocket(String userId) {
        if (userId == null || "".equals(userId) || webSocketSet == null) {
            return null;
        }
        Iterator<WebsocketUtil> iterator = webSocketSet.iterator();
        while (iterator.hasNext()) {
            WebsocketUtil websocket = iterator.next();
            if (websocket.userId.equals(userId)) {
                return websocket;
            }
        }
        return null;
    }


    public static void sendMessage(String userId, String message) {
        try {
            if (userId == null || "".equals(userId) || StringUtils.isEmpty(message)) {
                return;
            }
            WebsocketUtil websock = getcurrentWebSocket(userId);
            if (websock == null) {
                return;
            }
            websock.sendMessage(message);
        } catch (IOException e) {
            log.info("发送消息异常");
        }
    }


    @OnMessage
    public void sendMessage(String message)throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


}
