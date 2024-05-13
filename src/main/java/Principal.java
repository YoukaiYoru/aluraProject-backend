import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Escriba el tipo de moneda de la consulta: ");
        String tipo = lectura.nextLine();
        System.out.println("Escriba el tipo de moneda a la que quiere consultar su cambio: ");
        String cambio = lectura.nextLine();
        System.out.println("Escriba el monto para cambiar:");
        double monto = lectura.nextDouble();
        try{
            Moneda moneda =consulta.cambioDeMoneda(tipo,cambio,monto);
            System.out.println(moneda);
            System.out.println("El cambio sería: " + moneda.conversion_result());
            GeneradorDeArchivo archivo = new GeneradorDeArchivo();
            archivo.guardarJson(moneda);
        } catch (NumberFormatException e){
            System.out.println("Moneda no encontrada "+e.getMessage());
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}