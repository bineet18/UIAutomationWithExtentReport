# CloudCoverExercise

Installation Guide for System Setup:
1. Clone the Project in the local Machine
2. Check the version of the Chrome and Download the corresponding version of the ChromeDriver from the internet.
3. Place the ChromeDriver.exe in the location ./CloudCoverExercise/drivers/
4. Make sure JDK and Maven is installed in the System.
5. Make sure that the TestNG plugin is installed in the Eclipse.

Guide to setup and the Framework in Eclipse/STS:
1. Import the Project in the Eclipse/STS
2. Open the file config.properties and set the Browser(Chrome, Edge, Firefox)
3. Run the Framework using either of the method:
	a) Eclipse:
		- Right click the testng.xml file and Run As TestNg Suite.
	b) CommandPormpt/Powershell:
		- Navigate to the location of pom.xml, in the explorer and Open the Command Prompt/Powershell at that location.
		- Type the command: mvn test

Verification:
1. The API Testcases covers the Testing for Bad inputs.
2. The API Testcases takes the expected Status Code and compares it with actual Status code and Passes/Fails the Testcases.
3. The API Testcases gives the output of the positive testcases, in form of POJO classes. This ensures the datatype of the attributes are correct.
4. Upon the Test completion, Navigate to the folder ./CloudCoverExercise/reports and open the file index.html, in the Browser.
5. Navigate to the Suite Execution and Click on the UP arrow(to collapse all the Panes).
6. Verify the logged results.
7. Navigate to ./CloudCoverExercise/OutputJSON/* , to get the JSON files, that are saved during the Testcase execution.