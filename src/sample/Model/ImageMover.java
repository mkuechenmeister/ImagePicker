package sample.Model;

import javafx.scene.image.Image;

import java.util.ArrayList;

// ist die Context - Klasse
public class ImageMover {

    private verschieben strategy;
    private String image;
    private String current;
    private String goal;
    private String source;
    private String destination;
    private ArrayList<String> listOfRawFIles;




    public ImageMover(String imageWithoutExtension, String currentImage ,ArrayList<String> listOfRawFiles, String source, String destination) {
        this.image = imageWithoutExtension;
        this.current = currentImage;
        this.listOfRawFIles = listOfRawFiles;
        this.source=source;
        this.destination=destination;
        setGoal(image);

    }

    public void setGoal(String image) {
        this.goal = image+".CR2";
    }

    private String getExtension() {
        String temp = image;
        temp = temp.substring(temp.indexOf("."));
        return temp;
    }

    public void setStrategy(){

        System.out.println(goal);

        if (listOfRawFIles.contains(goal)) {
            strategy = new CR2();
        }else{
            //default Strategy
            strategy = new JPG();
        }



    }

    public void moveFile() {

        strategy.execute(image,source,destination);
    }

    /*public verschieben getStrategy(String imagename){
        Extentions ext = null;
        verschieben strategy = new JPEG();
        // default Strategy = JPEG

        if (imagename.toLowerCase().contains(".jpg")) {
            ext = Extentions.JPG;
            strategy = new JPG();
        } else if (imagename.toLowerCase().contains(".cr2")) {
            ext = Extentions.CR2;
            strategy = new CR2();
        }
        return  strategy;
    }*/


}
