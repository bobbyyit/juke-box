package jukeboxloader.controller;

import jukeboxloader.service.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jukeboxloader.pojo.JukeMessage.STATUS_OK;

@RestController
public class StatusController {
    @Autowired

    private MessageFormatter formatter;

    @RequestMapping("/status")
    public String status() {
        return formatter.createMessage(STATUS_OK);
    }
}
