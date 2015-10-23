package szkolenie.cwiczenie_07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class DeleteSpacesTest {

    @Test
    public void shouldRemoveSpaces() {

        DeleteSpaces deleteSpaces = new DeleteSpaces();
        String output = deleteSpaces.doDelete("my sample text with spaces");
        assertEquals("mysampletextwithspaces", output);
    }
}
