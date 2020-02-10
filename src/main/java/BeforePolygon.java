import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
public class BeforePolygon {

    public BeforePolygon(BeforePoint[] beforePoints) {
        a = beforePoints[0];
        b = beforePoints[1];
        c = beforePoints[2];
    }

    @NoArgsConstructor
    @ToString
    @AllArgsConstructor
    public static class BeforePoint {
        Integer objectV;
        Integer objectVn;
        Integer objectVt;

        public BeforePoint(Integer[] values) {
            objectV = values[0];
            objectVt = values[1];
            objectVn = values[2];
        }
    }
    BeforePoint a;
    BeforePoint b;
    BeforePoint c;
}
