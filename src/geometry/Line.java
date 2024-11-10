//207829763 Matan Jack
package geometry;
import methods.Methods;
/**
 * This class represents a two-dimensional line segment in space.
 * A line segment is defined by its starting and ending points.
 *
 * @author Matan Jack
 * @version 2
 * @since 2024-06-04
 */
public class Line {
    // Filed
    private final Point start;
    private final Point end;

    /**
     * Constructs a new line segment with the given starting and ending points.
     *
     * @param start The starting point of the line segment.
     * @param end   The ending point of the line segment.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructs a new line segment with the given coordinates for the starting and ending points.
     *
     * @param x1 The x coordinate of the starting point.
     * @param y1 The y coordinate of the starting point.
     * @param x2 The x coordinate of the ending point.
     * @param y2 The y coordinate of the ending point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    // methods.Methods
//Method 'start' is not used yet

    /**
     * Returns the starting point of the line segment.
     *
     * @return The starting point of the line segment.
     */
    public Point start() {
        return start;
    }
    //Method 'end' is not used
//    /**
//     * Returns the ending point of the line segment.
//     *
//     * @return The ending point of the line segment.
//     */
//    public geometry.Point end() {
//        return end;
//    }
    //Method 'setStart' is not used yet
//    /**
//     * Sets the starting point of the line segment.
//     *
//     * @param start The new starting point of the line segment.
//     */
//    public void setStart(geometry.Point start) {
//        this.start = start;
//    }
    //Method 'setEnd' is not used yet
//    /**
//     * Sets the ending point of the line segment.
//     *
//     * @param end The new ending point of the line segment.
//     */
//    public void setEnd(geometry.Point end) {
//        this.end = end;
//    }
    //Method 'length' is not used
//    /**
//     * Calculates the length of the line segment.
//     * Uses the distance method of the `geometry.Point` class to calculate the
//     distance between the starting and ending points.
//     *
//     * @return The length of the line segment.
//     */
//    public double length() {
//        return this.start.distance(this.end);
//    }
    //Method 'middle' is not used
//    /**
//     * Calculates the middle point of the line segment.
//     *
//     * @return The middle point of the line segment.
//     */
//    public geometry.Point middle() {
//        geometry.Point mid = new geometry.Point(0, 0);
//        //According to the formula for finding the middle of a segment
//        mid.setX((this.start.getX() + this.end.getX()) / 2);
//        mid.setY((this.start.getY() + this.end.getY()) / 2);
//        return mid;
//    }

    /**
     * Calculates the incline of the line segment (considering positive infinity for vertical lines).
     * This method is private because it's used internally by other methods in the class.
     *
     * @return The incline of the line segment, or Double.POSITIVE_INFINITY for vertical lines.
     */
    private double incline() {
        double incline;
        //Use of threshold to compare doubles.
        if (Methods.areDoublesEqual(this.end.getX(), this.start.getX())) {
            //If the 2 coordinates of X are equal the slope cannot be calculated according to the formula
            // The slope will be infinite
            incline = Double.POSITIVE_INFINITY;
            return incline;
        }
        //According to the formula for finding incline.
        incline = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        return incline;
    }

    /**
     * Checks if this line segment intersects a line that has a positive infinity incline.
     * This method is private because it's used internally by the `isIntersecting` method.
     *
     * @param other The other line segment to check for intersection with.
     * @return The intersection point if the lines intersect at line with infinity incline, null otherwise.
     */
    private Point infinityMeet(Line other) {
        double incline = other.incline();
        double b = other.start.getY() - (other.incline() * other.start.getX());
        double interY = (incline * this.start.getX() + b);
        //If one segment has an infinite incline, check if the other segment intersects it
        Point p = new Point(this.start.getX(), interY);
        if (this.isOnLineSegment(p, other)) {
            return p;
        }
        return null;
    }

