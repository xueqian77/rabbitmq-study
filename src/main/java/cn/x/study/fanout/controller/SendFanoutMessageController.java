package cn.x.study.fanout.controller;

import cn.x.study.fanout.service.SendFanoutMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fanout")
public class SendFanoutMessageController {

    @Autowired
    SendFanoutMessageService sendMessageService;



    @GetMapping("/send")
    public void send() {
        sendMessageService.senMessage();
    }

}
