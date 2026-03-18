package perez.cordero.projecte_ra5_ra7.utils;

// Importaciones de la librería ZXing para la generación de códigos de barras y QR
import com.google.zxing.qrcode.QRCodeWriter;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.nio.file.Path;

/**
 * Clase de utilidad para la generación de códigos QR.
 * Transforma la información de un objeto Animal en una imagen PNG.
 */
public class QRUtils {

    /**
     * Genera un archivo de imagen QR basado en los datos de un animal.
     * @param a El objeto Animal del cual extraeremos la información.
     * @return El archivo File generado o null si ocurre un error.
     */
    public static File generaCodiQR(Animal a) {
        try {
            // Convertimos el objeto a String usando su método toString()
            // Este texto será el contenido que se codificará dentro del QR.
            String text = a.toString();

            // Definimos la ruta y el nombre del archivo (nombre_del_animal.png)
            File fitxer = new File("fitxers/codisQR/" + a.getNom() + ".png");

            // Nos aseguramos de que las carpetas de la ruta existan (si no, las crea)
            fitxer.getParentFile().mkdirs();

            // QRCodeWriter es el motor que codifica el texto en una matriz de bits (ceros y unos)
            // Definimos el formato QR_CODE y un tamaño de 200x200 píxeles.
            BitMatrix matrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);

            // Convertimos el File a Path para que la librería pueda escribir en él
            Path path = fitxer.toPath();

            // Transformamos la matriz de bits en una imagen real de formato PNG en el disco
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            return fitxer;
        } catch (Exception e) {
            // Si algo falla (permisos de escritura, errores de librería...), imprimimos el error
            e.printStackTrace();
            return null;
        }
    }
}