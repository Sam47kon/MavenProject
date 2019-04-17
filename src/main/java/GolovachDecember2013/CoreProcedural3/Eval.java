package GolovachDecember2013.CoreProcedural3;

import java.util.Objects;

import static java.lang.Character.isDigit;

public class Eval {
    private static int evalGolovach(String expr) {
        if (expr.startsWith("(") && expr.endsWith(")")) {
            return evalGolovach(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && !expr.endsWith(")")) {
            throw new RuntimeException("Если есть ( то должна быть в конце и )");
        } else {
            int pos = 0;
            while (pos < expr.length() - 1) {
                if (isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(0, pos)); // конец может быть другой
                    char operation = expr.charAt(pos);
                    int rightOperand = evalGolovach(expr.substring(pos + 1));
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                    }
                }
            }
        }
        return Integer.valueOf(expr);
    }


    private static int evalMy(String expr1) {
        String expr = removeTwoNearestBrackets(expr1);

        int pos = 0;
        while (pos < expr.length() - 1) {
            if (isDigit(expr.charAt(pos))) {
                pos++;
            } else {
                int leftOperand = Integer.valueOf(expr.substring(0, pos));
                char operation = expr.charAt(pos);
                int rightOperand = evalMy(expr.substring(pos + 1));
                switch (operation) {
                    case '+':
                        return leftOperand + rightOperand;
                    case '-':
                        return leftOperand - rightOperand;
                    case '/':
                        return leftOperand / rightOperand;
                    case '*':
                        return leftOperand * rightOperand;
                }
            }
        }
        return Integer.valueOf(expr);
    }


    private static String removeTwoNearestBrackets(String expr) {
        String tmp;
        if (expr.startsWith("(")) {
            tmp = expr.substring(1);
        } else return expr;

        StringBuilder sb = new StringBuilder(tmp);
        for (int i = 0; i < sb.length(); i++) {
            if (Objects.equals(sb.charAt(i), ')')) {
                sb.deleteCharAt(i);
                break;
            }
        }
        expr = sb.toString();
        return expr;
    }


    public static void main(String[] args) {
        System.out.println(evalGolovach("123"));
        System.out.println(evalGolovach("2*3"));
        System.out.println(evalGolovach("2*3+(1*3)"));
        System.out.println(evalGolovach("1+(5-2*(13/6))"));  // 2
//        System.out.println(evalGolovach("1+(5*2+(13/6))"));  // 12 но решает как 21, т.к. не учитывает приоритет
//        System.out.println(evalGolovach("3*2+(3+1)+2/2-(99-99)")); // не компилируется


        System.out.println("My:");
        System.out.println(evalMy("123"));
        System.out.println(evalMy("2*3"));
        System.out.println(evalMy("2*3+(1*3)"));
        System.out.println(evalMy("1+(5-2*(13/6))"));  // 2

        System.out.println(evalMy("3*2+(3+1)+2/2"));


    }
}
