# Pair Programming Activity 2
###### _By: Martina Armas and Vicente Hoyos_
## LinkedList Dictionary
![Dictionary](https://www.dailydot.com/wp-content/uploads/d89/cd/ddc38d1af1e11ba9835fedd40edf574d.jpg)


## Verification test

1. Add code that performs a verification test when the value “-1” is passed to the program as an argument
(5 points)




                        if (Integer.parseInt(commands [i]) == -1) {
                        BufferedReader reader1 = new BufferedReader(new FileReader("/Users/martinaarmas/PairProg/Sortedbyprogram.txt"));
                        BufferedReader reader2 = new BufferedReader(new FileReader("/Users/martinaarmas/PairProg/sortedDictTest.txt"));
                        
                        String line1 = reader1.readLine();
                        String line2 = reader2.readLine();

                        boolean areEqual = true;
                        int lineNum = 1;

                        while (line1 != null || line2 != null) {
                            if (line1 == null || line2 == null) {
                                areEqual = false;
                                break;
                            } else if (!line1.equalsIgnoreCase(line2)) {
                                areEqual = false;
                                break;
                            }

                            line1 = reader1.readLine();
                            line2 = reader2.readLine();
                            lineNum++;
                        }

                        if (areEqual) {
                            System.out.println("Two files have same content.");
                        } else {
                            System.out.println("Two files have different content. They differ at line " + lineNum);
                            System.out.println("Sortedbyprogram has " + line1 + " and sortedDictTest has " + line2 + " at line " + lineNum);
                        }

                        reader1.close();

                        reader2.close();

2. Why don’t we choose the word “test” as an argument to activate the test?

Passing the word "test" as an argument would make the program look for the word test inside of the sorted Dictionary instead of comparing sortedDictTest and Sortedbyprogram

3. Check with several words that the position matches (5 points)

The program displays the line and the word that are not in the right place.

4. Performs a full test of the 10,000 words (10 points)

## Performance test 

5. Place several timers to control what time it takes to do certain tasks. Do printouts to see that info on the
console (5 points)

This is found in the branch "Testing"

6. Since some tasks take a variable amount of time, calculate the average, maximum and minimum of
certain tasks to have a better understanding of the limitations of our algorithms (10 points)

The average time was of *670* milliseconds approximately. 


7. Find bottlenecks and fix them (10 points)

Running the matching test we found that a word was being placed in the wrong place, therefore we had to change the last else statement.


   
                                
                               else{
                                current = current.next; 
                                if (current.next == null){
                                    Node temp = new Node(line);
                                    if (current.data.compareToIgnoreCase(line) > 0){
                                        temp.next = current;
                                        dictionary.get(index).next = temp;
                                        dictionary.add(index + 1, temp);
                                    }
                                    else{
                                        dictionary.getLast().next = temp;
                                        dictionary.addLast(temp);                         
                                    }
                                    break;
                                }
                                index ++;
                            }

This made a huge difference in time and managed to order the dictionary properly.

## Check against different inputs

Inputs not expected, numbers beyond the limits, etc.(10 points)



We tested the code with negative numbers, words that weren't in the dictionary, numbers higher than the length of the dictionary and words with different characters that aren't part of the alphabet.

###### _For further information contact: [Martina Armas](https://www.linkedin.com/in/martina-armas-793b60157/) or [Vicente Hoyos](https://www.linkedin.com/in/vicente-hoyos-787594124/)_


