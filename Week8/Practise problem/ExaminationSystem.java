import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            
            double totalScore = 0.0;
            // Regex to parse QuestionType, QuestionText, CorrectAnswer, StudentAnswer, and Points
            Pattern pattern = Pattern.compile("^([A-Z]+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$");
            
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    String questionType = matcher.group(1);
                    String correctAnswer = matcher.group(3);
                    String studentAnswer = matcher.group(4);
                    int points = Integer.parseInt(matcher.group(5));
                    
                    double score = switch (questionType) {
                        case "MCQ", "TF" -> {
                            // Full points if student answer matches correct answer
                            yield studentAnswer.equalsIgnoreCase(correctAnswer) ? (double) points : 0.0;
                        }
                        case "ESSAY" -> {
                            String[] keywords = correctAnswer.split(",");
                            int matchCount = 0;
                            String studentLower = studentAnswer.toLowerCase();
                            
                            // Check case-insensitive keyword matches
                            for (String kw : keywords) {
                                String trimmedKw = kw.trim().toLowerCase();
                                if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                                    matchCount++;
                                }
                            }
                            
                            // 75% for >=2 keywords, 50% for 1 keyword, 0 otherwise
                            if (matchCount >= 2) {
                                yield points * 0.75;
                            } else if (matchCount == 1) {
                                yield points * 0.50;
                            } else {
                                yield 0.0;
                            }
                        }
                        default -> 0.0;
                    };
                    
                    totalScore += score;
                    // Display each question's score formatted to two decimal places
                    System.out.printf("%s: %.2f%n", questionType, score);
                }
            }
            
            // Display the total score formatted to two decimal places[cite: 7]
            System.out.printf("Total Score: %.2f%n", totalScore);
        }
    }
}
