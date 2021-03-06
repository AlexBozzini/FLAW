package com.example.demo.message;

import com.example.demo.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByChannel(Channel channel);

    List<Message> findByChannelId(Long channelId);
}
