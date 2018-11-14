package sample.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class ImageWorker {

    ArrayList<String> listOfImages;
    File sourceFile;


    public ImageWorker() {
        listOfImages = new ArrayList<>();
        sourceFile = null;

    }

    public void setListOfImages(ArrayList<String> listOfImages) {
        this.listOfImages = listOfImages;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public ArrayList<String> getListOfImages() {
        return listOfImages;
    }

    public String getCurrentImage(){
        int size = listOfImages.size();
        if(size > 0 ){
            return listOfImages.get(0);
        }
        return null;
    }

    private void removeCurrentImageFromList(ArrayList<String> list){
        list.remove(0);
    }


    public Image getMainImage(){
        String cImage = getCurrentImage();

        if (cImage != null) {

        String fullPath = sourceFile.toURI().toString();
        fullPath += getCurrentImage();

        Image img = new Image(fullPath);

        System.out.println(fullPath);

        /*ImageView imageView = new ImageView(img);
        imageView.setFitHeight(700);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);*/
        return img;
        }else return null;
    }

    public Image getNextMain() {
        skipImage();
        return getMainImage();
    }

    private void skipImage(){
        if(listOfImages.size() > 1) {
            String temp = listOfImages.get(0);
            listOfImages.remove(0);
            listOfImages.add(temp);
        } else{
            displayEndOfListMessage();
        }

    }

    private void displayEndOfListMessage() {

        System.out.println("Du bist mit den Bildern durch");
    }





}
