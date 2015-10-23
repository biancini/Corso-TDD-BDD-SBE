package bnsit.tdd.intro;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class XmlDirectoryReaderTest {

	@Mock
	private DirectoryReader mockDirectoryReader;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnEmptyXmlForEmptyDirectory() {
		when(mockDirectoryReader.read(anyString()))
			.thenReturn(new ArrayList<DirectoryElement>());
		
		XmlDirectoryReader xmlReader 
			= new XmlDirectoryReader(mockDirectoryReader);
		
		String xml = xmlReader.read("/sample/empty/directory");
		
		assertEquals("<directory />", xml);
	}
	
	@Test
	public void shouldReturnXmlInfoAboutDirectoryContents() {
		when(mockDirectoryReader.read(anyString()))
			.thenReturn(sampleDirectoryElements());

		XmlDirectoryReader xmlReader 
			= new XmlDirectoryReader(mockDirectoryReader);
		
		String xml = xmlReader.read("/sample/nonempty/directory");
		
		assertEquals("<directory>"
				+ expectedXmlElement("dir1")
				+ expectedXmlElement("dir2")
				+ expectedXmlElement("file1")
				+ expectedXmlElement("file2")
				+ "</directory>", xml);
	}

	private List<DirectoryElement> sampleDirectoryElements() {
		ArrayList<DirectoryElement> result = new ArrayList<DirectoryElement>();
	
		result.add(new DirectoryElement("dir1", true, "fullPath/dir1", new Date()));
		result.add(new DirectoryElement("dir2", true, "fullPath/dir2", new Date()));
		result.add(new DirectoryElement("file1", true, "fullPath/file1", new Date()));
		result.add(new DirectoryElement("file2", true, "fullPath/file2", new Date()));
		
		return result;
	}

	private String expectedXmlElement(String name) {
		return "<element name=\""+ name + "\"></element>";
	}

}
