package sample.Model;

public class ExtentionChecker {

    public ExtentionChecker(String file) {
    }

    public verschieben getStrategy(String file){
        Extentions ext = null;
        verschieben strategy = new JPEG();
        // default Strategy = JPEG

        if (file.toLowerCase().contains(".jpg")) {
            ext = Extentions.JPG;
            strategy = new JPG();
        } else if (file.toLowerCase().contains(".cr2")) {
            ext = Extentions.CR2;
            strategy = new CR2();
        }
        return  strategy;
    }


}
