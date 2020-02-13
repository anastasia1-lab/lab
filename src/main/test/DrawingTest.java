import org.junit.Test;

import java.util.List;

public class DrawingTest {
    @Test
    public void test() {
        // пустая белая картинка 512 на 512 создалась
        TargetImage image = new TargetImage();
        // допустим ниже ты спарсила все полигоны
        String fileName = "src/main/resources/african_head.obj";
        List<Polygon> polygons = Parser.parse(fileName);
        //погнали рисовать
        polygons.forEach(polygon -> DrawingSkill.drawPolygonOnImage(image, polygon));
        // это бы нарисовалось если бы был реализован метод drawLineInternal в DrawingSkill (
        // но сохраняем пустое изображение
        image.saveImage("писюлька.png");
    }
}
