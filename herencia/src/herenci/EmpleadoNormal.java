
package herenci;

import java.util.Calendar;

public class EmpleadoNormal extends Empleadoo{
    
    public EmpleadoNormal(int codigo, String nombre, double salario){
    super(codigo, nombre, salario);
    }

    @Override
    public double pago() {
        return salario-(salario*0.035);
    }

    @Override
    public double bono() {
        int anios = antiguedad();
        double porcentaje = Math.min(anios*0.05, 0.25);
        return salario*porcentaje;
    }

    @Override
    public String resumen() {
        return "Empleado Normal - "+antiguedad()+
                " anio(s) de antiguedad, bono anual: Lps. "+bono();
    }
    
    
}
