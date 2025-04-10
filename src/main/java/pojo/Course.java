package pojo;

import java.util.List;

public class Course{
	private List<String> spartans;
	private String stream;
	private String endDate;
	private String trainer;
	private String name;
	private List<LinksItem> links;
	private int id;
	private String startDate;

	public void setSpartans(List<String> spartans){
		this.spartans = spartans;
	}

	public List<String> getSpartans(){
		return spartans;
	}

	public void setStream(String stream){
		this.stream = stream;
	}

	public String getStream(){
		return stream;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setTrainer(String trainer){
		this.trainer = trainer;
	}

	public String getTrainer(){
		return trainer;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}
}