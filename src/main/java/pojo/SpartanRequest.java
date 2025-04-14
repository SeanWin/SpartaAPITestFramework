package pojo;

public class SpartanRequest{
	private String firstName;
	private String lastName;
	private String university;
	private boolean graduated;
	private String degree;
	private CourseRequest course;
	private int id;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setUniversity(String university){
		this.university = university;
	}

	public String getUniversity(){
		return university;
	}

	public void setGraduated(boolean graduated){
		this.graduated = graduated;
	}

	public boolean isGraduated(){
		return graduated;
	}

	public void setDegree(String degree){
		this.degree = degree;
	}

	public String getDegree(){
		return degree;
	}

	public void setCourse(CourseRequest course){
		this.course = course;
	}

	public CourseRequest getCourse(){
		return course;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
