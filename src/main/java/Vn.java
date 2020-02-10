import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vn implements Once {
    double x;
    double y;
    double z;

    public Vn(Double[] values) {
        x = values[0];
        y = values[1];
        z = values[2];
    }

    @Override
    public Once copy()
    {
        return new Vn(x, y, z);
    }
}
