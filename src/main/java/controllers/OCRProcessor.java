package controllers;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import java.net.URL;

public class OCRProcessor {
    public static String extractTextFromImage(String imagePath) {
        // Définition du chemin vers `tessdata/`
        URL tessDataUrl = OCRProcessor.class.getClassLoader().getResource("tessdata/");
        if (tessDataUrl == null) return "Erreur : Dossier tessdata introuvable.";

        String tessDataPath = new File(tessDataUrl.getPath()).getAbsolutePath();
        System.setProperty("TESSDATA_PREFIX", tessDataPath);

        // Initialisation de Tesseract
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        tesseract.setLanguage("eng"); // Changer en "fra" si besoin

        // Vérification de l'image
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) return "Erreur : L'image spécifiée n'existe pas.";

        try {
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            return "Impossible d'extraire le texte.";
        }
    }
}
