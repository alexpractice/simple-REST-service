# simple-REST-service


## Features
- Create 
	- POST /employee | for adding employee
- Read
	- GET /employees | for getting all employees list
	- GET /employee/{empNo} | for getting employee by his number
- Update
	- PUT /employee | for updating employee's info
- Delete
	- DELETE /employees/{empNo} | for deleting employee by his number

Where Employee is entity like {empNo="E05", empName="Smith", position="Clerk"}


## Running app
> mvn clean install spring-boot:run

or
>java -jar simple-rest-service-0.1.0.jar

for starting app on http://localhost:8080/
