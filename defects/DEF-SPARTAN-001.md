**Defect ID:** DEF-SPARTAN-001  
**Title:** 500 Internal Server Error returned when creating Spartan with valid payload

**Environment:**
- API: dockerized instance of SpartaAcademyAPI
- Method: POST
- Endpoint: `http://localhost:8080/api/Spartans`
- Auth: JWT Token (Authenticated)
- Client: Postman

**Reported By:** Sean  
**Date Reported:** 9/4/25  
**Severity:** Medium  
**Priority:** High

**Precondition:**  
Valid JWT token is used in the Authorization header.

**Steps to Reproduce:**
1. Send a POST request to `http://localhost:8080/api/Spartans` with the following JSON body:
    ```json
    {
      "id": 34,
      "firstName": "firstname",
      "lastName": "lastname",
      "university": "uni",
      "degree": "degree",
      "course": {
        "id": 3,
        "name": "TECH 302",
        "stream": {
          "name": "C# Test"
        },
        "trainer": "Nish Mandal"
      },
      "courseId": 3,
      "graduated": true
    }
    ```
2. Observe that the response returns **500 Internal Server Error**.
3. Send a GET request to `http://localhost:8080/api/Spartans`.
4. Observe that the newly created Spartan (firstname lastname) appears in the response.

**Expected Result:**  
API should return **201 Created** with the created Spartan in the response.

**Actual Result:**  
API returns **500 Internal Server Error**, but Spartan is still created and persists in the database.

**Notes:**  
This suggests the object is created but the server fails during post-processing (e.g., mapping, link generation, etc.).

**Status:** Open