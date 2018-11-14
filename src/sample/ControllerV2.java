package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.Model.ImageViewer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerV2 implements Initializable {

    @FXML
    public Button btnNext;
    public Button btnJa;
    public Button btnNein;
    @FXML
    private Label lblPicsInQue;
    @FXML
    private ImageView canvas;
    @FXML
    private Label labelSource;
    @FXML
    private Label labelJa;
    @FXML
    private Label labelNein;


    //private MemmoryModule mm;

    //private FileWorker fp;

    private ImageViewer iv;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*this.listOfRawFiles = new ArrayList<>();
        this.listOfJpegFiles = new ArrayList<>();
        this.sourceFile = new File("null");
        this.directoryofAcceptedImages = null;
        this.directoryOfDeniedImages = null;*/

    }

    public ControllerV2() {

        //Todo KM: hinterfrage mal wie das Gemacht wird
        //Keine Ahnung ob hier mit dem Konstruktor gearbeitet werden sollte, oder ob es nicht doch besser wäre es mit der
        //initialiser-Methode zu machen

        //Erfrage deun Best-Practise zugang

        this.listOfRawFiles = new ArrayList<>();
        this.listOfJpegFiles = new ArrayList<>();
        this.sourceFile = new File("null");
        this.directoryofAcceptedImages = null;
        this.directoryOfDeniedImages = null;
        this.iv = new ImageViewer(null, null);
        //this.mm = new MemmoryModule(null);
    }

    public void chooseSourceFile(ActionEvent actionEvent) {
        this.sourceFile = selectSourceDirectory();
        setSourceFile(sourceFile);
        labelSource.setText(sourceFile.getAbsolutePath());
    }


    public void startMeUp(ActionEvent actionEvent) {
        setDirectoryofAcceptedImages(directoryofAcceptedImages);
        setDirectoryOfDeniedImages(directoryOfDeniedImages);
        boolean successJa = new File(getDirectoryofAcceptedImages()).mkdirs();//Create Ja
        boolean successNein = new File(getDirectoryOfDeniedImages()).mkdirs();//Create Nein

        if ((!successJa) || (!successNein)) {
            throwErrorUnableToCreate();
            Platform.exit();
            //todo KM: hier muss in einer ruhigen Minute eine schönere Lösung her  (IfExist...)


        }else {
            createArrayLists(sourceFile);
            displayImage();
        }
       // mm = new MemmoryModule(listOfJpegFiles);
        //War ein anderer Lösungsansatz zur lösung meines GUI-Problemes

        //initializeImageViewer();

        //showJaNeinView(actionEvent);



    }

    private void initializeImageViewer() {
        this.iv = new ImageViewer(this.listOfJpegFiles, this.directoryOfSourceFile);
        //wieder ein anderer lösungsansatz für meinn GUI-Problem
    }

    private void displayImage(){
        File file = new File("C:\\IntelliJProjekte\\ImagePicker\\src\\sample\\_MG_7434_SophieAugen.jpg");

        Image tempimg = new Image(file.toURI().toString());
        canvas.setImage(tempimg);

        /*Image tempimg = iv.getMainImage();
        canvas.setImage(tempimg);*/


    }





    private void createArrayLists(File file) {

        file.listFiles();
        String[] list = file.list();
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


    private void throwErrorUnableToCreate() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Oh nein!!");
        alert.setHeaderText("Fehler beim erstellen der Ordner");
        alert.setContentText("Wahrscheinlich gibt es mindestens einen der Zielordner bereits");

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


    public void chooseDirectoryOfJa(ActionEvent actionEvent) {

        final File ja = selectSourceDirectory();
        directoryofAcceptedImages = ja.getAbsolutePath();
        labelJa.setText(getDirectoryofAcceptedImages());



    }


    public void chooseDirectoryOfNein(ActionEvent actionEvent) {
        final File nein = selectSourceDirectory();
        directoryOfDeniedImages = nein.getAbsolutePath();
        //setDirectoryOfSourceFile(nein.getAbsolutePath());
        labelNein.setText(getDirectoryOfDeniedImages());

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

    public File getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getDirectoryofAcceptedImages() {
        return directoryofAcceptedImages;
    }

    private void setDirectoryofAcceptedImages(String directoryofAcceptedImages) {

        this.directoryofAcceptedImages = directoryofAcceptedImages +"\\ja";
    }

    public String getDirectoryOfDeniedImages() {
        return directoryOfDeniedImages;
    }

    private void setDirectoryOfDeniedImages(String directoryOfDeniedImages) {
        this.directoryOfDeniedImages = directoryOfDeniedImages +"\\nein";
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

    public void jaKeyPressed(InputMethodEvent inputMethodEvent) {
    }

    public void imageDeclined(ActionEvent actionEvent) {
        int size = listOfJpegFiles.size();
        System.out.printf("Die filegröße beträgt %d ",size);
        System.out.println(directoryOfSourceFile);
    }

    public void neinKeyPressed(KeyEvent keyEvent) {
    }

    public void skipCurrentImage(ActionEvent actionEvent)
    {
        displayImage();
        System.out.println("Didit");
    }

    public void nextOnKeyPressed(KeyEvent keyEvent) {




    }

}
