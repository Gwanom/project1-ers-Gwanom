# Project 1
## Expense Reimbursement System - Full Stack Web Application 

### API endpoints
- **/reimbs**
  - GET: all reimbursement requests
  - POST: add a new request

- **/reimbs/1**
  - GET: reimbursement 1
  - POST: error 405
  - PUT: update details of reimbursement 1

- **/reimbs/status/1**
  - GET: reimbursement requests with status 1
  - POST: error 405

- **/users** -done
  - GET: all users (might not be used)
  - POST: add a new user

- **/users/1** -done
  - GET: user with id 1
  - POST: error 405

- **/users/1/reimbs**
  - GET: reimbursement requests submitted by user 1
  - POST: create a new reimbursement request for user 1


if any post body does not contain JSON, return 415
if get header has accept field, and that field does not specify JSON, return 406

**GET:**
any successful request should return status code 200
if the resource is not found, return 404

**POST:**
if new resource is successfully created, return 201
if invalid data in request, return 400

**DELETE:**
if resource is successfully deleted, return 204
if resource doesn’t exist, return 422
