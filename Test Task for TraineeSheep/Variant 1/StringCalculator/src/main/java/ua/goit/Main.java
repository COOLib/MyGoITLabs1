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

        String string = "((4+5)+5-3+sqrt(16)+9)";

        String subres = "4 5 + 5 + 3 - 16 sqrt + 9 +";
        System.out.println(string);
        System.out.println(subres);

        String polish = calculator.convert(string);
        System.out.println(polish);

        String[] polishArr = polish.split(" ");
        StringBuilder builder = new StringBuilder();

        StringBuffer s = new StringBuffer();
        s.append(polish);
        s.reverse();

        System.out.println(s);

        for (int i = polishArr.length - 1; i >=0; i--) {
            builder.append(polishArr[i]);
            builder.append(" ");
        }

        try {
            System.out.println(calculator.getAnswer(builder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
