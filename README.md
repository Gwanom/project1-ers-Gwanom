# project1-ers-Gwanom

##API endpoints
- **/reimbs**
  - GET: all reimbursement requests
POST: add a new request
PUT: bulk update of reimbursements (likely not used)
DELETE: remove all reimbursements (likely not used)

-**/reimbs/1**
GET: reimbursement 1
POST: error 405
PUT: update details of reimbursement 1
DELETE: remove reimbursement 1

-**/reimbs/status/1**
GET: reimbursement requests with status 1
POST: error 405
PUT: bulk update of reimbursements with status 1 (likely not used)
DELETE: delete all reimbursements with status 1 (likely not used)

-**/users**
GET: all users (might not be used)
POST: add a new user
PUT: bulk update of users (likely not used)
DELETE: delete all users (likely not used)

-**/users/1**
GET: user with id 1
POST: error 405
PUT: update details of user 1
DELETE: remove user 1

-**/users/1/reimbs**
GET: reimbursement requests submitted by user 1
POST: create a new reimbursement request for user 1
PUT: bulk update of requests for user 1 (likely not used)
DELETE: remove all reimbursements for user 1 (likely not used)



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
if resource doesn’t exist, return 404
