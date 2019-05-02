package jukeboxloader.helper;

import jukeboxloader.pojo.Component;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class JukeboxHelperTest {


    @Test
    public void canConvertToSetOfStrings() {
        List<Component> components =  Arrays.asList(createComponent("name-1"),
                createComponent("name-2"),
                createComponent("name-3"));

        Set<String> result = JukeboxHelper.transformComponents(components);

        assertThat(result, hasItems("name-1", "name-2", "name-3"));
    }

    private Component createComponent(String name) {
        Component component = new Component();
        component.setName(name);
        return component;
    }

    @Test
    public void canRemoveDuplicates() {
        List<Component> components =  Arrays.asList(createComponent("name-1"),
                createComponent("name-2"),createComponent("name-2"));

        Set<String> result = JukeboxHelper.transformComponents(components);

        assertThat(result, hasItems("name-1", "name-2"));
    }
}