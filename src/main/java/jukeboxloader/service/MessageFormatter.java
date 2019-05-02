package jukeboxloader.service;

import com.google.gson.Gson;
import jukeboxloader.pojo.JukeMessage;
import jukeboxloader.pojo.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageFormatter {
    @Autowired
    private Gson formatter;

    public String createMessage(JukeMessage message) {
        return formatter.toJson(new SimpleResponse(message.getErrorCode(), message.getMessage()));

    }

    public String createJson(Object o) {
        return formatter.toJson(o);

    }


}
