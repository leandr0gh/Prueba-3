
package herencia;
import java.util.*;

public class CuentaAhorro extends CuentaBancaria{
    private Calendar ultimoUso;
    
    public CuentaAhorro(int numero, String cliente, String moneda){
    super(numero, cliente, moneda);
    this.tipo = TipoCuenta.ahorro;
    this.ultimoUso = Calendar.getInstance();
    }
    
    public boolean isActiva(){
    Calendar limit = Calendar.getInstance();
    limit.add(Calendar.MONTH, -6);
    return ultimoUso.after(limit);
    }
    
    public void depositar(double monto){
        if (!isActiva()) {
            throw new IllegalStateException("Esta Cuenta esta inactiva");
        }
        super.depositar(monto);
        ultimoUso = Calendar.getInstance();
    }
    
    public boolean retirar(double monto){
        if (!isActiva()) {
            throw new IllegalStateException("Esta cuenta esta inactiva");
        }
        boolean ok = super.retirar(monto);
        if (ok) {
            ultimoUso = Calendar.getInstance();
        }
        return ok;
    }
    
    @Override
    public String toString(){
        return super.toString() + " Ultima vez usada: "+ultimoUso.getTime();
    }
}
