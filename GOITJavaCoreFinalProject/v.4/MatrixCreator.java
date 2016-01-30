import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by COOLib on 28.01.2016.
 */
public class MatrixCreator {

    public Matrix readRandomMatrix(int rows, int columns) {

        Matrix matrix = new Matrix(rows, columns);

        double[][] myMatrix = new double[rows][columns];

        for (int i = 0; i < myMatrix.length; i++) {
            int j = 0;
            for (double doub : myMatrix[i]) {
                j++;
                double indication = Math.random() * 10;
                int k = (int) Math.round(indication);
                if (k >= 5) {
                    doub = Math.random() * 100;
                    matrix.setElemant(i, j, doub);
                } else {
                    doub = Math.random() * 100 * (-1);
                    matrix.setElemant(i, j, doub);
                }
            }
        }
        return matrix;
    }

    public Matrix readMatrixFromConsole(int rows, int columns) {

        Scanner scanner = new Scanner(System.in);

        Matrix matrix = new Matrix(rows, columns);

        double[][] myMatrix = new double[rows][columns];

        for (int k = 0; k < rows; k++) {
            for (int j = 0; j < columns; j++) {
                while (true) {
                    if (scanner.hasNextDouble() || scanner.hasNextInt()) {
                        myMatrix[k][j] = scanner.nextDouble();
                        matrix.setElement(k, j, scanner.nextDouble());
                        break;
                    } else {
                        System.out.println("You have to enter Integer or Double numbers.");
                    }
                }
            }
        }
        return matrix;
    }

    public Matrix readMatrixFromFile(int rows, int columns) {

        Matrix matrix = new Matrix(rows, columns);

        try {
            JFileChooser dialog = new JFileChooser();
            dialog.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
            dialog.showOpenDialog(null);
            File file = dialog.getSelectedFile();

            FileInputStream inF = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inF, "utf-8"));
            String s;
            List<String> list = new ArrayList<>();
            while (reader.readLine() != null) {
                s = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(s, ", /;.\n\\'\"", true);

                    while (tokenizer.hasMoreTokens()) {
                        list.add(tokenizer.nextToken());
                    }
            }
            int l = 0;
            for (int k = 0; k < rows; k++) {
                for (int j = 0; j < columns; j++) {
                    matrix.setElement(k, j, Double.parseDouble(list.get(l)));
                    l++;
                }
            }
        } catch (Exception e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return matrix;
    }
}