    /**
     * Calculates the intersection point of two lines segments with the same inclines (if they are not overlapping).
     *
     * @param other The other line segment to check for intersecting point.
     * @return The intersecting point if the lines intersect, null otherwise (or in a case of overlap).
     */
    private Point meetAtTheEnds(Line other) {
        //It is not possible to calculate a constant with an infinite incline, so we will divide into cases
        if (!(Methods.areDoublesEqual(this.end.getX(), this.start.getX())
                && (Methods.areDoublesEqual(other.end.getX(), other.start.getX())))) {
            double b1 = this.start.getY() - this.incline() * this.start.getX();
            double b2 = other.start.getY() - other.incline() * other.start.getX();
            /*
            If there is 2 converging straight lines, we want to check if the segments intersect 1 time
            (it can be only at the ends of the segments).
             */
            if (Methods.areDoublesEqual(b1, b2) && Methods.areDoublesEqual(this.incline(), other.incline())) {
                if (this.start.equals(other.start)) {
                    if (!this.infinity(other)) {
                        return this.start;
                    }
                }
                if (this.end.equals(other.end)) {
                    if (!this.infinity(other)) {
                        return this.end;
                    }
                }
                if (this.start.equals(other.end)) {
                    if (!this.infinity(other)) {
                        return this.start;
                    }
                }
                if (this.end.equals(other.start)) {
                    if (!this.infinity(other)) {
                        return this.end;
                    }
                }
            }
        }
        /*
        If there is 2 straight lines with an infinite incline when they have the same X coordinate
        we want to check if the segments intersect 1 time (it can be only at the ends of the segments).
         */
        if ((Methods.areDoublesEqual(this.start.getX(), this.end.getX())
                && Methods.areDoublesEqual(other.start.getX(), other.end.getX())
                && Methods.areDoublesEqual(this.start.getX(), other.start.getX()))) {
            if (this.start.equals(other.start)) {
                if (!this.infinity(other)) {
                    return this.start;
                }
            }
            if (this.end.equals(other.end)) {
                if (!this.infinity(other)) {
                    return this.end;
                }
            }
            if (this.start.equals(other.end)) {
                if (!this.infinity(other)) {
                    return this.start;
                }
            }
            if (this.end.equals(other.start)) {
                if (!this.infinity(other)) {
                    return this.end;
                }
            }
        }
        return null;
    }

    /**
     * Checks if two line segments intersect infinitely (intersect in more then 1 point).
     *
     * @param other The other line segment to check for infinity intersection with.
     * @return True if the lines intersect infinitely, false otherwise.
     */
    private boolean infinity(Line other) {
        /*
        If there is 2 straight lines with an infinite incline when they have the same X coordinate
        we want to check if the segments intersect at more than 1 point
        at the range of the start and end points of each segment (in this case, we need to check only the Y).
         */
        if ((Methods.areDoublesEqual(this.start.getX(), this.end.getX())
                && Methods.areDoublesEqual(other.start.getX(), other.end.getX())
                && Methods.areDoublesEqual(this.start.getX(), other.start.getX()))) {
            if ((Math.max(this.start.getY(), this.end.getY()) > other.start.getY())
                    && Math.min(this.start.getY(), this.end.getY()) < other.start.getY()) {
                return true;
            }
            if ((Math.max(this.start.getY(), this.end.getY()) > other.end.getY())
                    && Math.min(this.start.getY(), this.end.getY()) < other.end.getY()) {
                return true;
            }
            if ((Math.max(other.start.getY(), other.end.getY()) > this.start.getY())
                    && Math.min(other.start.getY(), other.end.getY()) < this.start.getY()) {
                return true;
            }
            if ((Math.max(other.start.getY(), other.end.getY()) > this.end.getY())
                    && Math.min(other.start.getY(), other.end.getY()) < this.end.getY()) {
                return true;
            }
        }
        double b1 = this.start.getY() - this.incline() * this.start.getX();
        double b2 = other.start.getY() - other.incline() * other.start.getX();
        /*
        If there is 2 converging straight lines, we want to check if the segments intersect at more than 1 point
        at the range of the start and end points of each segment.
         */
        if ((Methods.areDoublesEqual(this.incline(), other.incline())
                && Methods.areDoublesEqual(b1, b2))) {
            if ((Math.max(this.start.getY(), this.end.getY()) > other.start.getY())
                    && Math.min(this.start.getY(), this.end.getY()) < other.start.getY()) {
                return true;
            }
            if ((Math.max(this.start.getY(), this.end.getY()) > other.end.getY())
                    && Math.min(this.start.getY(), this.end.getY()) < other.end.getY()) {
                return true;
            }
            if ((Math.max(other.start.getY(), other.end.getY()) > this.start.getY())
                    && Math.min(other.start.getY(), other.end.getY()) < this.start.getY()) {
                return true;
            }
            if ((Math.max(other.start.getY(), other.end.getY()) > this.end.getY())
                    && Math.min(other.start.getY(), other.end.getY()) < this.end.getY()) {
                return true;
            }
            if ((Math.max(this.start.getX(), this.end.getX()) > other.start.getX())
                    && Math.min(this.start.getX(), this.end.getX()) < other.start.getX()) {
                return true;
            }
            if ((Math.max(this.start.getX(), this.end.getX()) > other.end.getX())
                    && Math.min(this.start.getX(), this.end.getX()) < other.end.getX()) {
                return true;
            }
            if ((Math.max(other.start.getX(), other.end.getX()) > this.start.getX())
                    && Math.min(other.start.getX(), other.end.getX()) < this.start.getX()) {
                return true;
            }
            if ((Math.max(other.start.getX(), other.end.getX()) > this.end.getX())
                    && Math.min(other.start.getX(), other.end.getX()) < this.end.getX()) {
                return true;
            }
        }
        //Check if they are completely combined.
        return this.equals(other);
    }

