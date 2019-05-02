package jukeboxloader.service;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import jukeboxloader.pojo.Jukebox;
import jukeboxloader.pojo.JukeboxSettings;
import org.hamcrest.Matchers;
import org.junit.Before;

import static java.net.InetAddress.getByName;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import ratpack.server.ServerConfig;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static java.net.InetAddress.getByName;
import static ratpack.server.BaseDir.find;
import static ratpack.server.RatpackServer.start;

public class ExternalSourceLoaderTest {

    private ExternalSourceLoader loader;

    @Before
    public void createMiniServer() throws Exception {
        loader = new ExternalSourceLoader();

        start(spec -> spec
                .serverConfig(ServerConfig.embedded().port(7777)
                        .address(getByName("0.0.0.0"))
                        .baseDir(find()))
                .handlers(chain -> {
                            chain
                                    .get("settings", ctx -> {
                                        URL url = Resources.getResource("settings.json");
                                        String text = Resources.toString(url, Charsets.UTF_8);
                                        ctx.render(text);
                                    })
                                    .get("jukes", ctx -> {
                                        URL url = Resources.getResource("jukes.json");
                                        String text = Resources.toString(url, Charsets.UTF_8);
                                        ctx.render(text);
                                    });
                        }
                )
        );
    }

    @Test
    public void canParseJsonSettings() throws IOException {
        JukeboxSettings jukeboxSettings = loader.getJukeboxSettings("http://localhost:7777/settings");

        assertThat(jukeboxSettings, is(notNullValue()));
        assertThat(jukeboxSettings.getSettings(), hasSize(2));
    }

    @Test
    public void canParseJsonJukebox() throws IOException {
        List<Jukebox> jukeboxSettings = loader.getJukeboxes("http://localhost:7777/jukes");

        assertThat(jukeboxSettings, is(notNullValue()));
        assertThat(jukeboxSettings, hasSize(2));
    }
}