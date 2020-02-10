import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ParserTest {
    @Test
    public void parser() {
        List<String> linesFromFile = Parser.getLinesFromFile("src/main/resources/african_head.obj");
        Map<Class, List<Once>> classOnceMap = Parser.onceFromLines(linesFromFile);
        List<BeforePolygon> beforePolygons = Parser.beforePolygonsFromLines(linesFromFile);
        List<Polygon> polygons = Parser.mapToRealPolygons(beforePolygons, classOnceMap);
    }
}
