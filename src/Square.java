
public class Square extends Shape {
	
	private double side;
	
	public Square(String id, double side) {
		super(id);
		this.side = side;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return side * side;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return side * 4;
	}

	@Override
	public String getShapeType() {
		// TODO Auto-generated method stub
		return "Square";
	}

}
