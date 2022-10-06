##### Getting started #####

## Pre-requisite ## 
Java8 should be installed on the system.
maven should be installed.

## Steps ##
1. checkout the project "blog-service" from the repository.
2. do "mvn install" and it will download all the dependencies.
3. run the BlogServiceApplication.java as Java application or Springboot App.
4. Run the GET API URL

http://localhost:8080/v1/admin/allUserPosts


5. Authorization is required to run this Admin API endpoint.
6. Set Type as "BasicAuth" with username = "admin" and password = "password".

7. Below is the required curl:
1. 
curl -X GET \
  http://localhost:8080/v1/admin/allUserPosts \
  -H 'authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 976e044b-6157-8dcb-96c6-68669bb07c6f' 

## Information about the project ##
1. Controller of the application is "AdminResource.java" which is the starting point.
2. AdminService.java contains the business logic and it also prepares final response by combining the response from two external api endpoints.
3. JPHRestClient.java contains the logic to call external api endpoint.
4. EndPoint is enum that contains two values (users, posts)
5. Spring security is used to add basic authentication because this is admin api endpoint. Ideally any web app will have a login mechanism for the admin user but i have added basic authentication as one next level of security because this is the admin api endpoint which should be accessible to limited set of users.
6. ExceptionHandling is done by considering the scenario if external api is down.