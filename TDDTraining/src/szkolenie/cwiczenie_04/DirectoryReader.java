package szkolenie.cwiczenie_04;

import szkolenie.cwiczenie_03.DirectoryElement;

import java.util.List;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public interface DirectoryReader {

    List<DirectoryElement> read(String path);
}
