package example.myapplication.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public List<String> calcArray = new ArrayList<>();
    public String input = "";

    //add element to calcArray
    void push(String value) {
        calcArray.add(value);
    }

    boolean validateUserInput(String value) {
        return value == null || !value.chars().allMatch(Character::isDigit) || calcArray.isEmpty()
                || !calcArray.get(calcArray.size() - 1).chars().allMatch(Character::isDigit);
    }

    int calculate() {
        int n1;
        int n2;
        String op;
        int result;
        n1 = Integer.parseInt(calcArray.get(0));
        result = n1;
        do {
            op = calcArray.get(1);
            n2 = Integer.parseInt(calcArray.get(2));
//        validateUserInput();
            switch (op) {
                case "+":
                    result += n2;
                    break;
                case "-":
                    result -= n2;
                    break;
                case "*":
                    result *= n2;
                    break;
                case "/":
                    result /= n2;
                    break;
            }
            if (calcArray.size() >= 2) {
//              System.out.println(calcArray.get(0));
                System.out.println(calcArray.get(1));
                System.out.println(calcArray.get(2));
                calcArray.remove(2);
                calcArray.remove(1);
//              calcArray.remove(0);
            }

        }
        while (calcArray.size() > 1);
        return result;
    }

    //get the element of calcArray
    public String getCalcArray() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < calcArray.size(); i++) {
            result.append(calcArray.get(i));
        }
        return result.toString();
    }
}
