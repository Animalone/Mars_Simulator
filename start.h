#!/bin/bash

echo "Please select mode index"
echo "1: AutoTest: (only test case results will be displayed)"
echo "2: Manual"
read mode


if [ "$mode" = "2" ]
then
	java -jar simulator.jar
elif [ "$mode" = "1" ]
then
	(java -jar simulator.jar) < testcase.txt
	echo "Output can be found in txt file named as result.txt at current folder"
	((java -jar simulator.jar) < testcase.txt) > result.txt
else
	echo "Invalid Input, Please enter 1 or 2"
fi

