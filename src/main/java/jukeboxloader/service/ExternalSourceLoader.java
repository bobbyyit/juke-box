package jukeboxloader.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jukeboxloader.pojo.Jukebox;
import jukeboxloader.pojo.JukeboxSettings;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public class ExternalSourceLoader {
    public JukeboxSettings getJukeboxSettings(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL uri = new URL(url);
        JukeboxSettings readValue = mapper.readValue(uri, JukeboxSettings.class);
        return readValue;
    }

    public List<Jukebox> getJukeboxes(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Jukebox> jukeboxes = mapper.readValue(new URL(url), new TypeReference<List<Jukebox>>(){});
        return jukeboxes;
    }
}