package sample.Model;

import java.io.File;

public class CR2 implements verschieben {
    @Override
    public void doIt(String datei, String pfad) {

       // myFile.renameTo(new File("/the/new/place/newName.file"));
        File temp = new File(datei);
        temp.renameTo(new File(pfad));

    }
}
