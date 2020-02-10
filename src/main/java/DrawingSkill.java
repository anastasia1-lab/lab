import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

public class DrawingSkill {
    private static Function<Double, Integer> defaultXHandler = x -> (int) (200 * x + 256);
    private static Function<Double, Integer> defaultYHandler = y -> (int) (-200*y +256);

    public static BufferedImage emptyImage() {
        BufferedImage image = new BufferedImage(512,512,BufferedImage.TYPE_INT_RGB);
        Color color = new Color(255,255,255);
        for (int i = 0; i < 512; i++) {
            for (int j = 0; j < 512; j++) {
                image.setRGB(i,j,color.getRGB());
            }
        }
        return image;
    }

    public static void drawPolygonOnImage(Polygon polygon, BufferedImage image) {

    }
}
