
package Enum;

public class CapacidadException extends Exception{
    public CapacidadException(int capacidad){
    super("Capacidad maxima alcanzada("+capacidad+" pedidos)");
    }
}
