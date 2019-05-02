package jukeboxloader.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jukeboxloader.pojo.Jukebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static jukeboxloader.helper.JukeboxHelper.transformComponents;

@Component
public class JukeboxLoader {

    @Autowired
    private ExternalSourceLoader externalSourceLoader;

    public List<Jukebox> getJukeboxLoader(Set<String> setting, String model) {
        List<Jukebox> filteredJukeboxes = new ArrayList<>();
        List<Jukebox> jukeboxes = null;
        try {
//            jukeboxes = externalSourceLoader.getJukeboxes("http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes");
            jukeboxes = loadFromJson();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Jukebox jukebox : jukeboxes) {
            if(model == null) {
                if(transformComponents(jukebox.getComponents()).equals(setting)) {
                    filteredJukeboxes.add(jukebox);
                }
            } else {
                if (transformComponents(jukebox.getComponents()).equals(setting) && model.equals(jukebox.getModel())) {
                    filteredJukeboxes.add(jukebox);
                }
            }
        }

        return filteredJukeboxes;
    }

    @Deprecated
    private List<Jukebox> loadFromJson() throws IOException {
        URL url = getClass().getResource("/jukes.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(url.getPath()),  new TypeReference<List<Jukebox>>(){});
    }
}
