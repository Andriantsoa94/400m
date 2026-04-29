TODO LIST - PROJET DRAG RACE 400M (JAVA SWING)

==================================================
PHASE 1 : PREPARATION DES DONNEES & MODELE
==================================================
-   [x] Creer le dossier 'data/' a la racine du projet.
-   [x] Creer le fichier 'data/voitures.json'.
Structure : [ { "nom": "...", "vitesseMax": 200, "acceleration": 25.0 }, ... ]
-   [x] Creer la classe Voiture.java (String nom, double vitesseMax, double acceleration).
-   [ ] Creer JsonService.java pour charger la liste des voitures.

==================================================
PHASE 2 : INTERFACE GRAPHIQUE (UI)
==================================================
-   [ ] MainFrame.java : Layout BorderLayout.
-   [ ] DashPanel.java (Haut) : Labels Chrono, Vitesse, Distance + JComboBox (Selection voiture).
-   [ ] TrackPanel.java (Centre) : Zone de dessin (paintComponent).
-   [ ] Dessiner Route, Ligne Depart (50px), Ligne Arrivee (Largeur-50px).
-   [ ] Panneau Controle (Bas) : Bouton START + Bouton ACCELERER (MouseListener).

==================================================
PHASE 3 : LOGIQUE PHYSIQUE & TIMER
==================================================
-   [ ] Timer Swing : delai 10ms (100 FPS).
-   [ ] Gestion Acceleration :
  - MousePressed -> isAccelerating = true.
  - MouseReleased -> isAccelerating = false.
-   [ ] Boucle de calcul (Timer) :
- chrono += 0.01.
- SI isAccelerating : vitesse += (accel / 3.6) * 0.01.
- Brider vitesse : vitesse = min(vitesse, vMax / 3.6).
- distance += vitesse * 0.01.
-   [ ] Detection 400m :
  - SI distance >= 400 et fini == false : tempsRecord = chrono, fini = true.

==================================================
PHASE 4 : ANIMATION & RENDU
==================================================
-   [ ] Calcul echelle : pixelsParMetre = (largeur_piste - 100) / 400.0.
-   [ ] Dessin Voiture : x = 50 + (distance * pixelsParMetre).
-   [ ] Update UI : Appeler repaint() + mettre a jour les JLabels (Vitesse, Chrono, Dist).

==================================================
PHASE 5 : TESTS & FINITIONS
==================================================
-   [ ] Test Depart lance : accelerer avant 0.00s.
-   [ ] Test Inertie : verifier que la vitesse ne baisse pas si on lache le bouton.
-   [ ] Test Chrono : verifier qu'il continue de defiler apres la ligne.
-   [ ] Gestion d'erreur : Fichier JSON manquant ou corrompu.