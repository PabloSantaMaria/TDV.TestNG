package restaurant;

import java.util.List;

public class Cocina extends Thread {
    static List<Pedido> pedidos;

    public static void setPedidos(List<Pedido> pedidos) {
        Cocina.pedidos = pedidos;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("cocina");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void cocinar(Receta r) throws SinSuficientesIngredientesException {
        if (Almacen.esPosibleCocinar(r)) {
            for (ItemReceta item : r.getIngredientes())
                Almacen.ExtraerConsumibles(item.getIngrediente(), item.getCantidad());
        } else
            throw new SinSuficientesIngredientesException();
    }
}




