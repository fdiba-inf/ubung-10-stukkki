package exercise10;

public class Ellipse extends Figure {
    public Ellipse() {
        super(new Point(0, 0), 1, 1);
    }

    public Ellipse(Point startPoint, double a, double b) {
        super(startPoint, a, b);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(otherEllipse.startPoint, otherEllipse.side1, otherEllipse.side2);
    }

    public double calculatePerimeter() {
        return Math.PI * (3.0 * (this.side1 + this.side2) - Math.sqrt((3.0 * this.side1 + this.side2) * (this.side1 + 3.0 * this.side2)));
    }

    public double calculateArea() {
        return Math.PI * this.side1 * this.side2;
    }

    public String getType() {
        return (this.side1 == this.side2) ? "Circle" : "Ellipse";
    }

    @Override
    public boolean equal(Figure otherFigure) {
        boolean sameA = Utils.equals(this.side1, otherFigure.side1);
        boolean sameB = Utils.equals(this.side2, otherFigure.side2);
        boolean sameAReversed = Utils.equals(this.side1, otherFigure.side2);
        boolean sameBReversed = Utils.equals(this.side2, otherFigure.side1);

        return (sameA && sameB) || (sameAReversed && sameBReversed);
    }

    public boolean containsClick(Point click) {
        // Check if click point is inside the ellipse
        Point center = new Point((this.side1 / 2), (this.side2 / 2));

        return (Math.pow(2, (click.getX() - center.getX()))) / (Math.pow(2, this.side1)) + (Math.pow(2, (click.getY() - center.getY()))) / (Math.pow(2, this.side2)) <= 1;
    }
}
