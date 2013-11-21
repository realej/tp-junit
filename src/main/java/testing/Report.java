package testing;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Report {

    public static String status = "success";
    public static int run = 0;
    public static int errors = 0;
    public static int failures = 0;
    public static PrintWriter writer;
    private static Store store = new Store();
    //SACAR COMENTARIOS

    //el header del report
    public static void suiteHeaderReport(SuperTest testSuite) {
        System.out.println(testSuite.getName());
        System.out.println("--------------------");
        System.out.println();
    }

    public static void suiteFileHeaderReport(SuperTest testSuite) throws IOException {
        writer.println(testSuite.getName());
        writer.println("--------------------");
        writer.println();
    }

    public static void suiteFileFooterReport(SuperTest testSuite) {
        writer.println("[" + status + "] " + "Summary");
        writer.println("--------------------");
        writer.println("--------------------");
        writer.println("Run: " + run);
        writer.println("Errors: " + errors);
        writer.println("Failures: " + failures);
    }

    //el footer del report con los resultados
    public static void suiteFooterReport(SuperTest testSuite) {
        System.out.println("[" + status + "] " + "Summary");
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("Run: " + run);
        System.out.println("Errors: " + errors);
        System.out.println("Failures: " + failures);
    }

    // el metodo que hace el reporte de un solo test
    public static void testReport(SuperTest test, String result) {
        System.out.println("[" + result + "] ");
        System.out.println(test.getName());
        run++;
        updateStatus(result);
        updateStatusCounter(result);
    }

    public static void testFileReport(SuperTest test, String result) {
        writer.println("[" + result + "] ");
        writer.println(test.getName());
        if (result.equals("failure") || result.equals("error")) {
            store.addFailedTest(test.getName());
        }
    }

    //usar al final de la totalidad de los tests corridos para poder mas tarde hacer una corrida de otros tests
    public static void clear() {
        run = errors = failures = 0;
        status = "success";
        writer.close();
    }

    private static void updateStatus(String result) {
        if (result == "error" || result == "failure") {
            status = "failure";
        }
    }

    private static void updateStatusCounter(String result) {
        if (result == "error") {
            errors++;
        } else if (result == "failure") {
            failures++;
        }
    }

    private static void suiteHeaderReportXML(TestSuite testSuite) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("report.xsd", "UTF-8");
        writer.println("<xs:element name=" + testSuite.getName() + ">");
        writer.println("\t<xs:complexType>");
        writer.println("<xs:attribute name=" + testSuite.getName() + "type=\"xs:string\" use=\"required\"/>");
        writer.println("<xs:attribute name=" + testSuite.getName() + "type=\"xs:string\" use=\"required\"/>");
    }

    public static void createReport(String fileName) throws FileNotFoundException {
        writer = new PrintWriter("Report.txt");
    }
}
