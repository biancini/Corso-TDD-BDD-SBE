package szkolenie.cwiczenie_04;

import szkolenie.cwiczenie_03.DirectoryElement;
import szkolenie.cwiczenie_03.DirectoryReaderImpl;

import java.util.List;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class XmlDirectoryReader {

    private DirectoryReader directoryReader;

    public XmlDirectoryReader(DirectoryReader directoryReader) {
        this.directoryReader = directoryReader;
    }

    public String readAsXml(String path) {

        List<DirectoryElement> elements = directoryReader.read(path);
        return toXml(elements);
    }

    private String toXml(List<DirectoryElement> elements) {

        StringBuilder sb = new StringBuilder();
        sb.append("<directory>");
        for (DirectoryElement element : elements) {
            String elementString = toXmlString(element);
            sb.append(elementString);
        }
        sb.append("</directory>");

        return sb.toString();
    }

    private String toXmlString(DirectoryElement element) {

        if (element.isDirectory()) {
            return "<subdirectory name=\"" + element.getName() + "\" />";
        }

        return "<file name=\"" + element.getName() + "\" />";
    }
}
