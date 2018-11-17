package sample.Model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CR2 implements verschieben {



    @Override
    public void execute(String image, String source, String destination) {

        image = "\\"+image + ".CR2";

        String sourceAsString = source+image;
        String destinationAsString = destination+image;
        File oldDirectory = new File(sourceAsString);
        File newDirectory = new File(destinationAsString);
        oldDirectory.renameTo(newDirectory);

    }
}



        //erstelle die CR2-Datei

        //verschiebe die CR2-Datei

        //entferne den CR2-Titel-String aus dem CR2-Array des File-Workers
        //entferne den JPG-Titel-String aus dem JPG-Array des File Workers

        //entferne den JPG-Titel aus dem JPG-Array des ImageWorkers

        //displayImage() vom Controller




       // myFile.renameTo(new File("/the/new/place/newName.file"));


/*
        File temp = new File(pfad+name);
        temp.renameTo(new File(pfad));
*/

        /*Nimm das CR2 objekt aus dem Array.
        * Verschiebe das CR2 Ob*/


