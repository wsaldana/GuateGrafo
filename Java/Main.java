/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Sección 20
 * 
 * @author Walter Saldaña #19897
 * @version 1.0
 * @since 5/14/2020
 * 
 * GuateGrafo
 * Aplicacion que permite direccionar de una posición de la Ciudad a
 * otra de la manera más rápida por medio de grafos, considerando los
 * cordones sanitarios del Covid-19.
 * 
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

package Java;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import javax.swing.JFileChooser;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Manejar visualizador de archivos
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		//Solicitar archivo del grafo
		JOptionPane.showMessageDialog(null, "A continuacion ingerse un archivo con el grafo");
		jfc.showOpenDialog(null); 
        File file = jfc.getSelectedFile();
        JOptionPane.showMessageDialog(null, "Gracias, ahora puede continuar en la consola del sistema...");

        Controller controller = new Controller(file);
        
        System.out.println("\n------ GUATEGRAFOS ------ \nWalter Saldaña #19897\n");

        //Ciclo del menu de opciones
        Boolean ejecutar = true;
        while (ejecutar) {
            System.out.println("\nPor favor ingrese una de las siguientes opciones: \n   1. Calcular ruta\n   2. Mostrar centro del grafo\n   3. Modificar\n   4. Salir\n");
            String opc = sc.nextLine();

            switch (opc) {
                case "1":
                    controller.route();
                    break;

                case "2":
                    System.out.println("El centro del grafo es: "+controller.getCentro());
                    break;

                case "3":
                    System.out.println("Ingrese (1) interrupcion ; (2) conexion: ");
                    String opc2 = sc.nextLine();
                    System.out.println("Ingrese el punto de partida: ");
                    String p1 = sc.nextLine();
                    System.out.println("Ingrese el punto de destino: ");
                    String p2 = sc.nextLine();
                    if(opc2.equals("1")){
                        controller.interrupcion(p1, p2);
                        System.out.println("Se ha eliminado la ruta deseada");
                    }else if(opc2.equals("2")){
                        System.out.println("Ingrese la distancia en Km: ");
                        String km = sc.nextLine();
                        controller.conexion(p1, p2, Integer.parseInt(km));
                        System.out.println("Se ha creado la ruta deseada");
                    }else{
                        System.out.println("Ingrese una opcion correcta... ");
                    }
                    break;

                case "4":
                    //Salir
                    System.out.println("Tenga un buen dia!");
                    ejecutar = false;
                    break;
            
                default:
                    //Opcion no valida
                    System.out.println("Por favor ingrese una opcion valida...");
                    break;
            }
        }
        
        sc.close();
    }

}