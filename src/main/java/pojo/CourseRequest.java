package pojo;

public class CourseRequest {
    private Stream stream;
    private String trainer;
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
