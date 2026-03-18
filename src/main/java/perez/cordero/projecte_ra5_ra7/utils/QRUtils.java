package perez.cordero.projecte_ra5_ra7.utils;


import com.google.zxing.qrcode.QRCodeWriter;
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.nio.file.Path;

public class QRUtils {

    public static File generaCodiQR(Animal a) {
        try {
            String text = a.toString();
            File fitxer = new File("fitxers/codisQR/" + a.getNom() + ".png");
            fitxer.getParentFile().mkdirs();

            BitMatrix matrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, 200, 200);
            Path path = fitxer.toPath();

            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            return fitxer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}