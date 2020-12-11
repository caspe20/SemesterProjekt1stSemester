# README

For at kunne køre programmet og spille spillet skal din IDE være sat op med JavaFX. Her følger en guide til hvordan det sættes op i IntelliJ.

## Hent og installer JavaFX-biblioteket
1. Hent JavaFX bibliotek ("JavaFX 15.0.1" eller seneste udgave) på https://gluonhq.com/products/javafx/
2. Åbn IntelliJ
3. Åbn projektet
4. Gå til: File &rarr; Project Structure &rarr; Libraries
5. Tryk på <kbd>+</kbd>-ikonet og vælg "Java" i menuen
6. Find frem til mappen hvor JavaFX-biblioteket ligger og vælg undermappen "lib"
7. Tryk OK
8. Tryk Apply og tryk OK

## Konfigurer applikationen
1. Gå til: Run &rarr; Edit Configurations
2. Tryk på <kbd>+</kbd>-ikonet og vælg "Application" i menuen
3. Vælg selv et navn
4. I tekstfeltet "Main class" skriv "com.zuul.application.Game"
5. I tekstfeltet "Program arguments" skriv:

        --module-path "[Sti til lib-mappen i JavaFX-biblioteket]" --add-modules javafx.controls,javafx.fxml
6. Tryk Apply og tryk OK
7. Nu kan spillet køres!
