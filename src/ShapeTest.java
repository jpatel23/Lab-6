import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		// TODO: complete this...
		Shape rec = new Rectangle("Rec1", 2.0, 6.0);
		Assert.assertEquals("Rectangle area incorrect.", 12.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 16.0, rec.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rec1", rec.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		// TODO: complete this...
		Shape tria = new EquilateralTriangle("Triangle1", 6.0);
		Assert.assertEquals("Triangle area incorrect.", 15.5884572681199, tria.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 18.0, tria.getPerimeter(), 0.0001);
		Assert.assertEquals("EquilateralTriangle", tria.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", tria.getId());
		
		
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		// TODO: complete this...
		Shape trap = new Trapezoid("Trappy", 1.0, 2.0, 4.0, 2.0);
		Assert.assertEquals("Trapezoid area incorrect.", 2.904737509655563, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid", trap.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trappy", trap.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		// TODO: complete this...
		Shape circ = new Circle("Circle1", 1);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI, circ.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape squa = new Square("Squad", 2.0);
		Assert.assertEquals("Square\t ID = Squad\t area = 4.000\t perimeter = 8.000", squa.toString());
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		// TODO: complete this...
		Shape rect = new Rectangle("R2", 1.0, 1.0);
		Shape sqr = new Square("S2", 1.0);
		ShapePerimeterComparator sp = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sp.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sp.equals(rect, sqr));
		
		Shape rect2 = new Rectangle("R", 1.0, 4.0);
		Shape sqr2 = new Square("S", 2.0);
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.",  1, sp.compare(rect2, sqr2));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sp.compare(sqr2, rect2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly find shapes equal.", sp.equals(rect2, sqr2));
		
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sp.compare(sqr2, rect));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sp.compare(rect, sqr2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sp.equals(sqr2, rect));
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		// TODO: complete this...
		Shape rect = new Rectangle("R", 2.0, 1.0);
		Shape sqr = new Square("S", 1.0);
		Assert.assertEquals("CompareTo should find shapes equal.", 1, rect.compareTo(sqr));
		Assert.assertEquals("CompareTo should find shapes equal.", -1, sqr.compareTo(rect));
		
		Shape rect2 = new Rectangle("R2", 1.0, 4.0);
		Shape sqr2 = new Square("S2", 2.0);
		Assert.assertEquals("compareTo gave incorrect ordering.", 1, rect2.compareTo(sqr2));
		Assert.assertEquals("compareTo gave incorrect ordering.", -1, sqr2.compareTo(rect2));
		
		Shape rect3 = new Rectangle("R3", 2.0, 2.0);
		Shape sqr3 = new Square("S3", 2.0);
		Assert.assertEquals("compareTo incorretly find shapes equal", 0, rect3.compareTo(sqr3));
    }
}
