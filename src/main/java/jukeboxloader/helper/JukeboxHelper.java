package jukeboxloader.helper;

import jukeboxloader.pojo.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JukeboxHelper {
    public static Set<String> transformComponents(List<Component> components) {
        List<String> componentList = new ArrayList<>();
        for (Component component : components) {
            componentList.add(component.getName());
        }

        return new HashSet<>(componentList);
    }
}
