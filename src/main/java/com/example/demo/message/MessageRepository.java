package com.example.demo.message;

import com.example.demo.channel.Channel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByChannel(Channel channel);

    List<Message> findByChannelId(Long channelId);
}
