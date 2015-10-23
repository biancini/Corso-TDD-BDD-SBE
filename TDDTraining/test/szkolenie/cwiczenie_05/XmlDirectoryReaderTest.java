package szkolenie.cwiczenie_05;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import szkolenie.cwiczenie_03.DirectoryElement;
import szkolenie.cwiczenie_04.DirectoryReader;
import szkolenie.cwiczenie_04.XmlDirectoryReader;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class XmlDirectoryReaderTest {


    @Mock
    private DirectoryReader nonEmptyDirectoryReaderMock;

    @Mock
    private DirectoryReader emptyDirectoryReaderMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnEmptyXmlForEmptyDirectory() {

        when(emptyDirectoryReaderMock.read(anyString())).thenReturn(new ArrayList<DirectoryElement>());

        XmlDirectoryReader reader = new XmlDirectoryReader(emptyDirectoryReaderMock);

        String xmlString = reader.readAsXml("jhh");
        System.out.println(xmlString);
        assertEquals("<directory></directory>", xmlString);
    }


    @Test
    public void shouldReturnNonEmptyXmlForNonEmptyDirectory() {

        List<DirectoryElement> preparedContent = new ArrayList<DirectoryElement>();
        preparedContent.add(new DirectoryElement("d1", true));
        preparedContent.add(new DirectoryElement("f1", false));
        when(nonEmptyDirectoryReaderMock.read(anyString())).thenReturn(preparedContent);


        XmlDirectoryReader reader = new XmlDirectoryReader(nonEmptyDirectoryReaderMock);

        String xmlString = reader.readAsXml("another not imporatant value");
        System.out.println(xmlString);

        assertEquals("<directory><subdirectory name=\"d1\" /><file name=\"f1\" /></directory>", xmlString);
    }
}
