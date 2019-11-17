# Applying Coding Principles
###### _By: Martina Armas and Vicente Hoyos_
## LinkedList Dictionary

By using the 7 main coding principles we made our code more understandable, easier to modify and simple.

### 1. Meaningful names
In our previous code we used very broad names for methods and classes that could mean different things, this is why we changed them.

#### User arguments class:
arguments → userInput

commands → individualUserInput

file1 → readSortedByProgramFile

file2 → readSortedDictTestsFile

line1 → eachLineSortedByProgram

line 2 → eachLineSortedDictTest

lineNum → indexPositionOfLineByNumber

compare → timeElapsedInFileComparison

#### Main
start → timeElapsedForDictSorting

file → fileToBeSorted

br → unsortedFileReader

bw → sortedFileWriter

#### Performance → performanceTestingForProgram
file1 → readSortedByProgramFile

file2 → readSortedDictTestsFile

line1 → eachLineSortedByProgram

line 2 → eachLineSortedDictTest

lineNum → indexPositionOfLineByNumber

end → finalTimeForPerformanceTesting

start → initialTimeForPerformanceTesting

test → totalTimeElapsedForTesting

time → timeElapsedForPerformanceTest

2.	Keep functions small

We kept our functions small with less than 3 arguments as it makes them more readable


3.	Avoid redundant commenting

We erased all our cooment which explained the code as it is more understandable with the specific names we created. As there was no need for binary code or legal comments, we ommited that.

4.	SRP Single Responsibility Principle

We separated "userarguments" and "performance" in different classes and called them in the Main. We tried to divide more, but didn't find how. Still what we did made managed to focus on just one goal o aspect.

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


