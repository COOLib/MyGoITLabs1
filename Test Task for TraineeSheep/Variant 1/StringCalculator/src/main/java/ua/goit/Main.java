package ua.goit;


import ua.goit.actions.*;

import java.util.HashMap;
import java.util.Map;

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

        String string = "1+sqrt(4)+!(5)";

        String subRes = "2 2 * 5 + 5 + 4 + 3 - 16 4 / + 9 +";
        System.out.println("original string: " + string);

        String polish = calculator.convert(string);
        System.out.println("reversed polish string: " + polish);

        String[] polishArr = polish.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = polishArr.length - 1; i >= 0; i--) {
            builder.append(polishArr[i]);
            builder.append(" ");
        }

        System.out.println("again reversed string: " + builder.toString());

        String total = calculator.reverseReplace(builder.toString());

        System.out.println();
        System.out.println("total: " + total);

        System.out.println();
        System.out.println();

        try {
            System.out.println(calculator.calculateAnswer(total));
            System.out.println(calculator.getAnswer(string));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
