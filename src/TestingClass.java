import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestingClass {
    public static void performanceTestingForProgram() throws IOException {

        long timeElapsedForPerformanceTesting = 0;

        for (int i = 0; i < 10; i++) {

            long initialTimeForPerformanceTesting = System.currentTimeMillis();


            BufferedReader readSortByProgramFile = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/Sortedbyprogram.txt"));
            BufferedReader readSortedDictTestFile = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/sortedDictTest.txt"));

            String eachLineSortedByProgramFile = readSortByProgramFile.readLine();
            String eachLineSortedDictTestFile = readSortedDictTestFile.readLine();

            boolean areEqual = true;
            int indexPositionOfLineByNumber = 1;

            while (eachLineSortedByProgramFile != null || eachLineSortedDictTestFile != null) {
                if (eachLineSortedByProgramFile == null || eachLineSortedDictTestFile == null) {
                    areEqual = false;
                    break;
                } else if (!eachLineSortedByProgramFile.equalsIgnoreCase(eachLineSortedDictTestFile)) {
                    areEqual = false;
                    break;
                }

                eachLineSortedByProgramFile = readSortByProgramFile.readLine();
                eachLineSortedDictTestFile = readSortedDictTestFile.readLine();
                indexPositionOfLineByNumber++;
            }

   /*         if (areEqual) {
                System.out.println("Two files have same content.");
            } else {
                System.out.println("Two files have different content. They differ at line " + indexPositionOfLineByNumber);
                System.out.println("Sortedbyprogram has " + eachLineSortedByProgramFile + " and sortedDictTest has " + eachLineSortedDictTestFile + " at line " + indexPositionOfLineByNumber);
            }
*/
            readSortByProgramFile.close();

            readSortedDictTestFile.close();


            long finalTimeForPerformanceTesting = System.currentTimeMillis();
            long totalTimeElapsedForTesting = finalTimeForPerformanceTesting - initialTimeForPerformanceTesting;
            timeElapsedForPerformanceTesting = timeElapsedForPerformanceTesting + totalTimeElapsedForTesting;
        }


        System.out.println("Average time for perfomance test: " + (timeElapsedForPerformanceTesting/10));

    }
}
