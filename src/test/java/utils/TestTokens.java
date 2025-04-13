package utils;

public enum TestTokens {
    expired("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoic3BhcnRhIiwiZXhwIjoxNzQ0NTQzMTY5LCJpc3MiOiJZb3VySXNzdWVyIiwiYXVkIjoiWW91cklzc3VlciJ9.lG1WQFq8UXlpvrROCean5L4CDpaQIbRq_PamUGvVQgA"),
    wrong_signature("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoic3BhcnRhIiwiZXhwIjoxNzQ0NTQzMTY5LCJpc3MiOiJZb3VySXNzdWVyIiwiYXVkIjoiWW91cklzc3VlciJ9.lG1WQFq8UXlpvrROCean5L4CDpaQIbRq_PamUGvVQ"),
    invalid("yJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoic3BhcnRhIiwiZXhwIjoxNzQ0NTQzMTY5LCJpc3MiOiJZb3VySXNzdWVyIiwiYXVkIjoiWW91cklzc3VlciJ9.lG1WQFq8UXlpvrROCean5L4CDpaQIbRq_PamUGvVQgA");

    private final String token;

    TestTokens(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
