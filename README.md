# State Management

Simple SignIn screen and Product list view

## Running the app

Set an environment variable `SPRING_PROFILES_ACTIVE=local`

`./gradlew bootRun`


## Building the app

`./gradlew build`

##Notes
1. Runs in 8080 port
2. Uses internal DB(h2)

##URL
1. Login [here](http://localhost:8080/login)
2. View Internal DB Console [here](http://localhost:8080/h2-console/)

# DB Details
1. URL=jdbc:h2:mem:stateManagement
2. username=admin
3. password=admin

#Login Details
* user1@test.com | password
* user2@test.com | password

#Description
This application will internally uses H2 DB for data storage and render.
When the application starts initially 2 new users and products to that user will be added.


* Password storage uses base64 encoded format.

* Product view details is only specific to login user.

* Internally uses session storage for login/signIn.

