
package herencia;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion;
        
        do {
        System.out.println("Banco Finanzas del Valle");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Depositar");
        System.out.println("3. Retirar");
        System.out.println("4. Transferir");
        System.out.println("5. Aplicar intereses a todas las cuentas");
        System.out.println("6. Ver reporte ordenado por saldo y saldo total");
        System.out.println("7. Ver historial de una cuenta");
        System.out.println("8. Salir");
        System.out.println("elegir una opcion");
        opcion=sc.nextInt();
        } while (opcion != 8);
    }
}
