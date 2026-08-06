
package herenci;

import java.util.Calendar;

/**
 *
 * @author Leandro
 */
public abstract class Empleadoo {
    protected int codigo;
    protected String nombre;
    protected double salario;
    protected Calendar contratacion;

    public Empleadoo(int codigo, String nombre, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.contratacion = Calendar.getInstance();
    }
    
    public abstract double pago();
    public abstract double bono();
    public abstract String resumen();

    public int getCodigo() {
        return codigo;
    }
    
    public int antiguedad(){
        Calendar fechaActual = Calendar.getInstance();
        int anios = fechaActual.get(Calendar.YEAR) - contratacion.get(Calendar.YEAR);
        if(fechaActual.get(Calendar.DAY_OF_YEAR) < contratacion.get(Calendar.DAY_OF_YEAR)){
            anios--;
        }
        return anios;
    }
    
    public String toString(){
    return codigo+" - "+nombre+" - "+"Lps. "+salario;
    }
    
    
}
