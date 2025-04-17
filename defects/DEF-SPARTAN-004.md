**Defect ID:** DEF-SPARTAN-004  
**Title:** Inability to send POST/PUT requests with course ID 5

**Environment:**
- API: dockerized instance of SpartaAcademyAPI
- Endpoints:
    - PUT: `http://localhost:8080/api/Spartans/{id}`
    - POST: `http://localhost:8080/api/Spartans`
- Auth: JWT Token (Authenticated)
- Client: Postman

**Reported By:** Sean  
**Date Reported:** 15/4/25  
**Severity:** Medium  
**Priority:** High

**Precondition:**
- If sending a PUT request, ensure Spartan with ID 34 has already been posted.

**Steps to Reproduce:**
1. Send a POST or PUT request with the following JSON body:
    ```json
    {
        "id": 34,
        "firstName": "firstname",
        "lastName": "lastname",
        "university": "uni",
        "degree": "degree",
        "course": {
            "id": 5,
            "name": "TECH 304",
            "stream": {
                "name": "Data"
            },
            "trainer": "Paula Savaglia",
            "startDate": "2023-07-01T00:00:00",
            "endDate": "2023-09-01T00:00:00"
        },
        "graduated": true
    }
    ```
2. Observe the validation error in the response indicating that `Course.Stream.Name` does not meet the length requirements.

**Expected Result:**
- The API should either:
    - Allow a valid update (if default values are acceptable), **or**
    - Return a clear error message guiding the user to fix the input without fully rejecting valid operations.

**Actual Result:**
- The API returns an error:  
  `"The field Name must be a string with a minimum length of 6 and a maximum length of 50."`  
  This prevents any POST or PUT requests referencing course ID 5.

**Notes:**
- This issue suggests that either:
    - The API's validation logic for the stream name is too strict for the existing data, **or**
    - The data in the course record should be updated to meet validation rules.

**Status:** Open