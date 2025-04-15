package pojo;

public class CourseRequest {
    private Stream stream;
    private String trainer;
    private String startDate;
    private String endDate;
    private String name;
    private int id;

    public void setStream(Stream stream){
        this.stream = stream;
    }

    public Stream getStream(){
        return stream;
    }

    public void setTrainer(String trainer){
        this.trainer = trainer;
    }

    public String getTrainer(){
        return trainer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
