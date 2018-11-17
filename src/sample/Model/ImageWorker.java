package sample.Model;

import javafx.scene.control.Label;
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

    public String getCurrentImageWithoutExtension() {
        String temp = getCurrentImage();
        return temp = temp.substring(0,temp.indexOf("."));

    }

    public void displayPreview(ImageView c1, ImageView c2, ImageView c3){

        c1.setImage(getPreview(1));
        c2.setImage(getPreview(2));
        c3.setImage(getPreview(3));

        c1.setFitHeight(200);
        c1.setFitWidth(250);
        c1.setPreserveRatio(true);

        c2.setFitHeight(200);
        c2.setFitWidth(250);
        c2.setPreserveRatio(true);

        c3.setFitHeight(200);
        c3.setFitWidth(250);
        c3.setPreserveRatio(true);


    }

    private Image getPreview(int i) {
        Image out = null;
        String fullPath;


        if (listOfImages.size() > i) {

            fullPath = sourceFile.toURI().toString();
            fullPath += listOfImages.get(i);


        } else {

            switch (i) {
                case 1:
                    fullPath = "sample/img/fastFertig.jpg";
                    break;
                case 2:
                    fullPath = "sample/img/1left.jpg";
                    break;
                case 3:
                    fullPath = "sample/img/2left.jpg";
                    break;
                default:
                    fullPath = "sample/img/oops.jpg";
                    break;


            }

        }
        out = new Image(fullPath);
        return out;
    }


        public Image removeCurrentAndGetNext(){
            listOfImages.remove(0);
            return getMainImage();
        }


        public Image getMainImage(){
            String cImage = getCurrentImage();

            if (cImage != null) {

                String fullPath = sourceFile.toURI().toString();
                fullPath += getCurrentImage();

                Image img = new Image(fullPath);

                // System.out.println(fullPath);

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

        public void reLabelQue(Label lblPicsInQue){
            int i = listOfImages.size();
            String output;
            if (i > 0) {

                output = "Es sind noch " + i + " entscheidungen zu treffen.";
            } else {
                output = "Du bist mit deinen Bildern durch";
            }
            lblPicsInQue.setText(output);
        }



        private void displayEndOfListMessage() {

            System.out.println("Du bist mit den Bildern durch");
        }





    }
