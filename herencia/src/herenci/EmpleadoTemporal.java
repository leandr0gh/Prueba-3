
package herenci;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleadoo{
    
    public Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        this.finContrato = Calendar.getInstance();
    }
    
    public void setFinContrato(int ano, int mes, int dia){
    finContrato.set(ano, mes-1, dia);
    }
    
    public String toString(){
    return super.toString() + "Fin de contrato: "+fechaBetter(finContrato);
    }
    
    private String fechaBetter(Calendar finContrato){
    return finContrato.get(Calendar.DAY_OF_MONTH)+"/"+finContrato.get(Calendar.MONTH)+
            "/"+finContrato.get(Calendar.YEAR);
    }
    
    private boolean contratoVencido(){
    Calendar hoy = Calendar.getInstance();
    return !finContrato.after(hoy);
    }

    @Override
    public double pago() {
        if (contratoVencido()) {
            return 0;
        }
        return salario;
    }

    @Override
    public double bono() {
        if (contratoVencido()) {
            return 0;
        }
        Calendar hoy = Calendar.getInstance();
        int mesesRestantes = mesesEntre(hoy, finContrato);
        double porcentaje = mesesRestantes*0.02;
        if (porcentaje>0.10) {
            porcentaje = 0.10;
        }
        return salario*porcentaje;
    }
    
    private int mesesEntre(Calendar from, Calendar to){
    int anos = to.get(Calendar.YEAR)-from.get(Calendar.YEAR);
    int meses = to.get(Calendar.MONTH)-from.get(Calendar.MONTH);
    int totalMonths = anos*12+meses;
        if (totalMonths < 0) {
            totalMonths = 0;
        }
        return totalMonths;
    }

    @Override
    public String resumen() {
        if (contratoVencido()) {
            return "Empleado Temporal - su contrato finalizo, no hay bono";
        }
        return "Empleado Temporal - su contrato vence hasta "+fechaBetter(finContrato)
                +" y su bono es de Lps: "+bono();
    }
    
}
