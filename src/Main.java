import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Lectura leer = new Lectura();
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese la ruta de la carpeta con los archivos: ");
        String carpeta = in.nextLine();

        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = in.nextLine();

        File carpetaArchivos = new File(carpeta);
        if (!carpetaArchivos.exists()) {
            try {
                throw new FileNotFoundException("La ruta " + carpeta + " no es válida");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        File[] archivos = carpetaArchivos.listFiles();
        leer.contarPalabras(archivos, palabra);

    }
}