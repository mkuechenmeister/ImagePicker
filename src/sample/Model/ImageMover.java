package sample.Model;

// ist die Context - Klasse
public class ImageMover {

    private verschieben strategy;
    private String imagename;


    public ImageMover(String imagename) {
        this.imagename = imagename;

    }

    private String getExtension() {
        String temp = imagename.substring(0, imagename.lastIndexOf('.')).toLowerCase();
        return temp;
    }

    public verschieben getStrategy(String imagename){
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
    }


}
