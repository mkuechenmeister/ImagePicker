package sample.Model;

import javafx.event.ActionEvent;
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

    public void chooseSourceFile(ActionEvent actionEvent, Label labelSource) {
        setSourceFile(selectSourceDirectory());
        labelSource.setText(getSourceFile().getAbsolutePath());
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
