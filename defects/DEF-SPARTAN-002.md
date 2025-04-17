**Defect ID:** DEF-SPARTAN-002  
**Title:** Inconsistent handling of course object in Spartan POST request based on course ID presence

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
1. Send a POST request with this JSON body:
    ```json
    {
        "id": 34,
        "firstName": "firstname",
        "lastName": "lastname",
        "university": "uni",
        "degree": "degree",
        "course": {
            "id": 7,
            "name": "",
            "stream": {
                "name": "rarrar"
            },
            "trainer": ""
        },
        "graduated": true
    }
    ```
2. If course with ID 7 exists: it silently uses the existing course and ignores blank fields.
3. If course ID 7 does not exist: a new course is created with the blank and invalid fields.

**Expected Result:**  
Either:  
– A clear validation error if invalid course fields are provided  
– Or: Consistent behavior when course ID is present vs. absent

**Actual Result:**  
Behavior changes based on whether the course ID exists:  
– Existing course silently used, fields ignored  
– New invalid course created if ID does not exist

**Notes:**  
This could lead to data inconsistency and unintended course creation. It should either enforce strict validation or clearly separate course creation from Spartan POST.

**Status:** Open