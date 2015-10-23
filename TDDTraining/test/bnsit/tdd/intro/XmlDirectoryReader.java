package bnsit.tdd.intro;

import java.util.List;

public class XmlDirectoryReader {

	private DirectoryReader directoryReader;

	public XmlDirectoryReader(DirectoryReader directoryReader) {
		this.directoryReader = directoryReader;
	}

	public String read(String directoryName) {
		List<DirectoryElement> elements = directoryReader.read(directoryName);
		
		if (elements.isEmpty()) {
			return "<directory />";
		}
		
		String xml = "<directory>";
		for (DirectoryElement directoryElement : elements) {
			xml += "<element name=\"" + directoryElement.getName() + "\"></element>";
		}
		xml += "</directory>";
		
		return xml;
	}

}
