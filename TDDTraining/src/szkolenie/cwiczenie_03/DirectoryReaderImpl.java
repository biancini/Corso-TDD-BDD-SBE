package szkolenie.cwiczenie_03;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class DirectoryReaderImpl {

    public List<DirectoryElement> read(String path) throws PathDoesNotExistException {

        File directory = new File(path);

        if (!directory.exists()) {
            throw new PathDoesNotExistException();
        }

        List<DirectoryElement> elements = new ArrayList<DirectoryElement>();
        for (File f : directory.listFiles()) {
            elements.add(new DirectoryElement(f.getName(), f.isDirectory()));
        }

        return elements;
    }
}
