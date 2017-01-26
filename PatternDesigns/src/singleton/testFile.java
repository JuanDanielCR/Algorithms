package singleton;

public class testFile {
	public static void main(String []args){
		//Get a file system for first time
		FileSystem fileManager =  FileSystem.getFileSystemInstance("0x33121");
		System.out.println(fileManager.getMemory()); //"0x33121"
		
		//We will TRY to get another instance, poor of us!
		fileManager =  FileSystem.getFileSystemInstance("Nueva Memoria");
		System.out.println(fileManager.getMemory()); //Still 0x33121 not Nueva Memoria
	}
}
