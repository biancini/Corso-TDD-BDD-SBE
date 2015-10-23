package bnsit.tdd.intro;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class DirectoryReaderTest {

	
	@Test
	public void shouldReturnEmptyListWhenDirectoryIsEmpty() {
		DirectoryReader reader = new DirectoryReader();
		
		List<DirectoryElement> elements 
			= reader.read("testrc/dirreader/empty");
		
		assertNotNull(elements);
		assertTrue(elements.isEmpty());
	}
	
	// directory exists and has files
	@Test
	public void shouldReturnFilesFromDirectoryWithOnlyFiles() throws IOException {
		DirectoryReader reader = new DirectoryReader();
		
		String dirName = "testrc/dirreader/withfiles";
		List<DirectoryElement> elements = reader.read(dirName);
		
		assertEquals(3, elements.size());
		
		// REFACTOR create custom assert
		assertEquals("file0", elements.get(0).getName());
		assertFalse(elements.get(0).isDirectory());
		// REFACTOR put to separate method
		assertEquals(createAbsolutePath(dirName, "file0"), 
				elements.get(0).getFullPath());
		
		assertEquals("file1", elements.get(1).getName());
		assertEquals("file2", elements.get(2).getName());
	}

	private String createAbsolutePath(String dirName, String filename) throws IOException {
		File baseDirectory = new File(".");
		return baseDirectory.getCanonicalPath() + "/" + dirName + "/" + filename;
	}

	@Test
	public void shouldReturnDirectoryElementsForMixedContent() {
		DirectoryReader directoryReader = new DirectoryReader();
		
		List<DirectoryElement> elements 
			= directoryReader.read("testrc/dirreader");
		
		assertEquals(4, elements.size());
		assertEquals("empty", elements.get(0).getName());
		assertEquals(true, elements.get(0).isDirectory());
		
		assertEquals("file", elements.get(1).getName());
		assertEquals(false, elements.get(1).isDirectory());
		
		assertEquals("mixedcontent", elements.get(2).getName());
		assertEquals(true, elements.get(2).isDirectory());
		
		assertEquals("withfiles", elements.get(3).getName());
		assertEquals(true, elements.get(3).isDirectory());
	}
	
	// directory doesn't exist
	
	// argument is a file (not a directory)
	
	// wrong argument (null or empty string)
	
	// no access rights to read directory

}
