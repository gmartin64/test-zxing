package com.greta95.projet_zxing;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class App {
	private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
			MatrixToImageWriter.writeToStream(bitMatrix,

					imageFormat, fileOutputStream);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static BitMatrix generateMatrix(String data, int size) {
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return bitMatrix;
	}

	public static void main(String[] args) {
		String data = "La Joconde, ou Portrait de Mona Lisa voire simplement Mona Lisa, est un tableau de l'artiste Léonard de Vinci, réalisé entre 1503 et 1506"

		/*
		 * "ou entre 1513 et 1516, et peut-être jusqu'à 1519, qui représente un portrait
		 * mi-corps, probablement celui de la Florentine Lisa Gherardini, épouse de
		 * Francesco del Giocondo. Acquise par François Ier, cette peinture à l'huile
		 * sur panneau de bois est exposée au musée du Louvre à Paris."
		 */;
		int size = 400;
// encode 
		BitMatrix bitMatrix = generateMatrix(data, size);
		String imageFormat = "png";
		String outputFileName = "c:/qrcode/qrcode-01." + imageFormat;
// le QRcode est sauvé dans le fichier c:\qrcode\qrcode-01.png 
		writeImage(outputFileName, imageFormat, bitMatrix);
	}
}