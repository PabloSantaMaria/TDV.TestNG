package restaurantTest;

import restaurant.Ingrediente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* Le das el path al .csv y te devuelve el arreglo de familias */
public class CSVReader {

    private final String path;

    public CSVReader(String path) {
        this.path = path;
    }

    public ArrayList<Ingrediente> read() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        ArrayList<String> lines = this.readContent();
        for (String line : lines)
            ingredientes.add(this.parseLine(line));
        return ingredientes;
    }

    private Ingrediente parseLine(String line) {
        String[] splitted = line.split(",");

        String name = splitted[0];
        String unit = splitted[1];
        int qty = Integer.parseInt(splitted[2]);
        int price = Integer.parseInt(splitted[3]);

        return new Ingrediente(name, unit, qty, price);
    }

    private ArrayList<String> readContent() {
        ArrayList<String> lines = new ArrayList<>();

        File file = new File(this.path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine(); // Salteo la primera linea
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

        return lines;
    }

}