    /**
     * Checks if this line segment is a single point (i.e., has the same starting and ending points)
     * and the other line segment is a line (has distinct starting and ending points),
     * and the point lies on the other line segment, also check the opposit,
     * and also check if the two lines are actually a points and if they lie on one another.
     *
     * @param other The other line segment to check against.
     * @return True if the line segment that is actually a point, lies on the second line segment
     * (that can be a line or a point), false otherwise.
     */
    private boolean pointAsLine(Line other) {
        if (this.start.equals(this.end) && !other.start.equals(other.end)) {
            Point p = new Point(this.start.getX(), this.start.getY());
            if (other.pOnLineSegment(p)) {
                return true;
            }
        }
        if (!this.start.equals(this.end) && other.start.equals(other.end)) {
            Point p = new Point(other.start.getX(), other.start.getY());
            if (this.pOnLineSegment(p)) {
                return true;
            }
        }
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            return this.start.equals(other.start);
        }
        return false;
    }

    /**
     * Checks if a point lies on the lines.
     * This method is used internally by the `isIntersecting` method to verify if the calculated intersection point
     * actually falls on both line segments.
     *
     * @param other The point to check if it's on the line segment.
     * @param line  The line segment to check against.
     * @return True if the point lies on the line segment, false otherwise.
     */
    private boolean isOnLineSegment(Point other, Line line) {
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        double minY = Math.min(this.start.getY(), this.end.getY());
        double maxlX = Math.max(line.start.getX(), line.end.getX());
        double minlX = Math.min(line.start.getX(), line.end.getX());
        double maxlY = Math.max(line.start.getY(), line.end.getY());
        double minlY = Math.min(line.start.getY(), line.end.getY());
        //The lines can also intersect at their start and end points, therefore we will check the entire range.
        return Methods.biggerEqual(other.getX(), minX) && Methods.smallerEqual(other.getX(), maxX)
                && Methods.biggerEqual(other.getY(), minY) && Methods.smallerEqual(other.getY(), maxY)
                && Methods.biggerEqual(other.getX(), minlX) && Methods.smallerEqual(other.getX(), maxlX)
                && Methods.biggerEqual(other.getY(), minlY) && Methods.smallerEqual(other.getY(), maxlY);
    }

    /**
     * Checks if a point lies on the line.
     * This method is used internally by the `isIntersecting` method to verify if a point
     * actually falls on other line segment (only called if we got one line as a point).
     *
     * @param other The point (the line with the same start and end points) to check if it's on the line segment.
     * @return True if the point lies on the line segment, false otherwise.
     */
    public boolean pOnLineSegment(Point other) {
        double incline = this.incline();
        if (incline == Double.POSITIVE_INFINITY) {
            double maxY = Math.max(this.start.getY(), this.end.getY());
            double minY = Math.min(this.start.getY(), this.end.getY());
            return Methods.areDoublesEqual(other.getX(), this.start.getX())
                    && Methods.biggerEqual(other.getY(), minY)
                    && Methods.smallerEqual(other.getY(), maxY);
        }
        double b1 = this.start.getY() - incline * this.start.getX();
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        double minY = Math.min(this.start.getY(), this.end.getY());
        return Methods.biggerEqual(other.getX(), minX) && Methods.smallerEqual(other.getX(), maxX)
                && Methods.biggerEqual(other.getY(), minY) && Methods.smallerEqual(other.getY(), maxY)
                && Methods.areDoublesEqual(other.getY(), incline * other.getX() + b1);
    }

    /**
     * Checks if this line segment intersects with the provided `other` line segment.
     * This method considers various cases including parallel lines, More than 1 point of intersection(overlapping),
     * and lines with infinite incline (vertical lines).
     *
     * @param other The other line segment to check for intersection with.
     * @return True if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //If one of the line as the same start and end point (like a point).
        if ((this.start.equals(this.end) && !other.start.equals(other.end))
                || (!(this.start.equals(this.end)) && other.start.equals(other.end))
                || (this.start.equals(this.end) && other.start.equals(other.end))) {
            return this.pointAsLine(other);
        }
        double incline = this.incline();
        double incline2 = other.incline();
        //If there are 2 lines with the same inclines, check if there is an overlap or one intersect point.
        if (incline == Double.POSITIVE_INFINITY && incline2 == Double.POSITIVE_INFINITY) {
            if (this.infinity(other)) {
                return true;
            }
            return (this.meetAtTheEnds(other) != null);
        }
        if (Methods.areDoublesEqual(incline, incline2)) {
            if (this.infinity(other)) {
                return true;
            }
            return (this.meetAtTheEnds(other) != null);
        }
        //If only one segment has an infinity incline, check if they meet.
        if (incline == Double.POSITIVE_INFINITY) {
            return (infinityMeet(other) != null);
        }
        //If only to the other segment has an infinity incline, check if they meet.
        if (Double.POSITIVE_INFINITY == incline2) {
            return (other.infinityMeet(this) != null);
        }
        double b1 = this.start.getY() - incline * this.start.getX();
        double b2 = other.start.getY() - incline2 * other.start.getX();
        double interX;
        double interY;
        //Lines with the same incline and different constant will never meet.
        if (Methods.areDoublesEqual(incline, incline2) && !Methods.areDoublesEqual(b1, b2)) {
            return false;
        }
        //If the inclines are different, check what would be the meeting point and check if it is on the 2 segments.
        if (!Methods.areDoublesEqual(incline, incline2)) {
            interX = (b2 - b1) / (incline - incline2);
            interY = (incline * interX + b1);
            Point p = new Point(interX, interY);
            return this.isOnLineSegment(p, other);
        }
        return false;
    }
    //Method 'isIntersecting' is not used
//    /**
//     * Checks if this line segment intersects with 2 other lines.
//     *
//     * @param other1 The first line segment to check for intersection with.
//     * @param other2 The second line segment to check for intersection with.
//     * @return True if this 2 lines intersect with this line, false otherwise
//     */
//    public boolean isIntersecting(geometry.Line other1, geometry.Line other2) {
//        return this.isIntersecting(other1) && this.isIntersecting(other2);
//    }
    //Method 'isTriangle' is not used yet
