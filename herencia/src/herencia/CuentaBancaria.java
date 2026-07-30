
package herencia;
import java.util.*;
public class CuentaBancaria {
    protected int numero;
    protected double saldo;
    protected String cliente, moneda;
    protected Calendar apertura;
    protected TipoCuenta tipo;
    protected String[] historial=new String[50];
    protected int cantidadMovimientos=0;

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
        if (monto<0) {
            throw new IllegalArgumentException(" El monto no puede ser negativo");
        }
        saldo+=monto;
        registrarMovimiento("DEPOSITO: "+monto+" saldo: "+saldo);
    }
    
    public boolean retirar(double monto){
        if (monto<0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        } 
        if (monto > saldo) {
            return false;
        }
        
        saldo-=monto;
        registrarMovimiento("RETIRO: "+monto+" saldo: "+saldo);
        return true;
    }
    
    public void registrarIntereses(){
    saldo+=saldo*tipo.tasa();
    }
    
    protected void registrarMovimiento(String status){
    try{
    
        if (cantidadMovimientos >= historial.length) {
            throw new ArrayIndexOutOfBoundsException("El historial esta lleno.");
        }
        historial[cantidadMovimientos]=status;
        cantidadMovimientos++;
} catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Se hizo el movimiento exitosamente pero no se pudo guardar en el historial");
}
    }
    
    public String toString(){
    return "Numero de cuenta: "+numero+" Nombre de cliente: "+cliente+" Saldo: "+saldo+" Tipo de cuenta: "+tipo+" Fecha de apertura: "+apertura.getTime();
    }
    
    public void imprimirHistorial(String[] historial, int cantidadMovimientos){
        imprimirHistorialRec(historial, cantidadMovimientos, 0);
    }
    private void imprimirHistorialRec(String[] historial, int CantidadMovimientos, int i){
        if (i>= cantidadMovimientos) {
            return;
        }
        System.out.println(historial[i]);
        imprimirHistorialRec(historial, CantidadMovimientos, i+1);
    }
    
    
}
