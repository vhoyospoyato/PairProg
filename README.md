# Applying Coding Principles
###### _By: Martina Armas and Vicente Hoyos_
## LinkedList Dictionary

By using the 7 main coding principles we made our code more understandable, easier to modify and simple.

### 1. Meaningful names
In our previous code we used very broad names for methods and classes that could mean different things, this is why we changed them.

##### User arguments class:
arguments → userInput
commands → individualUserInput

file1 --> readSortedByProgramFile
file2 --> readSortedDictTestsFile

line1 --> eachLineSortedByProgram
line 2 --> eachLineSortedDictTest

lineNum--> indexPositionOfLineByNumber

compare --> timeElapsedInFileComparison

##### Main
start--> timeElapsedForDictSorting
file --> fileToBeSorted

br --> unsortedFileReader
bw --> sortedFileWriter

##### Performance --> performanceTestingForProgram
file1 --> readSortedByProgramFile
file2 --> readSortedDictTestsFile

line1 --> eachLineSortedByProgram
line 2 --> eachLineSortedDictTest

lineNum--> indexPositionOfLineByNumber

end --> finalTimeForPerformanceTesting
start --> initialTimeForPerformanceTesting
test --> totalTimeElapsedForTesting
time --> timeElapsedForPerformanceTest







•	Start naming methods and classes with good names
•	The more explicit the better
•	Instead of counter “elapsedSeconds”
•	For classes think on real objects, avoid empty names like “manager, processor, or data”
•	For methods use verbs


2.	Keep functions small


•	The smaller the function the better, it will be more readable
•	Long function shouldn’t have more than 3 arguments
•	Cut functions in different pieces


3.	Avoid redundant commenting


•	Your code speaks by itself, if you choose the right names, there is no need to add comments
•	Always better to comment than deliver ininteligible (not readable like binary numbers) code
•	Always use legal comments (copyright)
4.	SRP Single Responsibility Principle


•	A class or method should be modified for ONE reason
•	That means the entity should be focused on just one goal or aspect
•	A technique is to gather together the things that change for the same reasons and separate those that change for different reasons
•	Example: imagine the code for a game, you should have different classes for every part of the code, don’t mix code “difficulty”, “game” and “board” in the same class
•	The more that you divide the better
•	Is this an element that can be taken out and be part of the application?


5.	DRY Don’t Repeat Yourself


•	Every piece of knowledge must have a single, unambiguous authorative representations within a system
•	Reuse code by extracting methods
•	Declare variables and use them
•	Abstract hardcoded values into constants


6.	Keep your code simple


•	KISS: keep it simple, stupid!
•	Avoid complexity
•	Usually abstracting or thinking for alternative solutions feliver simpler code


7.	YAGNI (You Ain’t Gonna Need It)


•	The more that we code the more that we foresee what kind of elements, classes or functions that we are going to need later
•	Often extra code is generated which is not used later

###### _For further information contact: [Martina Armas](https://www.linkedin.com/in/martina-armas-793b60157/) or [Vicente Hoyos](https://www.linkedin.com/in/vicente-hoyos-787594124/)_


