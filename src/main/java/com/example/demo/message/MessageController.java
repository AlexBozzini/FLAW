package com.example.demo.message;

import com.example.demo.channel.Channel;
import com.example.demo.channel.ChannelService;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private MessageService messageService;
    private UserService userService;
    private ChannelService channelService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService, ChannelService channelService) {
        this.messageService = messageService;
        this.userService = userService;
        this.channelService = channelService;
    }

    @GetMapping("/messages/")
    public ResponseEntity<Iterable<Message>> index() {
        return new ResponseEntity<>(messageService.index(), HttpStatus.OK);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> show(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.show(id), HttpStatus.OK);
    }

    @PostMapping("/messages/")
    public ResponseEntity<Message> create(@RequestBody MessageRequest messageRequest) {
        Message message = new Message();
        message.setUser(userService.show(messageRequest.getUserId()));
        message.setMessageBody(messageRequest.getMessageBody());
        message.setChannel(channelService.show(messageRequest.getChannelId()));

        return new ResponseEntity<>(messageService.create(message), HttpStatus.CREATED);
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> update(@PathVariable Long id, @RequestBody Message message) {
        return new ResponseEntity<>(messageService.update(id, message), HttpStatus.OK);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(messageService.delete(id), HttpStatus.OK);
    }
}
