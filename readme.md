This project is for BackBase sample app testing.

Technologies used:
1. Cucumber : Behavior Driven Development
2. Selenium : Web Automation
3. Java: Programming language
4. Page Object model: Programming pattern for better maintainance and extension

This project can also be integrated without any changes to following:
Jenkins : for CICD
GIT : version control

- Test Cases are in: "src/test/java/com/cucumber/automation/features"
- Results are in: "target/cucumber/index.html"

Softwares needed to run this project:
•	Java >= 7 (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
•	Eclipse >= 4.4.2 (http://www.eclipse.org/downloads/)
•	Maven from terminal (https://maven.apache.org/download.cgi)
•	Eclipse-Maven plugin (https://marketplace.eclipse.org/content/maven-integration-eclipse-luna-and-newer)

How to run this project:
1. open Terminal
2. CD till project root.
3. execute command to run all test cases:
mvn test 

Test coverage:
1. cerate_computer.feature : File containing all scenarios for Create Computer
2. Update_delete_read_computer.feature : File containing all scenarios for Read, delete and update Computer

Advantages:
1. All manual test cases are converted to Automated test cases with ease and in very less time.
2. Any change to manual test case will also reflect in automated test case and automated test cases will be controlled by manual test cases directly.
2. using scenario outlines different combinations can be tested very easily and all conditions are very easily readable.

Results of all scenarios are present in target/cucumber/index.html file.

Analysis:
1. While creating/updating Computer Discontinued date can be less then Introduced date. ( Which should  not be the case)
2. While creating/updating Computer, Computer name could be set to a very large Computer name even more then 256 characters.
	This is not a bug as such but normally there is a limit on Computer name.
3. Duplicate enteries can also be created.

Project has also been uplaoded to 