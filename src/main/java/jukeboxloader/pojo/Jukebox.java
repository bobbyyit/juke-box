package jukeboxloader.pojo;

import java.util.List;
import java.util.Objects;

public class Jukebox {
    private String id;
    private String model;
    private List<Component> components;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jukebox jukebox = (Jukebox) o;
        return Objects.equals(id, jukebox.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Jukebox{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", components=" + components +
                '}';
    }
}
