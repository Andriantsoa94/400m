package service;

import model.Voiture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class JsonService {
    public List<Voiture> chargerVoiture(String chemin) throws IOException {
        List<Voiture> vtr = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.contains("nom")) {
                    String nom = exValue(ligne);
                    double acceleration = parseDouble(exValue(br.readLine()));
                    double vmax = parseDouble(exValue(br.readLine()));
                    vtr.add(new Voiture(nom , vmax , acceleration));
                }
            }
        }
        return vtr;
    }
    private String exValue(String ligne) {
        return ligne.split(":")[1].replace("\"" ,  "").replace("," ,"");
    }
}