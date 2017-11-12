package designpattern.designpattern.command;

public class WriteFileCommand implements Command {

	private FileSystemReceiver fileSystem;

	public WriteFileCommand(FileSystemReceiver fs) {
		this.fileSystem = fs;
	}

	public void execute() {
		this.fileSystem.writeFile();
	}

}
