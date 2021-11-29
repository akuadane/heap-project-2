# Project #: CPU Scheduling

* Author: Akayou Adane Kitessa
* Class: CS321 Section #03
* Semester: Fall-21

## Overview

The program simulates a specific type of CPU Scheduling system called 
Round-Robin. It uses Max-Heap to implement a Priority Queue which is 
used to order jobs based on their priorities.

## Reflection
While working on this project, I found the Interfaces that were given and the already started codes to be useful. The structure of the project was made by these components and this made my work easier. The clearly defined statement of the problem also made it super easy to work on this project. For these reasons, I only had to debug my code a few times for minor tweaks.

The more challenging part was writing the test and running the shell script, run-tests.sh, to check my results. The first problem I faced was just running the script. It couldn’t be run for some reason I didn’t understand. But updating the script code from Prof. Amit’s folder seemed to solve the problem. However, I ran into another problem while running the update script. The input files from the Github repo had a trailing newline while caused an error while running the script. I fixed this issue by going to each of the five test cases and removing the newline.



## Compiling and Using
I used Maven for package management, therefore the following instructions should be used for compiling.
```bash
$mvn clean
$mvn package
```

To run the tests for this project, run the following command
```bash
$mvn test
```

To run the code run the command use the java command along with the required and optional
parameters. The following is the general format

```bash
java -cp target/heap-project-2-1.0-SNAPSHOT.jar com.example.CPUScheduling <maxProcessTime> <maxPriorityLevel> <timeToIncrementPriority>
<simulationTime> <processArrivalRate> [<seed>]
```
Example
```bash
java -cp target/heap-project-2-1.0-SNAPSHOT.jar com.example.CPUScheduling  2 2 1 20 0.5 1234
```
To run the project with multiple inputs and test the output run the run-tests.sh script.
```bash
$./run-tests.sh
```
## Results 

The program all of the test cases given on the Github repo.

## Sources used

If you used any sources outside of the lecture notes, class lab files,
or text book you need to list them here. If you looked something up on
stackoverflow.com and fail to cite it in this section it will be
considered plagiarism and be dealt with accordingly. So be safe CITE!
