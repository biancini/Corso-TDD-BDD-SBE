package szkolenie.cwiczenie_04;

import org.junit.Test;
import szkolenie.cwiczenie_03.DirectoryElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class XmlDirectoryReaderTest {

    @Test
    public void shouldReturnEmptyXmlForEmptyDirectory() {

        XmlDirectoryReader reader = new XmlDirectoryReader(new StubEmptyDirectoryReader());

        String xmlString = reader.readAsXml("jhh");
        System.out.println(xmlString);
        assertEquals("<directory></directory>", xmlString);
    }


    @Test
    public void shouldReturnNonEmptyXmlForNonEmptyDirectory() {

        XmlDirectoryReader reader = new XmlDirectoryReader(new NonEmptyDirectoryReader());

        String xmlString = reader.readAsXml("another not imporatant value");
        System.out.println(xmlString);

        assertEquals("<directory><subdirectory name=\"d1\" /><file name=\"f1\" /></directory>", xmlString);
    }

    private class StubEmptyDirectoryReader implements DirectoryReader {

        @Override
        public List<DirectoryElement> read(String path) {
            return new ArrayList<DirectoryElement>();
        }
    }

    private class NonEmptyDirectoryReader implements DirectoryReader {
        @Override
        public List<DirectoryElement> read(String path) {

            ArrayList<DirectoryElement> elements = new ArrayList<DirectoryElement>();
            elements.add(new DirectoryElement("d1", true));
            elements.add(new DirectoryElement("f1", false));
            return elements;
        }
    }
}
