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

        String string = "((2*2+5)+5+(4)-3+(16/4)+9)";

        String subRes = "2 2 * 5 + 5 + 4 ! + 3 - 16 4 / + 9 +";
        System.out.println(string);
        System.out.println(subRes);

        String polish = calculator.convert(string);
        System.out.println(polish);

        String[] polishArr = polish.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = polishArr.length - 1; i >=0; i--) {
            builder.append(polishArr[i]);
            builder.append(" ");
        }

        System.out.println(builder.toString());

        String total = calculator.reverseReplace(builder.toString());

        System.out.println(total);

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
