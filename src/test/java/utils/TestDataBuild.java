package utils;

import pojo.CourseRequest;
import pojo.SpartanRequest;
import pojo.Stream;

public class TestDataBuild {

    public SpartanRequest createSpartanPayload(String firstName, String lastName, String streamName) {

        Stream stream = new Stream();
        stream.setName(streamName);

        CourseRequest course = new CourseRequest();
        course.setName("TECH 302");
        course.setTrainer("Nish Mandal");
        course.setStartDate("2023-05-01T00:00:00");
        course.setEndDate("2023-07-01T00:00:00");
        course.setStream(stream);
        course.setId(3);

        SpartanRequest spartan = new SpartanRequest();
        spartan.setFirstName(firstName);
        spartan.setLastName(lastName);
        spartan.setUniversity("Uni");
        spartan.setGraduated(true);
        spartan.setDegree("degree");
        spartan.setCourse(course);
        spartan.setId(34);

        return spartan;
    }

    public SpartanRequest createSpartanPayload(int id, String firstName, String lastName, String streamName) {

        Stream stream = new Stream();
        stream.setName(streamName);

        CourseRequest course = new CourseRequest();
        course.setName("TECH 302");
        course.setTrainer("Nish Mandal");
        course.setStartDate("2023-05-01T00:00:00");
        course.setEndDate("2023-07-01T00:00:00");
        course.setStream(stream);
        course.setId(3);

        SpartanRequest spartan = new SpartanRequest();
        spartan.setFirstName(firstName);
        spartan.setLastName(lastName);
        spartan.setUniversity("Uni");
        spartan.setGraduated(true);
        spartan.setDegree("degree");
        spartan.setCourse(course);
        spartan.setId(id);

        return spartan;
    }
}
