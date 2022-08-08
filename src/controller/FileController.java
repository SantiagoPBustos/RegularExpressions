package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileController {
    private File objectFile;

    public FileController() throws IOException {
        this.objectFile = new File("assets/object.json");
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

    // Para escribir
    public void writeObjectFile(String text) throws IOException {
        objectFile.mkdirs();
        FileWriter fileWriter = new FileWriter("assets/object.json");
        fileWriter.write(text);
        fileWriter.close();
    }

    //Para el tamaño
    public long sizeObjectFile() {
        return objectFile.length();
    }

}