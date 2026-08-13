
package Enum;


public class TransicionEstadoException extends Exception {

    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo) {
        super("No se pude pasar de "+actual+" a "+nuevo+" (estado final actual: "+actual.isEsFInal()+")");
        
    }
    
}
