# PairProgramming Activity

## LinkedList Dictionary
![Dictionary](https://www.dailydot.com/wp-content/uploads/d89/cd/ddc38d1af1e11ba9835fedd40edf574d.jpg)

### _Participants_

- Martina de Armas
- Vicente Hoyos

### TASKS

- Add code that performs a verification test when the value “-1” is passed to the program as an argument
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

- Why don’t we choose the word “test” as an argument to activate the test?

Passing the word "test" as an argument would make the program look for the word test inside of the sorted Dictionary instead of comparing sortedDictTest and Sortedbyprogram

- Check with several words that the position matches (5 points)
- Performs a full test of the 10,000 words (10 points)
- Performance test (25 points) _The performance test is under the branch "Testing"_
- Place several timers to control what time it takes to do certain tasks. Do printouts to see that info on the
console (5 points)
- Since some tasks take a variable amount of time, calculate the average, maximum and minimum of
certain tasks to have a better understanding of the limitations of our algorithms (10 points)
- Find bottlenecks and fix them (10 points)
- Check against different inputs (10 points)
- Inputs not expected
- Numbers beyond the limits
- etc

### CODE CORRECTIONS

- *bugs*

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
