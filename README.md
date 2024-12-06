Spring Boot Tracking Service

Description

This is a Spring Boot application that provides a REST API for generating tracking numbers based on order details. It supports parameters like origin and destination country, weight, creation time, and customer information.

Prerequisites

Ensure you have the following installed on your system:
•	Java: JDK 8 or higher (Download JDK)
•	Maven: Version 3.6 or higher (Download Maven)
•	Git: Version control system (Download Git)

Getting Started

Clone the Repository

Clone this repository to your local machine using Git:

git clone https://github.com/sanyam786/ScalableTrackingAPI

Navigate to the project directory:

cd tracking-service

Build the Project

Compile and package the project using Maven:

mvn clean package

Run the Application

Run the application using the packaged JAR file:

java -jar target/tracking-0.0.1-SNAPSHOT.jar

Alternatively, you can run the application directly using Maven:

mvn spring-boot:run

Access the Application

Once the application starts, it will be accessible at:

http://localhost:8080

Endpoints

Generate Tracking Number

URL: /next-tracking-number

Method: GET

Parameters:

Parameter	Type	Description
origin_country_id	String	Origin country code (ISO 3166-1 alpha-2 format).
destination_country_id	String	Destination country code (ISO 3166-1 alpha-2 format).
weight	Double	Weight in kilograms (up to 3 decimal places).
created_at	String	Order creation timestamp (RFC 3339 format).
customer_id	UUID	Customer ID in UUID format.
customer_name	String	Customer’s name.
customer_slug	String	Customer’s slug-case name.

Example Request:

http://localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2018-11-20T19:29:32%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics

Example Response:

{
"trackingNumber": "REDMYID8F46210734"
}

Configuration

Application Properties

You can configure the application by editing the src/main/resources/application.properties file.

Example:

server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/tracking
spring.datasource.username=root
spring.datasource.password=root

Run on a Different Port

To run the application on a different port, add the following property:

java -Dserver.port=9090 -jar target/tracking-0.0.1-SNAPSHOT.jar

Troubleshooting

Common Issues

	1.	Port Already in Use:
If the default port (8080) is in use, specify a different port:

java -Dserver.port=9090 -jar target/tracking-0.0.1-SNAPSHOT.jar


	2.	Build Issues:
If the build fails, ensure that all dependencies are installed and try:

mvn clean install


	3.	Database Connection:
If using a database, ensure the database service is running and credentials in application.properties are correct.

View Logs

To view application logs:

tail -f logs/application.log

Tools and Technologies

	•	Spring Boot: Framework for building Java applications.
	•	Maven: Dependency management and build tool.
	•	Java: Backend programming language.

Contribution

Feel free to fork this project and submit pull requests for improvements or new features.

License
