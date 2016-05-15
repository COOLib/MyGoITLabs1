package ua.goit;


import ua.goit.actions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by COOLib on 15.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        Map<String, Action> actions = new HashMap<>();
        actions.put("+", new AddingAction());
        actions.put("-", new SubtractionAction());
        actions.put("*", new MultiplyingAction());
        actions.put("/", new DivisionAction());
        actions.put("sqrt", new SquareRootAction());
        actions.put("pow", new PowerAction());
        actions.put("!", new FactorialAction());
        actions.put("log", new LogarithmAction());

        Calculator calculator = new SpecificCalculator(actions);

        String s = "( 8 + 2 * 5 ) / ( 1 + 3 * 2 - 4 )";

        String k = "8 2 5 * + 1 3 2 * + 4 - /";

        StringBuilder m = new StringBuilder();
        StringBuilder m1 = new StringBuilder();

        String[] s1 = k.split(" ");

        for (int i = s1.length - 1; i >= 0; i--) {
            m.append(s1[i]);
            m.append(" ");
        }

        System.out.println(m);

        try {
            System.out.println(calculator.calculateAnswer(m.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        String string = "((pow(4)+5)+5-3+sqrt(16)+9)";
        System.out.println();
        System.out.println(string);
        System.out.println(calculator.convert(string));
/*
        List<String> operations = new ArrayList<>();
        List<String> operands = new ArrayList<>();

        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(actions.containsKey(s1[i]))) {
                operations.add(s1[i]);
            } else {
                operands.add(s1[i]);
            }
        }
        System.out.println();


        for (String str :operands) {
            System.out.print(str + ",  ");
        }

        System.out.println();

        for (String str : operations) {
            System.out.print(str + ",  ");
        }

        System.out.println();

        try {
            System.out.println(calculator.getAnswer(s));
        } catch (Exception e) {
            e.printStackTrace();
        }

*/
    }
}
