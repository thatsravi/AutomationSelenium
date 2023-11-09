Introduction
This framework uses *PageFactory* method to store the WebElements in the page objects. The elements are initialized in the constructors of their respective  page objects with the help of *PageFactory.initElements*

Features:
•	Test Data read from properties file
•	Use Maven as build execution tool
•	Implemented proper waits.
•	The global configuration values like browser name, test site URL, global wait value etc. should be read from a properties file
•	The test run on following browser Chrome. For rest of the browser need to download the .exe file and put under src/drivers
•	Every Test method has annotation @test. This is the place where we have all the checkpoints.	This class utilizes TestNG annotations to handle the flow of test execution in the given order.

How to use
•	The first thing a framework should be able to handle is to launch the browser and navigate a given url.
•	Download Dependencies

Project structure
The automation framework is built to address following 4 major requirements through it's components.
•	Setup the WebDriver to automate actions on browser.
•	Page Classes for each page containing locators of their respective WebElements and methods to operate on them.
•	Test Classes containing Test cases in the form of methods with annotation @Test.
•	Execution control- We are executing our tests through testng.xml. It can be other options such as through mvn test or command line.
•	Create a readable html report after test execution.

Every Test method has annotation @test. This is the place where we have all the checkpoints.	This class utilizes TestNG annotations to handle the flow of test execution in the given order.

Run tests through testng.xml
If you want to run your tests through testng.xml , You can perform following steps.
	 1. Eclipse>Project Explorer
	 2. Open/Expand the project
	 3. Right click on the testng.xml
	 4. Run As> TestNG Suite
It will run all the tests as per defined classes in the the file.