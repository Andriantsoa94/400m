import model.Voiture;
import service.JsonService;
import view.MainFrame;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {
        String path = "data/Voitures.json";

        JsonService jserv = new JsonService();

        List<Voiture> vtr = jserv.chargerVoiture(path);

        MainFrame main = new MainFrame(vtr);
        main.setVisible(true);

        for (Voiture voiture : vtr) {
            System.out.println(voiture.getNom() + " "+ voiture.getAcceleration() + " " + voiture.getVitesseMax());
        }
    }
}
