package sample.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class ImageViewer {

    ArrayList<String> listOfImages;
    String sourcePath;

    public ImageViewer(ArrayList<String> listOfImages, String sourePath) {
        this.listOfImages = listOfImages;
        this.sourcePath = sourePath;
    }

    public int getRemainingAmountOfImages(){
        return listOfImages.size();
    }

    public String getCurrentImage(){
        int size = listOfImages.size();
        if(size > 0 ){
            return listOfImages.get(0);
        }
        return null;
    }

    private void removeCurrentImageFromList(){
        listOfImages.remove(0);
    }


    public Image getMainImage(){
        String cImage = getCurrentImage();

        if (cImage != null) {

        String fullPath = getSourcePath();
        fullPath += getCurrentImage();

        File tFile = new File(fullPath);
        Image img = new Image(tFile.toURI().toString());

        System.out.println(fullPath);

        /*ImageView imageView = new ImageView(img);
        imageView.setFitHeight(700);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);*/
        return img;
        }else return null;
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


    public String getSourcePath() {
        return sourcePath;
    }
    //todo KM: add previewImages for display(3 if array has 3)


}
