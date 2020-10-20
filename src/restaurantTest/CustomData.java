package restaurantTest;

import org.testng.annotations.DataProvider;
import restaurant.Ingrediente;
import restaurant.Usuario;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomData {

    /*
    a) Básico
    i) Verificar la carga de ingredientes al almacén utilizando un
    generador que agregue: Sal, huevos, fideos, carne picada,
    papa.
     */
    @DataProvider(name = "ingredientes")
    public static Object[][] foo() {
        return new Object[][]{
                {new Ingrediente("sal", "g", 0, 1)},
                {new Ingrediente("huevos", "u", 0, 1)},
                {new Ingrediente("fideos", "g", 0, 1)},
                {new Ingrediente("carne picada", "g", 0, 1)},
                {new Ingrediente("papa", "g", 0, 1)}
        };
    }

    @DataProvider(name = "ingredientes2")
    public static Object[][] foo2() {
        return new Object[][]{
                {"sal", "g", 0, 1},
                {"huevos", "u", 0, 1},
                {"fideos", "g", 0, 1},
                {"carne picada", "g", 0, 1},
                {"papa", "g", 0, 1}
        };
    }

    @DataProvider(name = "ingredientes3")
    public static Object[][] foo3() {
        Object[][] ingredientes = new Object[5][1];

        for (int i = 0; i < ingredientes.length; i++) {
            ingredientes[i][0] = new Ingrediente("ing"+i,"un"+i,i,i);
        }

        return ingredientes;
    }

    @DataProvider (name="CSVData")
    public static Iterator<Object[]> getCSVData(){
        CSVReader reader = new CSVReader("./CSVData.csv");

        ArrayList<Ingrediente> ingredientes = reader.read();
        ArrayList<Object[]> objects = new ArrayList<>();

        for (Ingrediente ingrediente : ingredientes)
            objects.add(new Object[]{ingrediente});
        return objects.iterator();
    }

    /*
    ii) Crear un generador estático con los usuarios: José, Lucia,
    Kevin, Martín y Ana
     */
    @DataProvider(name = "users")
    public static Object[][] getUsers() {
        return new Object[][] {
                {new Usuario("José", 1, 100, "a@a.com")},
                {new Usuario("Lucia", 1, 100, "a@a.com")},
                {new Usuario("Kevin", 1, 100, "a@a.com")},
                {new Usuario("Martín", 1, 100, "a@a.com")},
                {new Usuario("Ana", 1, 100, "a@a.com")}
        };
    }

}
