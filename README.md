Mars Explorer Simulator(Simple Version):

Development Environment:
	Ubuntu 18.04
	openjdk 11
	
The package includes 10 files/folder

	bin: folder contains application's class files 
	src: folder contains application's java source codes
	test: forlder contains Junit testcase
	simulator.jar: application's runnable jar file
	start.h: bash script for running this application
	UML.png: UML design of the application
	testcase.txt: used for testing automation, txt file includes various test case, 
	     new test case can be added to the file. 
	REQUIREMENT.md: requirements of this project
	README.md: explaining details of files in this project
	result.txt: auto-generated test result of 

How to run the application?

for linux/macOS user: enter ./start.h in the terminal to run the application
for windows user: enter start.h in the terminal to run the application

note:
In this application, user can choose to test testcases data from testcase.txt automatically by enter index 1 (AutoTest), or can choose to manual test testcases by enter index 2 (Manual). 


How to use AutoTest:
AutoTest: Only test results will be displayed, no test case will be shown in the terminal, and those output is stored in result.txt file.

For example:

	testcase: 
	    MOVE 0,0
	    MOVE -1,-1
	    MOVE 1,2
	    PLACE 0,0
	    MOVE 1,2
	    REPORT
	result displayed on the screen: 
	    M: (0,0) (0,1) (0,2) (1,2)
	    P: (1,2)

How to use Manual:
Manual: users need to load testcase manually, both test case and result will be displayed on the
	screen. Once users plan to submit commands, users need to press "enter" key twice to
	comfirm the submission.

	




