package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import sample.Model.FileWorker;
import sample.Model.ImageMover;
import sample.Model.ImageWorker;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerV2 implements Initializable {

    @FXML
    public Button btnNext;
    public Button btnJa;
    public Button btnNein;
    public ImageView subCanvas1;
    public ImageView subCanvas3;
    public ImageView subCanvas2;
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




    private ImageWorker iw;
    private FileWorker fw;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayImage(new Image("sample/img/YodaStart.jpg"));



    }

    public ControllerV2() {

        //Todo KM: hinterfrage mal wie das Gemacht wird
        //Keine Ahnung ob hier mit dem Konstruktor gearbeitet werden sollte, oder ob es nicht doch besser wäre es mit der
        //initializer-Methode zu machen

        //Erfrage deun Best-Practise zugang

        this.fw = new FileWorker();
        this.iw = new ImageWorker();
    }

    /**
     * Buttonklick zur auswahl des Sourcefolders
     * @param actionEvent
     */
    public void chooseSourceFile(ActionEvent actionEvent) {
        fw.chooseSourceFile(actionEvent,labelSource);
    }

    /**
     * Buttonklick zur Auswahl des Accepted-Image-Folders
     * @param actionEvent
     */
    public void chooseDirectoryOfJa(ActionEvent actionEvent) {
        fw.chooseDirectoryOfJa(actionEvent,labelJa);
    }

    /**
     * Buttonklick zur Auswahl des Denied-Image-Folders
     * @param actionEvent
     */
    public void chooseDirectoryOfNein(ActionEvent actionEvent) {
        fw.chooseDirectoryOfNein(actionEvent,labelNein);
    }

    public void imageAccepted(ActionEvent actionEvent) {

        if (iw.getMainImage()!=null) {
            String currentImageWithoutExtension = iw.getCurrentImageWithoutExtension();
            String currentImage = iw.getCurrentImage();
            ArrayList<String> listOfRawFiles = fw.getListOfRawFiles();
            String directoryOfSourceFile = fw.getDirectoryOfSourceFile();
            String directoryOfAccepted = fw.getDirectoryofAcceptedImages();
            ImageMover im = new ImageMover(currentImageWithoutExtension, currentImage, listOfRawFiles, directoryOfSourceFile, directoryOfAccepted);
            im.setStrategy();
            im.moveFile();
            displayImage(iw.removeCurrentAndGetNext());
            iw.displayPreview(subCanvas1,subCanvas2,subCanvas3);
            iw.reLabelQue(lblPicsInQue);

        }
    }




    public void startMeUp(ActionEvent actionEvent) {

        fw.startUp(lblPicsInQue);
        iw.setListOfImages(fw.getListOfJpegFiles());
        iw.setSourceFile(fw.getSourceFile());
        Image mainImage = iw.getMainImage();
        displayImage(mainImage);
        iw.displayPreview(subCanvas1,subCanvas2,subCanvas3);

       /* setDirectoryofAcceptedImages(directoryofAcceptedImages);
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
        }*/
        // mm = new MemmoryModule(listOfJpegFiles);
        //War ein anderer Lösungsansatz zur lösung meines GUI-Problemes

        //initializeImageViewer();

        //showJaNeinView(actionEvent);



    }




    private void displayImage(Image img){

        if (img != null) {

            canvas.setImage(img);
        } else {
            canvas.setImage(new Image("sample/img/YodaEnd.jpg"));
        }
        canvas.setFitHeight(800);
        canvas.setFitWidth(1000);
        canvas.setPreserveRatio(true);

        /*Image tempimg = iw.getMainImage();
        canvas.setImage(tempimg);*/


    }
    public void jaKeyPressed(InputMethodEvent inputMethodEvent) {

    }

    public void imageDeclined(ActionEvent actionEvent) {
        if (iw.getMainImage()!=null) {
            String currentImageWithoutExtension = iw.getCurrentImageWithoutExtension();
            String currentImage = iw.getCurrentImage();
            ArrayList<String> listOfRawFiles = fw.getListOfRawFiles();
            String directoryOfSourceFile = fw.getDirectoryOfSourceFile();
            String directoryOfAccepted = fw.getDirectoryOfDeniedImages();
            ImageMover im = new ImageMover(currentImageWithoutExtension, currentImage, listOfRawFiles, directoryOfSourceFile, directoryOfAccepted);
            im.setStrategy();
            im.moveFile();
            displayImage(iw.removeCurrentAndGetNext());
            iw.displayPreview(subCanvas1,subCanvas2,subCanvas3);
            iw.reLabelQue(lblPicsInQue);

        }
    }

    public void neinKeyPressed(KeyEvent keyEvent) {
    }

    public void skipCurrentImage(ActionEvent actionEvent)
    {
        displayImage(iw.getNextMain());
        iw.displayPreview(subCanvas1,subCanvas2,subCanvas3);
    }

    public void nextOnKeyPressed(KeyEvent keyEvent) {




    }

}
