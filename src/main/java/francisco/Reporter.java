package francisco;
import java.lang.String;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {
	
	private File fileRepoter;
	private FileWriter writer;
	
	
	public Reporter(String fileName) throws IOException {
		File fileReporter = new File(fileName);
		FileWriter writer =new FileWriter(fileReporter,true);
		writer.write(fileName);
	}

	
	public void reportTrueTest(String nameTest) {
		System.out.println(nameTest + " OK");
	}
	
	public void reportFalseTest(String nameTest) {
		System.out.println(nameTest + " ERROR");
	}
	
	public void reportFailureTest(String nameTest) {
		System.out.println(nameTest + " FAILURE");
	}
	
	public void reportTrueTestFile(String nameTest) throws IOException {
		writer.write(nameTest + " OK");
	}
	
	public void reportFalseTestFile(String nameTest) throws IOException {
		writer.write(nameTest + " ERROR");
	}
	
	public void reportFailureTestFile(String nameTest) throws IOException {
		writer.write(nameTest + " FAILURE");
	}
	
}
