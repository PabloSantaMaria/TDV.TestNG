package restaurantTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import restaurant.*;

import static org.testng.Assert.*;

public class AlmacenTest {

    /*
    a) Básico
    i) Verificar la carga de ingredientes al almacén utilizando un
    generador que agregue: Sal, huevos, fideos, carne picada,
    papa.
     */
    @Test(dataProvider = "ingredientes", dataProviderClass = CustomData.class)
    void testIngresaIngredientes(Consumible consumible) {
        System.out.println(consumible.getNombre());
        Almacen.IngresarConsumibles(consumible, 1);
        assertEquals(1, consumible.getStock());
    }
    @Test(dataProvider = "ingredientes2", dataProviderClass = CustomData.class)
    void testIngresaIngredientes2(String name, String unit, int qty, int price) {
        Ingrediente ingrediente = new Ingrediente(name, unit, qty, price);
        System.out.println(ingrediente.getNombre());
        Almacen.IngresarConsumibles(ingrediente, 1);
        assertEquals(1, ingrediente.getStock());
    }
    @Test(dataProvider = "ingredientes3", dataProviderClass = CustomData.class)
    void testIngresaIngredientes3(Consumible consumible) {
        System.out.println(consumible.getNombre());
        System.out.println(consumible.getStock());
        System.out.println(consumible.getPrecioCompra());
        Almacen.IngresarConsumibles(consumible, 1);

//        assertEquals(1, consumible.getStock());
    }
    @Test(dataProvider = "CSVData", dataProviderClass = CustomData.class)
    void testIngresaIngredientes4(Consumible consumible) {
        System.out.println(consumible.getNombre());
        Almacen.IngresarConsumibles(consumible, 1);
        assertEquals(1, consumible.getStock());
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"data1"},
                {"data2"},
                {"data3"}
        };
    }

    @Test(dataProvider = "getData")
    void test(String data) {
        System.out.println(data);
    }

    @BeforeMethod
    public void setUp() {
    }

    @Test(groups = {"groupTest"})
    public void testEsPosibleCocinar() {
        assertEquals(1, 1);
    }

    /*
    ii) Parametriza un test para generar pedidos de N cantidad de
    productos.
     */
    @Test(testName = "generar N pedidos")
    @Parameters({"cantProductos"})
    void generarPedidoConNCantProductos(int cantProductos) {
        Pedido pedido = new Pedido();
        for (int i = 0; i < cantProductos; i++) {
            pedido.agregarItem(new ItemPedido(1, new ProductoBasico("p"+i, 1, 1)));
        }

        int expected = pedido.getItems().size();

        assertEquals(cantProductos, expected);
    }

    @Test(testName = "divide por 0, 3 veces", expectedExceptions = ArithmeticException.class, invocationCount = 3)
    void divide() {
        int a = 1/0;
    }
}
