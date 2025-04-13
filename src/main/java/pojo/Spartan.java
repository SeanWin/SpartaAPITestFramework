package pojo;

import java.util.List;

public class Spartan{
	private String firstName;
	private String lastName;
	private String stream;
	private String university;
	private boolean graduated;
	private String degree;
	private String course;
	private List<LinksItem> links;
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

	public void setStream(String stream){
		this.stream = stream;
	}

	public String getStream(){
		return stream;
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

	public void setCourse(String course){
		this.course = course;
	}

	public String getCourse(){
		return course;
	}

	public void setLinks(List<LinksItem> links){
		this.links = links;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}