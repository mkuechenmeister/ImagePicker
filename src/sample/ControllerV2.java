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
import sample.Model.ImageViewer;
import java.io.File;
import java.net.URL;
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




    private ImageViewer iv;
    private FileWorker fw;


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

        this.fw = new FileWorker();
        this.iv = new ImageViewer(null, null);
    }

    public void chooseSourceFile(ActionEvent actionEvent) {
        fw.chooseSourceFile(actionEvent,labelSource);
    }

    public void chooseDirectoryOfJa(ActionEvent actionEvent) {
        fw.chooseDirectoryOfJa(actionEvent,labelJa);
    }

    public void chooseDirectoryOfNein(ActionEvent actionEvent) {
        fw.chooseDirectoryOfNein(actionEvent,labelNein);
    }

    public void imageAccepted(ActionEvent actionEvent) {
    }




    public void startMeUp(ActionEvent actionEvent) {
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


    private void displayImage(){
        File file = new File("C:\\IntelliJProjekte\\ImagePicker\\src\\sample\\_MG_7434_SophieAugen.jpg");

        Image tempimg = new Image(file.toURI().toString());
        canvas.setImage(tempimg);

        /*Image tempimg = iv.getMainImage();
        canvas.setImage(tempimg);*/


    }
    public void jaKeyPressed(InputMethodEvent inputMethodEvent) {
    }

    public void imageDeclined(ActionEvent actionEvent) {
        /*int size = listOfJpegFiles.size();
        System.out.printf("Die filegröße beträgt %d ",size);
        System.out.println(directoryOfSourceFile);*/
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
