# bookingserv

## Assumptions
- Assuming the craft is to focus on the coding aspect of the problem.
- Hence the design refactoring opportunities (API model etc) and refactoring were kept aside for brevity. 
- For the tasks, required pattern and end to end workflow of atleast one example is implemented.
- Due to the interest of time, the possible enhancements and what could have done is called out.

## Tasks
| Index | Task                                                                                                                                                                                                                                                                      | Status                                         | Enhancements                                                                                                                          |
|-------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| 1     | booking.json<br> has only name, and id elements. Please add date of birth, checkin, checkout, totalprice, deposit and address elements to the Booking resource. Address will have line1, line2, city, state, country and zip_code elements. line2 is an optional element. | 🟢 All mentioned fields are added.              | Minimal validation is done as part of the craft. However kept it as open for now.                                                     |
| 2     | Add one more operation in BookingResource to Get All the bookings. BookingResource will have two operations, one to create, and another to retrieve all bookings.                                                                                                         | 🟢 All REST endpoints are added.                | Get all can be paginated by using PagingAndSortingRepository. Kept it as open for now.                                                |
| 3     | Implement create and get all the bookings operations in BookingResourceImpl.java.                                                                                                                                                                                         | 🟢 Implemented the required REST endpoints.     | There are opportunities to refactor the Booking and Address endpoints and separate them.                                              |
| 4     | Please add the unit tests to validate your implementation.                                                                                                                                                                                                                | 🟢 Basic unit testing is added                  | There is ample opportunity to get more coverage on unit testing.                                                                      |
| 5     | Please use h2 in-memory database or any other in-memory database to persist the Booking resource. Dependency for h2 in-memory database is already added to the parent pom.                                                                                                | 🟢 Added H2 as the data store                   | Could add script file to seed some test data, which is pending.                                                                       |
| 6     | Please make sure the validations done for the requests.                                                                                                                                                                                                                   | 🟢 Basic validations are done as example        | As mentioned earlier, lot more validation opportunities are there.                                                                    |
| 7     | Response codes are as per rest guidelines.                                                                                                                                                                                                                                | 🟢 Response codes are handled as per guidelines | The internal 5xx errors could be handled. A custom exception could also be implemented                                                |
| 8     | Error handling in case of failures.                                                                                                                                                                                                                                       | 🟢 Basic error handling is done                 | A custom exception could also be implemented and better try catches at layers for 5xx.                                                |
| 9     | Implement idempotency logic to avoid duplicate resource creation.                                                                                                                                                                                                         | 🟡 This is an open item                         | Idempotency can be achieved by having and idempotency-key and a redis cache, so that duplicate POST/PUT/PATCH requests can be handled |

## Application Overview
bookingserv is a spring boot rest application which would provide the CRUD operations for `Booking` resource.

There are three modules in this application
- bookingservApi - This module contains the interface.
    - `v1/schema/booking.json` defines the booking resource.
    - `jsonschema2pojo-maven-plugin` is being used to create `Booking POJO` from json file.
    - `BookingResource.java` is the interface for CRUD operations on `Booking` resource.
        - POST `/v1/bfs/booking` endpoint defined to create the resource.
- bookingservImplementation - This module contains the implementation for the rest endpoints.
    - `BookingResourceImpl.java` implements the `BookingResource` interface.
- bookingservFunctionalTests - This module would have the functional tests.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `bookingservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/v1/bfs/booking` POST or GET endpoint.

## Assignment
We would like you to enhance the existing project and see you complete the following requirements:

- `booking.json` has only `name`, and `id` elements. Please add `date of birth`, `checkin`, `checkout`, `totalprice`, `deposit` and `address` elements to the `Booking` resource. Address will have `line1`, `line2`, `city`, `state`, `country` and `zip_code` elements. `line2` is an optional element.
- Add one more operation in `BookingResource` to Get All the bookings. `BookingResource` will have two operations, one to create, and another to retrieve all bookings.
- Implement create and get all the bookings operations in `BookingResourceImpl.java`.
- Please add the unit tests to validate your implementation.
- Please use h2 in-memory database or any other in-memory database to persist the `Booking` resource. Dependency for h2 in-memory database is already added to the parent pom.
- Please make sure the validations done for the requests.
- Response codes are as per rest guidelines.
- Error handling in case of failures.
- Implement idempotency logic to avoid duplicate resource creation.

## Assignment submission
Thank you very much for your time to take this test. Please upload this complete solution in Github and send us the link to `bfs-sor-interview@paypal.com`.