
public class Rectangle extends Shape {

	
	private double side, base;
	
	public Rectangle(String id, double side, double base) {
		super(id);
		this.side = side;
		this.base = base;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return side * base;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		
		return (side * 2 + base * 2);
	}

	@Override
	public String getShapeType() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

}
