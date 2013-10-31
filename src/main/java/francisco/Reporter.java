package francisco;
import java.lang.String;

public class Reporter {
	
	public void reportTrueTest(String nameTest) {
		System.out.println(nameTest + " Test correcto");
	}
	
	public void reportFalseTest(String nameTest) {
		System.out.println(nameTest + " Test incorrecto");
	}
}
