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
	
	public void reportTrueTest(String nameTest) throws IOException {
		FileWriter writerTrue=new FileWriter(fileReport,true);
		writerTrue.write(nameTest + "Test correcto");
		writerTrue.close();
		
	}
	
	public void reportFalseTest(String nameTest) throws IOException {
		FileWriter writerFalse=new FileWriter(fileReport,true);
		writerFalse.write(nameTest + "Test incorrecto");
		writerFalse.close();
	}
}
