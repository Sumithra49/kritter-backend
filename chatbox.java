import java.util.*;

public class Chatbot {
    
    // Define a class for question-answer pairs
    static class QA {
        String question;
        String answer;
        
        public QA(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    // Function to find the closest matching question and return its answer
    public static String getClosestAnswer(List<QA> qaPairs, String userQuestion) {
        String bestAnswer = "Sorry, I don't understand the question.";
        int maxMatchCount = 0;

        // Tokenize user input question
        Set<String> userQuestionWords = new HashSet<>(Arrays.asList(normalize(userQuestion).split(" ")));

        // Compare each predefined question with the user question
        for (QA qa : qaPairs) {
            Set<String> predefinedQuestionWords = new HashSet<>(Arrays.asList(normalize(qa.question).split(" ")));
            // Find the intersection (common words)
            predefinedQuestionWords.retainAll(userQuestionWords);

            // Track the best match (highest word overlap)
            if (predefinedQuestionWords.size() > maxMatchCount) {
                maxMatchCount = predefinedQuestionWords.size();
                bestAnswer = qa.answer;
            }
        }
        
        return bestAnswer;
    }

    // Helper function to normalize strings (remove punctuation and convert to lowercase)
    private static String normalize(String text) {
        return text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").trim();
    }

    public static void main(String[] args) {
        // Define question-answer pairs
        List<QA> qaPairs = Arrays.asList(
            new QA("What is your name?", "My name is Chatbot."),
            new QA("How can I help you?", "I can assist you with your queries."),
            new QA("What is the weather today?", "The weather is sunny.")
        );

        // Example input
        String userQuestion = "What's the weather like today?";

        // Get and print the closest matching answer
        String answer = getClosestAnswer(qaPairs, userQuestion);
        System.out.println(answer);  // Output: "The weather is sunny."
    }
}
