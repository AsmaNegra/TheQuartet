package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class FileUtils {

    public static String encodeFileToBase64(File file) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("❌ Fichier introuvable : " + (file != null ? file.getAbsolutePath() : "null"));
        }
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
