package jukeboxloader.helper;

import jukeboxloader.pojo.Jukebox;

import java.util.List;

public class PaginationFormatter {
    public static List<Jukebox> offset(List<Jukebox> jukeboxes, Integer offset) {
        if (offset == null) {
            return jukeboxes;
        }

        jukeboxes = jukeboxes.subList(offset, jukeboxes.size());
        return jukeboxes;
    }

    public static List<Jukebox> limit(List<Jukebox> jukeboxes, Integer limit) {
        if (limit == null) {
            return jukeboxes;
        }

        jukeboxes = jukeboxes.subList(0, limit);
        return jukeboxes;
    }
}
