package jukeboxloader.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jukeboxloader.pojo.JukeboxSettings;
import jukeboxloader.pojo.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Component
public class SettingsLoader {

    @Autowired
    private ExternalSourceLoader externalSourceLoader;

    public Setting getJukeboxSetting(String settingId) {
        JukeboxSettings load = null;
        try {
            load = externalSourceLoader.getJukeboxSettings("http://my-json-server.typicode.com/touchtunes/tech-assignment/settings");
            load = loadFromJson();
        } catch (Exception e) {

        }

        return load.getSettings()
                .stream()
                .filter(setting -> Objects.equals(settingId, setting.getId()))
                .findFirst()
                .orElse(null);
    }

    @Deprecated
    public JukeboxSettings loadFromJson() throws IOException {
        URL url = getClass().getResource("/settings.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(url.getPath()), JukeboxSettings.class);
    }
}
