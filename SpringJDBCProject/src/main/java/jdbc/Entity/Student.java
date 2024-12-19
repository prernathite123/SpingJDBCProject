package jdbc.Entity;

public class Student {

	private String name;
	private int id;
	private double marks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int id, double marks) {
		super();
		this.name = name;
		this.id = id;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", marks=" + marks + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
}
