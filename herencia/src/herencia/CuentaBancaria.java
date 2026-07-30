
package herencia;
import java.util.*;
public class CuentaBancaria {
    protected int numero;
    protected double saldo;
    protected String cliente, moneda;
    protected Calendar apertura;
    protected TipoCuenta tipo;

    public CuentaBancaria(int numero, String cliente, String moneda) {
        this.numero = numero;
        saldo=0;
        this.cliente = cliente;
        this.moneda = moneda;
        apertura=Calendar.getInstance();
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public String getMoneda() {
        return moneda;
    }

    public Calendar getApertura() {
        return apertura;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }
    
    public void depositar(double monto){
        if (monto>0) {
            saldo+=monto;
        } else{
            System.out.println("No bro");}
    }
    
    public boolean retirar(double monto){
    
    }
    
    
}
