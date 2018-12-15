package de.mide;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * Demo für Verwendung von CSS, um UI-Eigenschaften in einer JavaFX-Anwendung zu definieren.
 * <br>
 
 * Doku der CSS-Eigenschaften von JavaFX: https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
 */
public class JavaFXmitCSS extends Application {

 /**
  * Lifecycle-Methode, überschreiben für Aufbau der Oberfläche.
  *
  * @param stage  Vergleichbar mit "JFrame"-Instanz bei Swing.
  */
  @Override
  public void start(final Stage stage) throws Exception {

      FlowPane flowPane = new FlowPane(25, 25); // horizontaler & vertikaler Abstand


      // Label 1: CSS über String mit Methode <i>setStyle</i> zuweisen
      Label label1 = new Label("Label 1");
      label1.setStyle("-fx-background-color: yellow; -fx-text-fill: red;"); // -fx-text-fill: Textfarbe
      flowPane.getChildren().add( label1 );


      // Label 2: CSS über externe CSS-Datei
      Label label2 = new Label("Label 2");
      label2.setId("spezial_label"); // diese ID wird auch in der CSS-Datei verwendet
      flowPane.getChildren().add( label2 );


      // Buttons: CSS wird in externer CSS-Datei über Klassen-Selektor festgelegt.
      Button button1 = new Button("Dummy-Button 1");
      flowPane.getChildren().add( button1 );

      Button button2 = new Button("Dummy-Button 2");
      flowPane.getChildren().add( button2 );


      // Szene erzeugen und externe CSS-Datei laden
      Scene scene = new Scene( flowPane, 300, 200 ); // Breite=300, Höhe=200

      // Datei "Stil.css" laden, die im selben Verzeichnis wie die Java-Datei der
      // vorliegenden Klasse liegt.
      String externalUrl = this.getClass().getResource("Stil.css").toExternalForm();
      scene.getStylesheets().add( externalUrl );

      // Stage konfigurieren & sichtbar machen
      stage.setScene( scene );
      stage.setTitle("JavaFX mit CSS" );
      stage.centerOnScreen();
      stage.show();
  }



 /**
  * Eintritts-Methode
  *
  * @param args  Wird nicht ausgewertet
  */
  public static void main(String[] args) {

      launch(args); // Statische Methode aus Oberklasse Application aufrufen
  }

};