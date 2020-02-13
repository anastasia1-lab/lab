import lombok.Setter;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.function.Function;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class TargetImage {
    private BufferedImage image;
    private int SIZE;
    @Setter private Function<Double, Integer> xHandler = x -> (int) (200 * x + 256);
    @Setter private Function<Double, Integer> yHandler = y -> (int) (-200 * y + 256);
    private int blackColorRGB = new Color(0, 0, 0).getRGB();

    public TargetImage() {
        this.SIZE = 512;
        this.image = new BufferedImage(SIZE, SIZE, TYPE_INT_RGB);
        emptyWhiteImage();
    }
    public TargetImage(int size) {
        this.SIZE = size;
        this.image = new BufferedImage(SIZE, SIZE, TYPE_INT_RGB);
        emptyWhiteImage();
    }

    private void emptyWhiteImage() {
        Color color = new Color(255,255,255);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                image.setRGB(i,j,color.getRGB());
            }
        }
    }

    public void drawOnePoint(double x, double y) {
        int x1 = xHandler.apply(x);
        int y1 = yHandler.apply(y);
        image.setRGB(x1, y1, blackColorRGB);
    }

    @SneakyThrows
    public void saveImage(String fileName) {
        ImageIO.write(image, "png", new File(fileName));
    }
}
