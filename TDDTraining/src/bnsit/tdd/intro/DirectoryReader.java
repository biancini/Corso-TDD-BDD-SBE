package bnsit.tdd.intro;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DirectoryReader {

	public List<DirectoryElement> read(String directoryName) {
		ArrayList<DirectoryElement> result = new ArrayList<DirectoryElement>();
		
		File directory = new File(directoryName);
		File[] files = directory.listFiles();
		for (File file : files) {
			result.add(
				new DirectoryElement(
						file.getName(), 
						file.isDirectory(),
						file.getAbsolutePath(),
						new Date(file.lastModified())));
		}
		
		return result;
	}

}
