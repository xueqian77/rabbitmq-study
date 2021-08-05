package cn.x.study.direct.controller;

import cn.x.study.direct.service.SendDirectMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/direct")
public class SendDirectMessageController {

    @Autowired
    SendDirectMessageService sendMessageService;

    @GetMapping("/send/a")
    public void sendA() {
        sendMessageService.sendAMessage();
    }

    @GetMapping("/send/b")
    public void sendB() {
        sendMessageService.sendBMessage();
    }

}
