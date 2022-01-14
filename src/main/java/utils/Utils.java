package utils;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Utils {

    public static String outNameFromFileName(String fileName) {
        String total = fileName.replaceAll("src/main/resources", "src/main/out");
        String[] splitted = total.split("/");
        StringBuilder directoryName = new StringBuilder();
        for (int i = 0; i < splitted.length - 1; i++) {
            directoryName.append(splitted[i]).append("/");
        }
        try {
            Files.createDirectories(Paths.get(directoryName.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total.split("\\.")[0] + ".dot";
    }

    public static String formatColor(Color color){
        return String.format("#%02x%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public static Color createRandomColor(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b, 0.5f);
    }

}
