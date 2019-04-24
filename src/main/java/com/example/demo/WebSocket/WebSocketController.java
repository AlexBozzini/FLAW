package com.example.demo.WebSocket;

import com.example.demo.message.Message;
import com.example.demo.message.MessageController;
import com.example.demo.message.MessageRequest;
import com.example.demo.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    private MessageController messageController;
    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(MessageController messageController, SimpMessagingTemplate template){
        this.messageController = messageController;
        this.template = template;
    }

    @MessageMapping("/messages")
    @SendTo("/topic/chat")
    public Message onReceivedMessage(@RequestBody Message message) {
        MessageRequest messageRequest = new MessageRequest(message.getMessageBody(), 1L, message.getChannel().getId());
        this.template.convertAndSend("/topic/chat",  message);
        return messageController.create(messageRequest).getBody();
    }
}
