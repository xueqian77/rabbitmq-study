package cn.x.study.topic.controller;

import cn.x.study.topic.service.SendTopicMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/topic")
public class SendTopicMessageController {

    @Autowired
    SendTopicMessageService sendMessageService;


    @GetMapping("/send")
    public void send() {
        sendMessageService.senMessage();
    }


}
