import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

public class EmojiMoodResponder {

    // Store all moods for summary
    private static final List<String> moodHistory = new ArrayList<>();

    // Method to return greeting based on current time
    public static String getTimeGreeting() {
        int hour = LocalTime.now().getHour();
        if (hour < 12) {
            return "Good morning! ";
        } else if (hour < 18) {
            return "Good afternoon! ";
        } else {
            return "Good evening! ";
        }
    }

    // Method to handle mood response
    public static void respondToMood(String mood) {
        mood = mood.toLowerCase();
        String greeting = getTimeGreeting();
        String response;

        if (mood.contains("happy")) {
            response = greeting + "You seem cheerful! 😀";
            moodHistory.add("happy 😀");
        } else if (mood.contains("sad")) {
            response = greeting + "Cheer up! Here’s a virtual hug 🤗";
            moodHistory.add("sad 🤗");
        } else if (mood.contains("angry")) {
            response = greeting + "Take a deep breath 😡";
            moodHistory.add("angry 😡");
        } else if (mood.contains("tired")) {
            response = greeting + "Rest well 😴";
            moodHistory.add("tired 😴");
        } else if (mood.contains("excited")) {
            response = greeting + "Let’s celebrate! 🎉";
            moodHistory.add("excited 🎉");
        } else {
            response = greeting + "Hmm, I don’t recognize that mood 🤔";
            moodHistory.add("unknown 🤔");
        }

        System.out.println(response);
    }

    // Method to print summary
    public static void printSummary() {
        if (moodHistory.isEmpty()) {
            System.out.println("No moods recorded yet.");
        } else {
            System.out.println("\n--- Mood Summary ---");
            for (int i = 0; i < moodHistory.size(); i++) {
                System.out.println((i + 1) + ". " + moodHistory.get(i));
            }
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to Emoji Mood Responder!");
        System.out.println("Type your mood, 'summary' to view past moods, or 'exit' to quit.");

        while (true) {
            System.out.print("\nHow are you feeling? ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! 👋");
                break;
            } else if (input.equalsIgnoreCase("summary")) {
                printSummary();
            } else {
                respondToMood(input);
            }
        }

        scanner.close();
    }
}
