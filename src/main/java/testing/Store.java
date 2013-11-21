package testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Store {

    private FileWriter storeFile;

    public Store() {
    }

    public void addNotRunTest(String testName) {

        try {
            storeFile = new FileWriter("Store.txt", true);
            BufferedWriter bufferWrite = new BufferedWriter(storeFile);
            PrintWriter output = new PrintWriter(bufferWrite);
            output.println(testName);
            output.close();
        } catch (java.io.IOException ioex) {
            System.out.println("se presento el error: " + ioex.toString());
        }
    }

    public boolean isStoreTest(String testName) {
        boolean result = false;
        try {
            FileReader fr = new FileReader("Store.txt");
            BufferedReader input = new BufferedReader(fr);
            String s;
            while ((s = input.readLine()) != null) {
                if (testName.equals(s)) {
                    result = true;
                }
            }
            input.close();
        } catch (java.io.FileNotFoundException fnfex) {
            System.out.println("se presento el error: " + fnfex.toString());
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void deleteStore(){
        try {
            File fichero = new File("Store.txt");
            if (!fichero.delete()) {
                throw new Exception("El fichero Store.txt no puede ser borrado!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
