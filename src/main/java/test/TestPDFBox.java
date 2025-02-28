package test;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class TestPDFBox {
    public static void main(String[] args) {
        try {
            File pdfFile = new File("chemin/vers/ton/contrat.pdf");
            PDDocument document = PDDocument.load(pdfFile);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println("Contenu du PDF :\n" + text);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
