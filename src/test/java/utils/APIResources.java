package utils;

public enum APIResources {
    getCourses("/api/courses");
    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
