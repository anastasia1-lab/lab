import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class V implements Once {

    double x;
    double y;
    double z;

    public V(Double[] values) {
        x = values[0];
        y = values[1];
        z = values[2];
    }

    @Override
    public Once copy() {
        return new V(x, y, z);
    }
}
