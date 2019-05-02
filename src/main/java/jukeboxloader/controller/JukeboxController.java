package jukeboxloader.controller;

import jukeboxloader.pojo.Jukebox;
import jukeboxloader.pojo.Setting;
import jukeboxloader.pojo.JukeMessage;
import jukeboxloader.service.JukeboxLoader;
import jukeboxloader.service.MessageFormatter;
import jukeboxloader.service.SettingsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static jukeboxloader.helper.PaginationFormatter.limit;
import static jukeboxloader.helper.PaginationFormatter.offset;

@RestController
public class JukeboxController {

    @Autowired
    private SettingsLoader settingsLoader;
    @Autowired
    private JukeboxLoader jukeboxLoader;
    @Autowired
    private MessageFormatter formatter;

    @RequestMapping("/jukeboxes")
    public String listJukeboxes(@RequestParam(value="setting-id") String settingId,
                                  @RequestParam(value="model", required = false) String model,
                                  @RequestParam(value="offset", required = false) Integer offset,
                                  @RequestParam(value="limit", required = false) Integer limit) {

        Setting settings = settingsLoader.getJukeboxSetting(settingId);
        if (settings == null) {
            return formatter.createMessage(JukeMessage.SETTING_NOT_FOUND);
        }
        List<Jukebox> jukeboxes = jukeboxLoader.getJukeboxLoader(settings.getRequires(), model);

        jukeboxes = offset(jukeboxes, offset);
        jukeboxes = limit(jukeboxes, limit);

        if (jukeboxes.isEmpty()) {
            return formatter.createMessage(JukeMessage.JUKEBOX_NOT_FOUND);
        }
        return formatter.createJson(jukeboxes);
    }
}
