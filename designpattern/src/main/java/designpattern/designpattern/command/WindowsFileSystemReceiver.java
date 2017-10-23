package designpattern.designpattern.command;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

	public void openFile() {
		System.out.println("Opening file in Windows OS");

	}

	public void writeFile() {
		System.out.println("Writing file in Windows OS");
	}

	public void closeFile() {
		System.out.println("Closing file in Windows OS");
	}

}
