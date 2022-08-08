package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileController {
    private File objectFile;
    private File object2File;
    private File charFile;

    public FileController() throws IOException {
        this.objectFile = new File("assets/object.json");
        this.object2File = new File("assets/object2.json");
        this.charFile = new File("assets/char.json");
    }

    // Para leer
    public String readObjectFile() throws FileNotFoundException {
        String text = "";
        Scanner sc = new Scanner(objectFile);
        while (sc.hasNextLine()) {
            text += sc.nextLine();
        }
        sc.close();
        return text;
    }

    public String readObject2File() throws FileNotFoundException {
        String text = "";
        Scanner sc = new Scanner(object2File);
        while (sc.hasNextLine()) {
            text += sc.nextLine();
        }
        sc.close();
        return text;
    }

    public String charFile() throws FileNotFoundException {
        String text = "";
        Scanner sc = new Scanner(charFile);
        while (sc.hasNextLine()) {
            text += sc.nextLine();
        }
        sc.close();
        return text;
    }

    // Para escribir
    public void writeObjectFile(String text) throws IOException {
        objectFile.mkdirs();
        FileWriter fileWriter = new FileWriter("assets/object.json");
        fileWriter.write(text);
        fileWriter.close();
    }

    public void writeObject2File(String text) throws IOException {
        object2File.mkdirs();
        FileWriter fileWriter = new FileWriter("assets/object2.json");
        fileWriter.write(text);
        fileWriter.close();
    }

    public void charFile(String text) throws IOException {
        charFile.mkdirs();
        FileWriter fileWriter = new FileWriter("assets/char.json");
        fileWriter.write(text);
        fileWriter.close();
    }

    //Para el tamaño
    public long sizeObjectFile() {
        return objectFile.length();
    }
    public long sizeObject2File() {
        return object2File.length();
    }
    public long sizeCharFile() {
        return charFile.length();
    }

}