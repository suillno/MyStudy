package vo;

public class StudentVO {

	private int id;
	private String name;
	private String grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public StudentVO(int id, String name, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	public StudentVO() {
		super();
	}
	
}
