/**
 * Composite Design Pattern is a structural design pattern that allows
 * you to compose objects into tree structures to represent part-whole hierarchies.
 * It lets clients treat individual objects and compositions of objects uniformly.
 */

import java.util.*;

interface FileSystem {
	void getFileComponent();
	int getSize();
}

class File implements FileSystem {
	String fileName;
	int fileSize;

	public File(String name,int size){
		this.fileName = name;
		this.fileSize = size;
	}

	@Override
	public void getFileComponent(){
		System.out.println(this.fileName);
	} 

	@Override
	public int getSize(){
		return this.fileSize;
	}
}

class Folder implements FileSystem {
	String folderName;
	List<FileSystem> lt;

	public Folder(String name){
		this.folderName = name;
		lt = new ArrayList<>();
	}

	public void addFileComponent(FileSystem obj){
		lt.add(obj);
	}

	public void deleteFileComponent(FileSystem obj){
		lt.remove(obj);
	}

	@Override
	public void getFileComponent(){
		System.out.println(this.folderName);

		 for (FileSystem component : children) {
            component.display();
        }
	}

	@Override
	public int getSize(){
		int tot = 0;
		for(FileSystem fl: lt){
			tot += fl.getSize();
		}
		return tot;
	}
}

public class Main {
	public static void main(String[] args){
		File f1 = new File("file1",2);
		File f2 = new File("file2",3);

		Folder fl1 = new Folder("folder1");
		fl1.addFileComponent(f1);
		fl1.addFileComponent(f2);

		Folder root = new Folder("root-folder");
		root.addFileComponent(fl1);
		root.getFileComponent();
		root.getSize();
	}
}