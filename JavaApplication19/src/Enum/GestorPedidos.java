
package Enum;


public class GestorPedidos {
    private final Pedido pedidos[];
    private int cantidad;

    public GestorPedidos(int size) {
        pedidos = new Pedido[size];
        cantidad = 0;
    }
    
    public void agregarPedido(Pedido dato)throws CapacidadException{
        if (cantidad == pedidos.length) {
            throw new CapacidadException(pedidos.length);
        }
        
        pedidos[cantidad] = dato;
        cantidad++;
    }
    
}
