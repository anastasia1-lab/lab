public class DrawingSkill {
    public static void drawLine(TargetImage image, Polygon.Point start, Polygon.Point finish) {
        double x1 = start.objectV.getX();
        double x2 = finish.objectV.getX();
        double y1 = start.objectV.getY();
        double y2 = finish.objectV.getY();
        drawLineInternal(image, x1, y1, x2, y2);
    }

    //TODO нужно реализовать алгоритм рисовалки линии
    /**
     * @see TargetImage#drawOnePoint(double, double) используй этот метод для рисования точки
     */
    private static void drawLineInternal(TargetImage image, double x1, double y1, double x2, double y2) {

    }

    /** TODO нужно вытащить точки из полигонов и заюзать следующий метод
     * TODO будет 3 линии (a,b) (b,c) (c,a)
     * @see DrawingSkill#drawLine
     */
    public static void drawPolygonOnImage(TargetImage image, Polygon polygon) {
        // я уже написал за тебя осталось только drawLineInternal написать, самое сложное
        drawLine(image, polygon.a, polygon.b);
        drawLine(image, polygon.b, polygon.c);
        drawLine(image, polygon.c, polygon.a);
    }
}
