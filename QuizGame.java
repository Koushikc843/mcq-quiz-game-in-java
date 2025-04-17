import java.util.Scanner;

public class QuizGame {

    public static boolean askQuestion(String question, String[] options, int correctIndex, Scanner scanner) {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        while (true) {
            System.out.print("Enter your answer (1-" + options.length + "): ");
            try {
                int userInput = Integer.parseInt(scanner.nextLine());
                if (userInput >= 1 && userInput <= options.length) {
                    return (userInput - 1) == correctIndex;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + options.length + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] questions = {
                {"Who developed Python programming language?",
                        "Wick van Rossam", "Guido van Rossum", "niene stom", "Rasmus"},
                {"Which of the following is correct extension of the Python file?", ".python", ".pl", ".py", ".p"},
                {"Which of the following is used to define a block of code in Python?",
                        "key", "indentation", "brackets", "all of the above"}
        };

        int[] correctAnswers = {1, 2, 1};  // 0-based indices

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            String question = questions[i][0];
            String[] options = new String[4];
            System.arraycopy(questions[i], 1, options, 0, 4);

            boolean isCorrect = askQuestion(question, options, correctAnswers[i], scanner);
            if (isCorrect) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer is: " + options[correctAnswers[i]] + "\n");
            }
        }

        System.out.println("You finished the quiz with a score of " + score + " out of " + questions.length + ".");
        scanner.close();
    }
}
