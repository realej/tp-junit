package tp.junit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Administrador
 */
public class XMLear {

    Document doc;
    Element root;

    public XMLear() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();
            root = doc.createElement("testsuites");
            doc.appendChild(root);
        } catch (ParserConfigurationException e) {
        }

    }

    public void agregarSuite(String suiteName, TestResult result) {
        Element suite = doc.createElement("testsuite");
        Attr name = doc.createAttribute("name");
        name.isId();
        name.setValue(suiteName);
        suite.setAttributeNode(name);
        root.appendChild(suite);
        for (TestState state : result.getPasses()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                agregarTest(suite, state.getTestCaseName(), state.getResultTestCase(), state.getTime(), state.getStateTest());
            }
        }

        for (TestState state : result.getFailures()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                agregarTest(suite, state.getTestCaseName(), state.getResultTestCase(), state.getTime(), state.getStateTest());
            }
        }

        for (TestState state : result.getError()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                agregarTest(suite, state.getTestCaseName(), state.getResultTestCase(), state.getTime(), state.getStateTest());
            }
        }
    }

    private void agregarTest(Element suite, String TestCaseName, String ResultTestCase, String time, String State) {
        Element nameTestCase = doc.createElement("testcase");
        Attr nameTC = doc.createAttribute("name");
        Attr timeTC = doc.createAttribute("time");
        Attr statusTC = doc.createAttribute("status");

        timeTC.setValue(time.toString());
        nameTC.setValue(TestCaseName);
        statusTC.setValue(State);

        nameTestCase.setAttributeNode(nameTC);
        nameTestCase.setAttributeNode(timeTC);
        nameTestCase.setAttributeNode(statusTC);

        Attr nameElementTC = doc.createAttribute("name");
        nameElementTC.setValue(TestCaseName);
        
        if (!"PASSED".equals(State)) {
            Element elementTestCase = doc.createElement(State.toLowerCase());
            elementTestCase.setAttributeNode(nameElementTC);
            nameTestCase.appendChild(elementTestCase);
        }

        suite.appendChild(nameTestCase);

    }

    public void guardar(String nameFile) {
        try {
            /* TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(doc);
            
             StreamResult result = new StreamResult(new File(nameFile + ".xml"));
             transformer.transform(source, result);
             */
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            Result result = new StreamResult(new java.io.File(nameFile + ".xml"));
            transformer.transform(source, result);
            System.out.println("File XML saved!");
        } catch (TransformerException tfe) {
        }
    }
}
