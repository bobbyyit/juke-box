package jukeboxloader.helper;

import jukeboxloader.pojo.Jukebox;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PaginationFormatterTest {

    @Test
    public void nullLimitReturnSameList() {
        List<Jukebox> jukeboxes = asList(createJukebox("id-0"),
                createJukebox("id-1"),
                createJukebox("id-2"));

        assertThat(PaginationFormatter.limit(jukeboxes, null), is(jukeboxes));
    }

    @Test
    public void limitReturnsTruncatedList() {
        List<Jukebox> jukeboxes = asList(createJukebox("id-0"),
                createJukebox("id-1"),
                createJukebox("id-2"));

        List<Jukebox> result = PaginationFormatter.limit(jukeboxes, 1);

        assertThat(result.get(0).getId(), is("id-0"));
        assertThat(result, hasSize(1));
    }


    @Test
    public void nullOffsetReturnSameList() {
        List<Jukebox> jukeboxes = asList(createJukebox("id-0"),
                createJukebox("id-1"),
                createJukebox("id-2"));

        assertThat(PaginationFormatter.offset(jukeboxes, null), is(jukeboxes));
    }

    @Test
    public void offsetReturnsTruncatedList() {
        List<Jukebox> jukeboxes = asList(createJukebox("id-0"),
                createJukebox("id-1"),
                createJukebox("id-2"));

        List<Jukebox> result = PaginationFormatter.offset(jukeboxes, 1);

        assertThat(result.get(0).getId(), is("id-1"));
        assertThat(result, hasSize(2));
    }

    private Jukebox createJukebox(String id) {
        Jukebox jukebox = new Jukebox();
        jukebox.setId("id-0");
        return jukebox;
    }
}