import java.io.*;

public class Lectura{
    public void contarPalabras(File[] archivos, String palabra){ //Falla si al lado hay simbolos
        int contadorCarpeta = 0;

        for (File archivo : archivos) {
            int contadorArchivo = 0;
            try {
                if(archivo.exists() && extensionCorecta(archivo)) {
                    BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                    String lineaLeida;

                    while((lineaLeida = archivoLeer.readLine()) != null) {
                        String[] partes = lineaLeida.split("[, ?.:;@()]");

                        for(int i = 0 ; i < partes.length ; i++) {
                            if(partes[i].equals(palabra)) {
                                contadorCarpeta++;
                                contadorArchivo++;
                            }
                        }
                    }
                    System.out.println(archivo.getName() +" "+ contadorArchivo + " veces");
                    archivoLeer.close();
                } else{
                    System.out.println("El archivo " +archivo.getName() +" no es legible");
                }

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Total: "+ contadorCarpeta);
    }

    public boolean extensionCorecta(File archivo){
        String extension = archivo.getName();
        extension = extension.substring(extension.lastIndexOf(".") + 1);
        if(extension.equals("txt") || extension.equals("xml") || extension.equals("json") || extension.equals("csv")){
            return true;
        }
        return false;
    }

}