package bnsit.tdd.intro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StubDirectoryReader extends DirectoryReader {

	private boolean forEmptyDirectory;

	public StubDirectoryReader(boolean forEmptyDirectory) {
		this.forEmptyDirectory = forEmptyDirectory;
	}

	@Override
	public List<DirectoryElement> read(String directoryName) {
		ArrayList<DirectoryElement> result = new ArrayList<DirectoryElement>();
		if (forEmptyDirectory) {
			return result;
		} 
	
		result.add(new DirectoryElement("dir1", true, "fullPath/dir1", new Date()));
		result.add(new DirectoryElement("dir2", true, "fullPath/dir2", new Date()));
		result.add(new DirectoryElement("file1", true, "fullPath/file1", new Date()));
		result.add(new DirectoryElement("file2", true, "fullPath/file2", new Date()));
		
		return result;
	}
	
}
