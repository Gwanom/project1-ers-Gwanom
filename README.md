# Project 1
## Expense Reimbursement System - Full Stack Web Application 

### API endpoints
- **/reimbs**
  - GET: all reimbursement requests

- **/reimbs/1**
  - GET: reimbursement 1
  - POST: error 405
  - PUT: update details of reimbursement 1

- **/reimbs/status/1**
  - GET: reimbursement requests with status 1
  - POST: error 405

- **/users** (done)
  - GET: all users (might not be used)
  - POST: add a new user

- **/users/1** (done)
  - GET: user with id 1
  - POST: error 405

- **/users/1/reimbs** (done)
  - GET: reimbursement requests submitted by user 1
  - POST: create a new reimbursement request for user 1
    - because a reimbursement mut have an associated author, adding new requests is only available
      from this endpoint, instead of *POST*ing to e.g. /reimb/1


if any post body does not contain JSON, return 415
if get header has accept field, and that field does not specify JSON, return 406

**GET:**
any successful request should return status code 200
if the resource is not found, return 404

**POST:**
if new resource is successfully created, return 201 and the new resource
if invalid data in request, return 400

**PUT:**
if a resource is updated, return 200 and the updated resource
if the resource isn't found, return 422