//    /**
//     * Checks if this line segment and the other two lines segments intersects with one another and create a triangle.
//     *
//     * @param other1 The first line segment to check for intersection with.
//     * @param other2 The second line segment to check for intersection with.
//     * @return True if this three lines segments create a triangle and if all three lines don't
//     * meet at the same point, false otherwise.
//     */
//    public boolean isTriangle(geometry.Line other1, geometry.Line other2) {
//        boolean thisWith1 = (this.intersectionWith(other1) != null);
//        boolean thisWith2 = (this.intersectionWith(other2) != null);
//        boolean oneWith2 = (other1.intersectionWith(other2) != null);
//        //If I have 3 different intersecting points between 3 segments it is a triangle.
//        if (thisWith1 && thisWith2 && oneWith2) {
//            geometry.Point p1 = this.intersectionWith(other1);
//            geometry.Point p2 = this.intersectionWith(other2);
//            geometry.Point p3 = other1.intersectionWith(other2);
//            return !p1.equals(p2) && !p2.equals(p3) && !p3.equals(p1);
//        }
//        return false;
//    }

    /**
     * Calculates the intersection point of this line segment with the provided `other` line segment, if they intersect.
     * It also checks if the calculated intersection point falls on both line segments.
     *
     * @param other The other line segment to check for intersection with.
     * @return The intersection point if the lines intersect, null otherwise and in a case of overlap.
     */
    public Point intersectionWith(Line other) {
        //If one of the line as the same start and end point (like a point)
        if (this.start.equals(this.end) && !other.start.equals(other.end)) {
            Point p = new Point(this.start.getX(), this.start.getY());
            if (other.pOnLineSegment(p)) {
                return p;
            }
            return null;
        }
        if (!this.start.equals(this.end) && other.start.equals(other.end)) {
            Point p = new Point(other.start.getX(), other.start.getY());
            if (this.pOnLineSegment(p)) {
                return p;
            }
            return null;
        }
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            if (this.start.equals(other.start)) {
                return this.start;
            }
            return null;
        }
        double incline = this.incline();
        double incline2 = other.incline();
        //If there are 2 lines with the same inclines, check if there is an overlap or one intersect point.
        if (incline == Double.POSITIVE_INFINITY && incline2 == Double.POSITIVE_INFINITY) {
            if (!(infinity(other))) {
                if (this.meetAtTheEnds(other) != null) {
                    return this.meetAtTheEnds(other);
                }
                return null;
            }
            return null;
        }
        if (Methods.areDoublesEqual(incline, incline2)) {
            if (!(infinity(other))) {
                if (this.meetAtTheEnds(other) != null) {
                    return this.meetAtTheEnds(other);
                }
                return null;
            }
            return null;
        }
        //If only one segment has an infinity incline, check if they meet.
        if ((incline == Double.POSITIVE_INFINITY)) {
            return infinityMeet(other);
        }
        //If only to the other segment has an infinity incline, check if they meet.
        if ((incline2 == Double.POSITIVE_INFINITY)) {
            return other.infinityMeet(this);
        }
        //If the inclines are different, check what would be the meeting point and check if it is on the 2 segments.
        if (incline != incline2) {
            double b1 = this.start.getY() - incline * this.start.getX();
            double b2 = other.start.getY() - incline2 * other.start.getX();
            double interX = (b2 - b1) / (incline - incline2);
            double interY = (incline * interX + b1);
            Point p = new Point(interX, interY);
            if (this.isOnLineSegment(p, other)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Checks if this line segment is equal to the provided `other` line segment.
     * Two line segments are considered equal if their starting and ending points are the same, regardless of order.
     *
     * @param other The other line segment to compare with.
     * @return True if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end)) || (this.start.equals(other.end)
                && this.end.equals(other.start));
    }

    /**
     * Finds the closest intersection point between a given rectangle and the start point
     * of this line, or null if there is'nt any intersection points.
     *
     * @param rect the rectangle to check for intersections with the line
     * @return the geometry.Point representing the closest intersection point to the start of the line;
     * returns null if there are no intersection points
     **/
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> arr = rect.intersectionPoints(this);
        if (arr.isEmpty()) {
            return null;
        }
        Point point = arr.get(0);
        Point smallestPoint = point;
        double smallestDistance = this.start.distance(point);
        for (Point p : arr) {
            double currentDistance = this.start.distance(p);
            if (currentDistance < smallestDistance) {
                smallestDistance = currentDistance;
                smallestPoint = p;
            }
        }
        return smallestPoint;
    }

}




