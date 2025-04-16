package utils;

import pojo.CourseRequest;
import pojo.SpartanRequest;
import pojo.Stream;

public class TestDataBuild {

    public SpartanRequest createSpartanPayload(String firstName, String lastName, String streamName) {

        SpartanRequest spartan = new SpartanRequest();
        spartan.setFirstName(firstName);
        spartan.setLastName(lastName);
        spartan.setUniversity("Uni");
        spartan.setGraduated(true);
        spartan.setDegree("degree");
        spartan.setCourse(buildCourse(streamName));
        spartan.setId(34);

        return spartan;
    }

    public SpartanRequest createSpartanPayload(int id, String firstName, String lastName, String streamName) {

        SpartanRequest spartan = new SpartanRequest();
        spartan.setFirstName(firstName);
        spartan.setLastName(lastName);
        spartan.setUniversity("Uni");
        spartan.setGraduated(true);
        spartan.setDegree("degree");
        spartan.setCourse(buildCourse(streamName));
        spartan.setId(id);

        return spartan;
    }

    private CourseRequest buildCourse(String streamName) {
        Stream stream = new Stream();
        stream.setName(streamName);

        CourseRequest course = new CourseRequest();
        course.setStream(stream);

        switch (streamName.toLowerCase()) {

            case "c# dev":
                course.setName("TECH 300");
                course.setTrainer("Phil Windridge");
                course.setStartDate("2023-03-01T00:00:00");
                course.setEndDate("2023-05-01T00:00:00");
                course.setId(1);
                break;

            case "java dev":
                course.setName("TECH 301");
                course.setTrainer("Catherine French");
                course.setStartDate("2023-04-01T00:00:00");
                course.setEndDate("2023-06-01T00:00:00");
                course.setId(2);
                break;

            case "devops":
                course.setName("TECH 303");
                course.setTrainer("Abdul Shahrukh Khan");
                course.setStartDate("2023-06-01T00:00:00");
                course.setEndDate("2023-08-01T00:00:00");
                course.setId(4);
                break;

            default:
                course.setName("TECH 302");
                course.setTrainer("Nish Mandal");
                course.setStartDate("2023-05-01T00:00:00");
                course.setEndDate("2023-07-01T00:00:00");
                course.setId(3);
                break;
        }

        return course;
    }
}
