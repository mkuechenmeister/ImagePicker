package sample.Model;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ArrayList;

public class FileWorker {

    private File sourceFile;

    private ArrayList<String> listOfRawFiles; //Wenn vorhanden
    private ArrayList<String> listOfJpegFiles; //Diese Dateien werden für die Image-Darstellung verwendet
    private String directoryOfSourceFile;  //Wird im laufe des Projektes benötigt
    private String directoryofAcceptedImages; //Ja Ordner
    private String directoryOfDeniedImages; // Nein Ordner

    public FileWorker() {
        this.sourceFile = null;
        this.listOfRawFiles = null;
        this.listOfJpegFiles = null;
        this.directoryOfSourceFile = null;
        this.directoryofAcceptedImages = null;
        this.directoryOfDeniedImages = null;
    }

//Step 1 auswahl des Quellordners und umlabeln des GUI-Labels



    /**
     * Methode zum auswählen des Quellordners in dem sich die Bilder befinden
     * @param actionEvent
     * @param labelSource
     */
    public void chooseSourceFile(ActionEvent actionEvent, Label labelSource) {
        setSourceFile(selectSourceDirectory());
        labelSource.setText(getSourceFile().getAbsolutePath());
    }

    /**
     * Private Hilfsmethode um zu checken, ob das ausgewählte Verzeichnis gültig(also nicht null) ist
     * @param selectedDirectory
     * @return true(wenn gültig), false(wenn ungültig)
     * !! wirft eine GUI-Fehlermeldung via displayNoPathAssigned()!!
     */
    private boolean checkSelection(File selectedDirectory) {
        boolean returnValue = false;

        if (selectedDirectory == null) {

            displayNoPathAssigned();



        } else {
            System.out.println(selectedDirectory.getAbsolutePath());
            returnValue = true;

        }
        return returnValue;
    }

    private void displayNoPathAssigned() {
        /*Todo:KM Bei gelegenheit einen Ausstiegspunkt aus dem Programm schaffen,
         * eventuell die Error-Message in ein Dialogsystem umbauen */


        System.out.println("Kein Pfad angegeben");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Oh nein!!");
        alert.setHeaderText("Das hat leider nicht funktioniert");
        alert.setContentText("Du hast keinen Pfad angegeben" +
                "Versuchs bitte nochmal");


        alert.showAndWait();

    }


    private File selectSourceDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);

        while (!checkSelection(selectedDirectory)) {
            selectedDirectory = directoryChooser.showDialog(null);
        }

        return selectedDirectory;

    }
















    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public ArrayList<String> getListOfRawFiles() {
        return listOfRawFiles;
    }

    public void setListOfRawFiles(ArrayList<String> listOfRawFiles) {
        this.listOfRawFiles = listOfRawFiles;
    }

    public ArrayList<String> getListOfJpegFiles() {
        return listOfJpegFiles;
    }

    public void setListOfJpegFiles(ArrayList<String> listOfJpegFiles) {
        this.listOfJpegFiles = listOfJpegFiles;
    }

    public String getDirectoryOfSourceFile() {
        return directoryOfSourceFile;
    }

    public void setDirectoryOfSourceFile(String directoryOfSourceFile) {
        this.directoryOfSourceFile = directoryOfSourceFile;
    }

    public String getDirectoryofAcceptedImages() {
        return directoryofAcceptedImages;
    }

    public void setDirectoryofAcceptedImages(String directoryofAcceptedImages) {
        this.directoryofAcceptedImages = directoryofAcceptedImages;
    }

    public String getDirectoryOfDeniedImages() {
        return directoryOfDeniedImages;
    }

    public void setDirectoryOfDeniedImages(String directoryOfDeniedImages) {
        this.directoryOfDeniedImages = directoryOfDeniedImages;
    }
}
