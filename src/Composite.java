/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public abstract class File {
        protected String name;
        protected String attributes;
        public File(String name, String attributes) {
                this.name = name;
                this.attributes = attributes;
        }
        public abstract void displayInfo();
}



class Pdf extends File {
        String version;
        public Pdf(String name, String attributes, String version) {
                super(name, attributes);
                this.version = version;
        }
        public void displayInfo() {
                System.out.printf("Name : %s\n", name);
                System.out.printf("Attributes : %s\n", attributes);
                System.out.printf("Version : %s\n", version);
        }
}


class Folder extends File {
        private List<File> files = new ArrayList<File>();
        private String encryption;
        public Folder(String name, String attributes, String encryption) {
                super(name, attributes);
                this.encryption = encryption;
        }
        public void addFile(File file) {
                files.add(file);
        }
        public void removeFile(File file) {
                files.remove(file);
        }
        public void displayInfo() {
                System.out.printf("Name : %s\n", name);
                System.out.printf("Attributes : %s\n", attributes);
                System.out.printf("Encryption : %s\n", encryption);
                for (File file : files) {
                        file.displayInfo();
                }
        }
}

class Program {
        public static void main(String[] args) {
                Folder folder = new Folder("My Documents", "RW", "Blowfish");
                Pdf s1 = new Pdf("Readme.pdf", "RW", "1.0");
                Pdf s2 = new Pdf("SalesReport.pdf", "RWX", "2.0");
                Pdf pdf = new Pdf("Accounts.pdf", "R", "V7");
                folder.addFile(s1);
                folder.addFile(s2);
                folder.addFile(pdf);
                Folder root = new Folder("C:/", "RW", "None");
                root.addFile(folder);
                root.displayInfo();
        }
}