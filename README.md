# PairProgramming Activity

## LinkedList Dictionary
(Dictionary)[https://www.dailydot.com/wp-content/uploads/d89/cd/ddc38d1af1e11ba9835fedd40edf574d.jpg]

### _Participants_

- Julian Tannus
- Vicente Hoyos

**Code Average Execution Time:** 250000 milliseconds / 250 seconds / 4 minutes, 10 seconds  
_(For the faster branch, we tried making it faster by storing the String value of the last Node in the dictionary, and comparing every new word with it, to see if we could skip going through all the linked list for the values that were going to be stored in the final position of the Linked List. However, the code didn't become faster so we decided to leave the branches the same.)_

**Instructions**  
You will work in pairs
1. First create a project on Github (follow the usual instructions)
2. Clone the project on one’s computer
3.  Both members will be coding in one’s computer
4.  When they decide, they will commit the code, push it to a repository created by themselves and then add the other member as a collaborator of the project. That way, he/she will be able to clone, make push and pull to share the code.
5. It doesn’t matter in which computer you are working, both of you will be all the time discussing the code and making modifications on just one computer

**Push pulling protocol**  
At the beginning, working with a repository can be tricky and lead to errors. To minimize the chances of conflicts, we try to have always the code synced before making any modifications. To ensure this, work in this way:
1. Member A creates a repository on GitHub and IntelliJ following the usual instructions
2. Member A adds member B to the project as a “collaborator”
3. Member A and B works on member A’s computer
4. Stage (add to the stage) and commit code as usual in the local repository in A’s computer
5. After a while push the code to the remote repository on Github https://help.github.com/en/github/using-git/pushing-commits-to-a-remote-repository
6. Switch to member B’s computer and clone the repository
7. Stage and commit code as usual in the local repository of the actual computer
8. After a while push the code to the remote repository on Github
9. Switch to the other member’s computer and pull the code:
.. 1. git pull –u origin master (syntax is the same as push, “git pull” should work as well)
10. Go back to step 7 (keep doing until the code is finished)

**Requisites:**  
1. The application will be able to open a file called “unsorteddict.txt”
2. This file will be a collection of words where each line contains a word
3. The application will read the file line by line, in other words, it will read a new word each time a new line is read
4.  Each time a new line is read, the new word will be inserted in the correct position of a data structure called “dictionary” that will be of a Linked list type
   ..  Therefore , this “dictionary” will be a sorted list of all the words read from the file
5.  After the “unsorteddict.txt” has been fully read, the application will create another file called “sorteddict.txt” which will contain all the words
(one word per line) alphabetically ordered
6. The application will also accept command line arguments, i.e. it could be executed as java LinkDictionary 23 butterfly
7.  The application will accept a minimum of 0 arguments and a maximum of 10 arguments
8.  If the argument is a number, the corresponding word placed in that position in the ordered linked list “dictionary” should be printed out on the
console
9. If the argument is a word, the application should print out in the console the number that represent the order of that word inside the dictionary. If it doesn’t exist, it should write “-1”.
10. Using the LinkedList<T> class from JAVA API is allowed
11. Using any method that automatically sort the list is not allowed, you have to create an algorithm that does the sorting
   
## Testing

### Performance testing
We placed several timers to control what time it takes to do certain tasks:
The first part of the code which allowed user inputs and gave the corresponding outputs took: miliseconds


 Since some tasks take a variable amount of time, calculate the average, maximum and minimum of
certain tasks to have a better understanding of the limitations of our algorithms (10 points)
 Find bottlenecks and fix them (10 points)
