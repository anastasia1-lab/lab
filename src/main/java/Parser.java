import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static Predicate<String> isV = str -> str.startsWith("v");
    private static Predicate<String> isVt = str -> str.startsWith("vt");
    private static Predicate<String> isVn = str -> str.startsWith("vn");
    private static Predicate<String> isF = str -> str.startsWith("f");
    private static Predicate<String> isOnce = str -> isV.test(str) || isVt.test(str) || isVn.test(str);
    @SneakyThrows
    public static Map<Class, List<Once>> onceFromLines(List<String> lines) {
        return lines.stream().map(str -> StringUtils.stripEnd(str, " "))
                .filter(str -> isOnce.test(str))
                .map(Parser::parseOnceFromString)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Once::getClass));
    }

    @SneakyThrows
    public static List<String> getLinesFromFile(String fileName) {
        return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
    }

    public static List<BeforePolygon> beforePolygonsFromLines(List<String> lines) {
        return lines.stream().filter(str -> isF.test(str)).map(str -> Arrays.stream(str.split(" ")).skip(1)
                .map(s -> Arrays.stream(s.split("/")).map(Integer::parseInt).map(i -> i - 1).toArray(Integer[]::new))
                .map(BeforePolygon.BeforePoint::new).toArray(BeforePolygon.BeforePoint[]::new)).map(BeforePolygon::new).collect(Collectors.toList());
    }

    public static List<Polygon> mapToRealPolygons(List<BeforePolygon> beforePolygons, Map<Class, List<Once>> map) {
        return beforePolygons.stream().map(beforePolygon -> new Polygon(new Polygon.Point(map.get(V.class).get(beforePolygon.a.objectV),
                map.get(Vn.class).get(beforePolygon.a.objectVn), map.get(Vt.class).get(beforePolygon.a.objectVt)),
                new Polygon.Point(map.get(V.class).get(beforePolygon.b.objectV), map.get(Vn.class).get(beforePolygon.b.objectVn),
                        map.get(Vt.class).get(beforePolygon.c.objectVt)), new Polygon.Point(map.get(V.class).get(beforePolygon.c.objectV),
                map.get(Vn.class).get(beforePolygon.c.objectVn), map.get(Vt.class).get(beforePolygon.c.objectVt)))).collect(Collectors.toList());
    }


    private static Once parseOnceFromString(final String onceAsString) {
        Double[] values = Stream.of(onceAsString.split(" ")).filter(Parser::isDouble).map(Double::parseDouble).toArray(Double[]::new);
        if (isVt.test(onceAsString)) {
            return new Vt(values);
        }
        if (isVn.test(onceAsString)) {
            return new Vn(values);
        }
        if (isV.test(onceAsString)) {
            return new V(values);
        }
        return null;
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
