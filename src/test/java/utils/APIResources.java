package utils;

public enum APIResources {
    getCourses("/api/courses"),
    getCourse("/api/courses/{id}"),
    authentication("/Auth/login"),
    spartan("/api/spartans"),
    spartanById("/api/spartans/{id}");
    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
