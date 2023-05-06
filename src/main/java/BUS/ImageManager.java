package BUS;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageManager {

    public ImageManager() {
    }

    public ImageIcon getImage(String name) {
        try {
            String filePath = new File("").getAbsolutePath();
            String pathImage = filePath.concat("\\src\\main\\java\\imageFood\\");
            pathImage = pathImage.concat(name);            
            System.out.println("pathImage: " + pathImage);
            return new ImageIcon(pathImage);
        } catch (Exception e) {
            System.out.println("loi class ImageManger ");
        }
        return null;
    }

    public Icon resizeIcon(ImageIcon source, int width, int height) {
        Image img = source.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

}
