import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static void sleepingTime(long milisec) {

        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startMessages() {

        System.out.printf("Hi! This is matrix calculator!");
        sleepingTime(300);

        System.out.println("Here you can perform these actions:");
        System.out.println("Addition, subtraction or multiplication of matrix ");
        System.out.println("Or you can multiply matrix by number.");
        System.out.println("Also, you can exit out of program.");
        sleepingTime(500);
        System.out.println("To make choice you need to enter one of these letters:");
        System.out.println("\"+\" - is addition, \"-\" - is subtraction, \"*\" - is multiplication");
        System.out.println("\"e\" - is exit out of program");
        sleepingTime(1200);
        System.out.println("Please, make your choice.");
    }

    private String operationEntering() {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

    private int numberEntering(){
        Scanner scanner = new Scanner(System.in);
        int k;
        int l;
        while (true){
            if (scanner.hasNextInt()){
              k = scanner.nextInt();
                if (k > 0) {
                    l = k;
                    break;
                }
            }
            else {
                System.out.println("Please, enter a number bigger than 0.");
            }
        }
        return l;
    }

    private void readOperation(char operation) {

        char c = operation;

        MatrixCreator creator = new MatrixCreator();

        int k = numberEntering();
        int l = numberEntering();
        if (operation == 'r') {
            creator.readRandomMatrix(k, l);
        } else if (operation == 'c') {
            creator.readMatrixFromConsole(k, l);
        } else if (operation == 'f') {
            creator.readMatrixFromFile(k, l);
        }
    }

    public void startDialog() {

        String s = operationEntering();

        while (true) {
            if (s == "e") {
                System.exit(0);
            } else if (s == "+" || s == "-" || s == "*") {
                System.out.println("It is your first operation?");
                System.out.println("Please, enter \'y\' or \'n\'.");
                while (true) {
                    String s1 = operatioEntering();
                    if (s1 == "y") {
                        System.out.println("By what way you want to create first matrix?");
                        chooseCreationWay();
                        break;
                    } else if (s1 == "n") {
                        System.out.println("Result matrix will be the first in your next operation.");


                        break;
                    } else {
                        System.out.println("Please, enter \'y\' or \'n\'.");
                    }
                    break;
                }
            } else {
                System.out.println("Please, make your choice.");
                System.out.println("To make choice you need to enter one of these letters: '+', '-', '*','e'");
            }
        }
    }

    private void chooseCreationWay() {

        System.out.println("Please, enter next letter:");
        System.out.println("\'r\' - if you want to create matrix with random numbers,");
        System.out.println("\'c\' - if you want to enter numbers by yourself,");
        System.out.println("\'f\' - if you want to download matrix from file.");
        sleepingTime(500);
        System.out.println("Please, make your choice.");
        String s = operationEntering();
        switch (s) {
            case "r":
                readOperation('r');
                break;
            case "c":
                readOperation('c');
                break;
            case "f":
                readOperation('f');
                break;
        }
    }

    public double readNumber() {

        double d;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                break;
            }
        }
        return d;
    }

    public void printResult(Matrix resultMatrix) {

        int k = 0;
        for (int i = 0; i < resultMatrix.getRowsNumber(); i++) {
            for (int j = 0; j < resultMatrix.getColumnsNumber(); j++) {
                if (resultMatrix.getElement(i, j).doubleValue() != resultMatrix.getElement(i, j).intValue()) {
                    k++;
                    break;
                }
            }
        }

        if (k == 0) {
            printIntResult(resultMatrix);
        } else {
            printDoubleResult(resultMatrix);
        }
    }

    private void printIntResult(Matrix result) {

        for (int i = 0; i < result.getRowsNumber(); i++) {
            for (int j = 0; j < result.getColumnsNumber(); j++) {
                System.out.printf("%8d", (int) (result.getElement(i, j)));
            }
            System.out.println();
        }
    }

    private void printDoubleResult(Matrix result) {

        for (int i = 0; i < result.getRowsNumber(); i++) {
            for (int j = 0; j < result.getColumnsNumber(); j++) {
                System.out.printf("%8.3f", result.getElement(i, j));
            }
            System.out.println();
        }
    }
}
