# README

For at kunne køre programmet og spille spillet skal din IDE være sat op med JavaFX. Her følger en guide til hvordan det sættes op i IntelliJ.

## Hent og installer JavaFX-biblioteket
1. Hent JavaFX bibliotek ("JavaFX 15.0.1" eller seneste udgave) på https://gluonhq.com/products/javafx/
2. Åbn IntelliJ
3. Åbn projektet
4. Gå til: <kbd>File</kbd> &rarr; <kbd>Project Structure</kbd> &rarr; <kbd>Libraries</kbd>
5. Tryk på <kbd>+</kbd>-ikonet og vælg <kbd>Java</kbd> i menuen
6. Find frem til mappen hvor JavaFX-biblioteket ligger og vælg undermappen ``lib``
7. Tryk OK
8. Tryk <kbd>Apply</kbd> og tryk <kbd>OK</kbd>

## Konfigurer applikationen i IntelliJ 2020.2.3
1. Gå til: <kbd>Run</kbd> &rarr; <kbd>Edit Configuratios</kbd>
2. Tryk på <kbd>+</kbd>-ikonet og vælg <kbd>Application</kbd> i menuen
3. Vælg selv et navn
4. I tekstfeltet ``Main class`` skriv "com.zuul.application.Game"
5. I tekstfeltet ``VM options`` skriv:

   --module-path "``Sti til lib-mappen i JavaFX-biblioteket``" --add-modules javafx.controls,javafx.fxml
6. Tryk <kbd>Apply</kbd> og tryk <kbd>OK</kbd>
7. Nu kan spillet køres!

## Konfigurer applikationen i IntelliJ 2020.3.0
1. Følg trin ``1 - 4`` i IntelliJ2020.2.3 delen.
2. Click på <kbd>modify options</kbd> og i menuen tilvælg <kbd>VM options</kbd>.
3. Følg trin ``5 - 7`` i IntelliJ2020.2.3 delen.
