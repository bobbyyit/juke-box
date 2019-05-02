package jukeboxloader.pojo;

import java.util.Set;

public class Setting {
    private String id;
    private Set<String> requires;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getRequires() {
        return requires;
    }

    public void setRequires(Set<String> requires) {
        this.requires = requires;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id='" + id + '\'' +
                ", requires=" + requires +
                '}';
    }
}
