import org.junit.Test;

import java.util.List;

public class ParserTest {
    @Test
    public void parser() {
        String fileName = "src/main/resources/african_head.obj";
        List<Polygon> polygons = Parser.parse(fileName);
        polygons.forEach(System.out::println);
    }
}
