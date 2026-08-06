package herenci;

import java.util.Calendar;
import java.util.Locale;

public class EmpleadoPorVenta extends Empleadoo {

    public double[] ventas = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public EmpleadoPorVenta(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
    }

    private int getMes() {
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.MONTH);
    }

    public void actualizarVentas(double monto) {
        int mes = getMes();
        ventas[mes] += monto;
    }

    public double getComision() {
        return ventas[getMes()] * 0.05;
    }

    public String toString() {
        Calendar hoy = Calendar.getInstance();
        String mes = hoy.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es"));
        return super.toString() + "tasa: 5%, ventas de " + mes
                + " : " + ventas[getMes()];
    }

    @Override
    public double pago() {
        return salario + getComision();
    }

    private double ventasAnuales() {
        double total = 0;
        for (double venta : ventas) {
            total += venta;
        }
        return total;
    }

    @Override
    public double bono() {
        double totalAnual = ventasAnuales();
        
        if (totalAnual>100000) {
            return totalAnual*0.1;
        }
        else if (totalAnual > 50000){
            return totalAnual*0.07;
        }
        else 
        return totalAnual*0.03;
        

    }

    @Override
    public String resumen() {
        return "Empleado por venta - ventas anuales: Lps. " + 
            ventasAnuales() + ", bono anual: Lps. "+bono();
    }

}
