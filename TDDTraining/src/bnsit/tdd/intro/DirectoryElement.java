package bnsit.tdd.intro;

import java.util.Date;

public class DirectoryElement {
	private String name;
	private String fullPath;
	private Date lastModified;
	private boolean isDirectory;

	public DirectoryElement(String name, boolean isDirectory, String fullPath, Date lastModified) {
		this.name = name;
		this.isDirectory = isDirectory;
		this.fullPath = fullPath;
		this.lastModified = lastModified;
	}
	
	public String getName() {
		return name;
	}

	public boolean isDirectory() {
		return isDirectory;
	}
	
	public String getFullPath() {
		return fullPath;
	}
	
	public Date getLastModified() {
		return lastModified;
	}
}
