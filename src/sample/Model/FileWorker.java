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
    private String nameOfDeniedFolder;
    private String nameOfAcceptedFolder;

    public FileWorker() {
        this.sourceFile = null;
        this.listOfRawFiles = new ArrayList<>();
        this.listOfJpegFiles = new ArrayList<>();
        this.directoryOfSourceFile = null;
        this.directoryofAcceptedImages = null;
        this.directoryOfDeniedImages = null;
        this.nameOfAcceptedFolder = "Vielleicht";
        this.nameOfDeniedFolder = "LieberNicht";
    }

//Step 1 auswahl des Quellordners und umlabeln des GUI-Labels


    /**
     * Methode zum auswählen des Quellordners in dem sich die Bilder befinden
     *
     * @param actionEvent
     * @param labelSource
     */
    public void chooseSourceFile(ActionEvent actionEvent, Label labelSource) {
        setSourceFile(selectSourceDirectory());
        labelSource.setText(getSourceFile().getAbsolutePath());
    }

    public void chooseDirectoryOfJa(ActionEvent actionEvent, Label labelJa) {

        final File ja = selectSourceDirectory();
        setDirectoryofAcceptedImages(ja.getAbsolutePath());
        labelJa.setText(getDirectoryofAcceptedImages());


    }

    public void chooseDirectoryOfNein(ActionEvent actionEvent, Label labelNein) {
        final File nein = selectSourceDirectory();
        setDirectoryOfDeniedImages(nein.getAbsolutePath());
        labelNein.setText(getDirectoryOfDeniedImages());

    }

    public void createArrayLists() {

        String[] list = getSourceFile().list();
        for (String s : list
        ) {
            if (s.toLowerCase().contains(".cr2")) {
                listOfRawFiles.add(s);
            }

            if (s.toLowerCase().contains(".jpeg") || s.toLowerCase().contains(".jpg")) {
                listOfJpegFiles.add(s);
            }


        }
    }

    public void startUp(Label label) {
        //if it is checked
        if (sourceFile != null && directoryOfDeniedImages != null && directoryofAcceptedImages != null) {
            if (listOfJpegFiles.size() == 0) {
                createArrayLists();
            }else {
                System.out.println("Fehler beim erstellen der ArrayList");
            }
            createAcceptedImageFolder();
            createDeniedImageFolder();
            changeLabelInQue(label);        } else {
            displayNoPathAssigned();
        }


    }

    public void createAcceptedImageFolder(){
        if (!createFolder(getDirectoryofAcceptedImages())) {
            throwErrorUnableToCreate(getNameOfAcceptedFolder());
        }
    }
    public void createDeniedImageFolder(){
        if (!createFolder(getDirectoryOfDeniedImages())) {
            throwErrorUnableToCreate(getNameOfDeniedFolder());
        }
    }

    private void changeLabelInQue(Label label) {
        label.setText("Es sind "+listOfJpegFiles.size()+" Bilder im Quellordner");
    }

    private boolean createFolder(String path){

        boolean temp = new File(path).mkdirs();
        return temp;

    }


    /**
     * Private Hilfsmethode um zu checken, ob das ausgewählte Verzeichnis gültig(also nicht null) ist
     *
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


    private String getDirectoryofAcceptedImages() {
        return directoryofAcceptedImages;
    }

    private void setDirectoryofAcceptedImages(String directoryofAcceptedImages) {

        this.directoryofAcceptedImages = directoryofAcceptedImages + "\\"+getNameOfAcceptedFolder();
    }

    public String getDirectoryOfDeniedImages() {
        return directoryOfDeniedImages;
    }

    private void setDirectoryOfDeniedImages(String directoryOfDeniedImages) {
        this.directoryOfDeniedImages = directoryOfDeniedImages + "\\"+getNameOfDeniedFolder();
    }

    public String getDirectoryOfSourceFile() {
        return directoryOfSourceFile;
    }

    public void setDirectoryOfSourceFile(String directoryOfSourceFile) {
        this.directoryOfSourceFile = directoryOfSourceFile;
    }

    public void imageAccepted(ActionEvent actionEvent) {
        System.out.println("Jep");
        //System.out.println(mm.getListSize());
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

    public String getNameOfDeniedFolder() {
        return nameOfDeniedFolder;
    }

    public void setNameOfDeniedFolder(String nameOfDeniedFolder) {
        this.nameOfDeniedFolder = nameOfDeniedFolder;
    }

    public String getNameOfAcceptedFolder() {
        return nameOfAcceptedFolder;
    }

    private void throwErrorUnableToCreate(String name) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Oh nein!!");
        alert.setHeaderText("Fehler beim erstellen des "+name+" Ordners");
        alert.setContentText("Wahrscheinlich gibt es den Zielordner bereits");

        alert.showAndWait();

    }


    public void setNameOfAcceptedFolder(String nameOfAcceptedFolder) {
        this.nameOfAcceptedFolder = nameOfAcceptedFolder;
    }
}


