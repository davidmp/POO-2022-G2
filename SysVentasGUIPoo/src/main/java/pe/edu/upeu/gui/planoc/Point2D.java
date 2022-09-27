package pe.edu.upeu.gui.planoc;

public class Point2D {
  private double px;
  private double py;

  public Point2D(double x, double y)
  {
    px = x;
    py = y;
  }

  public Point2D(Point2D point)
  {
    px = point.x();
    py = point.y();
  }

  public void setX(double x) { px = x; }
  public void setY(double y) { py = y; }

  public double x() { return px; }
  public double y() { return py; }

  /**
   * Computes distance between two points, this and point.
   * @param point Point2D object
   * @return double, distance between this and point
   */
  public double distanceTo(Point2D point)
  {
    return Math.sqrt((px - point.x()) * (px - point.x()) +
                     (py - point.y()) * (py - point.y()));
  }

  /**
   *  Returns the distance from origin to this point
   */
  public double distance()
  {
    return Math.sqrt(x() * x() + y() * y());
  }
}

