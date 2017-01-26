package singleton;

/**In a Monolithic OS there is only 1 FileSystem, so use Singleton to get 1 instance
 * through all execution*/

public class FileSystem {
	private static FileSystem onlyInstance;
	private String memory;
	//Add more code as needed...
	
	/**Private Constructor*/
	private FileSystem(String memory){
		this.memory =  memory;
	}
	/**Static method to control returning same instance*/
	public static FileSystem getFileSystemInstance(String memory){
		if(onlyInstance == null) onlyInstance =  new FileSystem(memory);
		return onlyInstance;
	}
	
	//Normal file system code in here... actually this would be in C
	public String getMemory() {
		return memory;
	}
}
