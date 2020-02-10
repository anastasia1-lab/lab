import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Polygon {

    @NoArgsConstructor
    @ToString
    @AllArgsConstructor
    public static class Point {
        Once objectV;
        Once objectVn;
        Once objectVt;

        public Point clone() {
            return new Point(objectV.copy(), objectVn.copy(), objectVt.copy());
        }
    }
    Point a;
    Point b;
    Point c;
}
