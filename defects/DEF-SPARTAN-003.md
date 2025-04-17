**Defect ID:** DEF-SPARTAN-003  
**Title:** PUT /api/spartans resets nested course fields (startDate, endDate) to 0001-01-01T00:00:00 when omitted

**Environment:**
- API: dockerized instance of SpartaAcademyAPI
- Method: PUT
- Endpoint: `http://localhost:8080/api/Spartans/34`
- Auth: JWT Token (Authenticated)
- Client: Postman

**Reported By:** Sean  
**Date Reported:** 15/4/25  
**Severity:** Medium  
**Priority:** High

**Precondition:**
- Valid JWT token is used in the Authorization header.
- POST a Spartan at `http://localhost:8080/api/Spartans` with the following JSON body:
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

**Steps to Reproduce:**
1. Send a GET request to `http://localhost:8080/api/courses/3` and note the course’s `startDate` and `endDate`.
2. Send a PUT request to `http://localhost:8080/api/Spartans/34` with the following JSON body:
    ```json
    {
        "id": 34,
        "firstName": "updated",
        "lastName": "updated",
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
        "graduated": true
    }
    ```
3. Send a GET request to `http://localhost:8080/api/courses/3`.
4. Observe that the course’s `startDate` and `endDate` are overwritten with `0001-01-01T00:00:00`.

**Expected Result:**
- Either the original `startDate` and `endDate` should be preserved,
- Or the API should reject the request with a 400 status due to missing required fields.

**Actual Result:**  
The course object’s date fields are overwritten with default values (`0001-01-01T00:00:00`) with no validation or error.

**Notes:**
- The response to the PUT request returns a `204 No Content`, which falsely indicates a successful update.
- **Workaround:** Ensure all required fields (`startDate`, `endDate`) are manually included in the request until this is fixed.

**Status:** Open