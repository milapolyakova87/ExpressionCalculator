import java.util.Scanner;

public class ExpressionCalculator {

    private String expression; // Входное выражение
    private int pos = 0; // Текущая позиция в строке

    public ExpressionCalculator(String expression) {
        // Убираем пробелы и заменяем запятую на точку для единообразия
        this.expression = expression.replaceAll("\\s+", "").replace(",", ".");
    }

    // Метод для вычисления выражения
    public double calculate() {
        double result = parseExpression();
        if (pos < expression.length()) {
            throw new IllegalArgumentException("Некорректное выражение: " + expression.substring(pos));
        }
        return result;
    }

    // Парсинг выражения (сложение и вычитание)
    private double parseExpression() {
        double result = parseTerm();
        while (pos < expression.length()) {
            char operator = expression.charAt(pos);
            if (operator == '+' || operator == '-') {
                pos++;
                double term = parseTerm();
                if (operator == '+') {
                    result += term;
                } else {
                    result -= term;
                }
            } else {
                break;
            }
        }
        return result;
    }

    // Парсинг терма (умножение и деление)
    private double parseTerm() {
        double result = parseFactor();
        while (pos < expression.length()) {
            char operator = expression.charAt(pos);
            if (operator == '*' || operator == '/') {
                pos++;
                double factor = parseFactor();
                if (operator == '*') {
                    result *= factor;
                } else {
                    if (factor == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result /= factor;
                }
            } else {
                break;
            }
        }
        return result;
    }

    // Парсинг фактора (число, унарный минус или выражение в скобках)
    private double parseFactor() {
        if (pos >= expression.length()) {
            throw new IllegalArgumentException("Нужно было ввести что-нибудь =)");
        }

        char currentChar = expression.charAt(pos);

        if (Character.isDigit(currentChar) || currentChar == '.') {
            return parseNumber();
        } else if (currentChar == '(') {
            pos++;
            double result = parseExpression();
            if (pos >= expression.length() || expression.charAt(pos) != ')') {
                throw new IllegalArgumentException("Отсутствует закрывающая скобка");
            }
            pos++;
            return result;
        } else if (currentChar == '-') {
            pos++;
            return -parseFactor();
        } else {
            throw new IllegalArgumentException("Неожиданный символ: " + currentChar);
        }
    }

    // Парсинг числа
    private double parseNumber() {
        int start = pos;
        while (pos < expression.length() && (Character.isDigit(expression.charAt(pos)) || expression.charAt(pos) == '.')) {
            pos++;
        }
        return Double.parseDouble(expression.substring(start, pos));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи математическое выражение. Можно использовать скобки, отрицательные числа и операторы +, -, *, /: ");
        String expression = scanner.nextLine();

        // Проверка на допустимые символы
        if (!expression.matches("[0-9\\+\\-\\*\\/\\(\\)\\.\\,\\s]*")) {
            System.out.println("Ошибка: Выражение содержит недопустимые символы.");
            return;
        }

        ExpressionCalculator calculator = new ExpressionCalculator(expression);
        try {
            double result = calculator.calculate();
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
