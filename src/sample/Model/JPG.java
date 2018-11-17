package sample.Model;

import java.io.File;

public class JPG implements verschieben {

    @Override
    public void execute(String image, String source, String destination) {

        image = image + ".jpg";

        String sourceAsString = source+image;
        String destinationAsString = destination+image;
        System.out.println("Source: "+sourceAsString);
        System.out.println("Destination: "+destinationAsString);
        File raw = new File(sourceAsString);

    }
}
