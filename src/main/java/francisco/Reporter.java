package francisco;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

public class Reporter {
	
	String nameFileReport;
	File fileReport;
	
	public Reporter(String nameFile) throws IOException {
		fileReport=new File(nameFile);
	}
	
	public void reportTrueTest(int numTest) throws IOException {
		FileWriter write=new FileWriter(fileReport,true);
		write.close();
		
	}
	
	public void reportFalseTest() throws IOException {
		FileWriter write=new FileWriter(fileReport,true);
		write.close();
	}
}
