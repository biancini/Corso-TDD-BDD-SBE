package szkolenie.cwiczenie_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class DirectoryReaderImplTest {

    @Test
    public void shouldReturnEmptyListWhenDirIsEmpty() {

        DirectoryReaderImpl directoryReader = new DirectoryReaderImpl();
        List<DirectoryElement> elements = directoryReader.read("src/test/resources/dirs/empty_dir");
        assertNotNull(elements);
    }

    @Test
    public void shouldReturnFiles() {

        DirectoryReaderImpl directoryReader = new DirectoryReaderImpl();
        List<DirectoryElement> elements = directoryReader.read("src/test/resources/dirs/files");
        assertEquals(2, elements.size());
        for (DirectoryElement element : elements) {
            assertFalse(element.isDirectory());
        }
    }

    @Test
    public void shouldReturnFilesAndDirs() {

        DirectoryReaderImpl directoryReader = new DirectoryReaderImpl();
        List<DirectoryElement> elements = directoryReader.read("src/test/resources/dirs/files_and_dirs");
        assertEquals(4, elements.size());
        List<String> names = new ArrayList<String>(4);
        boolean containsDirectories = false;
        for (DirectoryElement element : elements) {
            names.add(element.getName());
            if (element.isDirectory()) {
                containsDirectories = true;
            }
        }
        assertTrue(names.containsAll(Arrays.asList(new String[]{"file1.txt", "file2.txt", "dir1", "dir2"})));
        assertTrue(containsDirectories);
    }

    @Test(expected = PathDoesNotExistException.class)
    public void shouldThrowExceptionWhenPathNotFound() {

        DirectoryReaderImpl directoryReader = new DirectoryReaderImpl();
        directoryReader.read("wrongPath");
        // expect excdption
    }
}