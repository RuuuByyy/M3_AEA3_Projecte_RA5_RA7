package perez.cordero.projecte_ra5_ra7.utils;


import com.google.zxing.qrcode.QRCodeWriter;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.Path;
import java.nio.file.Paths;

public class QRUtils {

    public static void generarQR(Animal a) {
        try {
            String text = a.toString();
            String ruta = "fitxers/codisQR/" + a.getNom() + ".png";

            BitMatrix matrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);
            Path path = Paths.get(ruta);

            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}