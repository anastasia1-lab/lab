import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vt implements Once {
    double x;
    double y;
    double z;

    public Vt(Double[] values) {
        x = values[0];
        y = values[1];
        z = values[2];
    }

    @Override
    public Once copy()
    {
        return new Vt(x, y, z);
    }
}
