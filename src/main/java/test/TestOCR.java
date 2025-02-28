package test;

import controllers.GeminiClient;

public class TestOCR {
    public static void main(String[] args) {
        String contractText = "Ce contrat est valide jusqu'au 22-10-2018 et doit être renouvelé avant cette date.";
        String expirationStatus = GeminiClient.determineExpirationDateFromText(contractText);
        System.out.println(expirationStatus);
    }
}
