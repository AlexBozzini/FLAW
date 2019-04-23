package com.example.demo.channel.ChannelMessage;

import com.example.demo.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChannelMessageController {
    private ChannelMessageService channelMessageService;

    @Autowired
    public ChannelMessageController(ChannelMessageService channelMessageService) {
        this.channelMessageService = channelMessageService;
    }

    @GetMapping("/channels/{channelId}/messages")
    public List<Message> findAllMessagesInChannel(@PathVariable Long channelId) {
        return channelMessageService.findAllMessagesInChannel(channelId);
    }
}
