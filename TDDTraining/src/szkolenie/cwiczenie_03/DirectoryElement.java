package szkolenie.cwiczenie_03;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class DirectoryElement {
    private boolean directory;
    private String name;

    public DirectoryElement(String name, boolean isDirectory) {
        this.setName(name);
        this.setDirectory(isDirectory);
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
