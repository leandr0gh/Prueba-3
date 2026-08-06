
package herenci;
import java.util.*;

public class Empresa {
    private static ArrayList<Empleadoo> empleados = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    private static Empleadoo buscar(int codigo){
        for (Empleadoo e : empleados) {
            if (e.getCodigo()==codigo) {
                return e;
            }
        }
        return null;
    }
    
    public static void agregarEmpleado(int codigo, String nombre, String tipo){
        Empleadoo nuevo;
        if (buscar(codigo)!=null) {
            System.out.println("Ya existe un empleado con ese codigo. Codigo: "+codigo);
            return;
        }
        System.out.println("Ingrese su salario");
        double salario=sc.nextDouble();
        
        
        if (tipo.equalsIgnoreCase("normal")) {
            nuevo = new EmpleadoNormal(codigo, nombre, salario);
        } else if (tipo.equalsIgnoreCase("Temporal")){
        nuevo = new EmpleadoTemporal(codigo, nombre, salario);
        } else {
            nuevo = new EmpleadoPorVenta(codigo, nombre, salario);
        }
        empleados.add(nuevo);
    }
    
    public static double pagarEmpleado(int codigo){
        if (buscar(codigo)==null) {
            return 0;
        }
        return buscar(codigo).pago();
    }
    
    public static void registrarVenta(int codigo, double monto){
        if (buscar(codigo)!=null && buscar(codigo) instanceof EmpleadoPorVenta) {
            ((EmpleadoPorVenta) buscar(codigo)).actualizarVentas(monto);
        }
    }
    
    public static void setFechaFin(int codigo, int anio, int mes, int dia) {
        if (buscar(codigo) != null && buscar(codigo) instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) buscar(codigo)).setFinContrato(anio, mes, dia);
        }
    }
    
    public static void imprimir() {
        int normales = 0, temporales = 0, porVenta = 0;
 
        for (Empleadoo e : empleados) {
            System.out.println(e.toString());
 
            if (e instanceof EmpleadoNormal) {
                normales++;
            } else if (e instanceof EmpleadoTemporal) {
                temporales++;
            } else if (e instanceof EmpleadoPorVenta) {
                porVenta++;
            }
        }
 
        System.out.println(normales + "-" + temporales + "-" + porVenta);
    }
    
    public static void main(String[] args) {
        agregarEmpleado(1, "Leandro Sandoval", "NORMAL");
        agregarEmpleado(2, "Alex Lopez", "TEMPORAL");
        agregarEmpleado(3, "Jose Jose", "VENTA");
        
        setFechaFin(2, 2027, 12, 31); // vigente
        setFechaFin(4, 2020, 1, 1); //vencio
        registrarVenta(3, 15000);
        registrarVenta(3, 8000);

        for (int codigo = 1; codigo <= 4; codigo++) {
            System.out.println("Pago empleado " + codigo + ": Lps. " + pagarEmpleado(codigo));
        }
        
        
    }
}
 
