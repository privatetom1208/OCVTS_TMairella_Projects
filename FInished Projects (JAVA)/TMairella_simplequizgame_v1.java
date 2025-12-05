/*
* NAME: Thomas Mairella
* DATE: // 10/19/25
* VERSION: // v1
* SOURCES USED:
// https://gemini.google.com/ (Corrections, Error Fixes, & Overall Help)
// Slides from class (Used as my base code knowledge.)
* COMMENTS / NOTES:
* - This is a Simple Quiz Game. It makes you select a difficulty, then you play the selected quiz. After you're done, it shows your final score.
    After every run the questions are randomized, making repeatability not an issue.
* - Instructions: Run program, enter your difficulty of choice, and enjoy playing the quiz.
*/

import java.util.Random;
import java.util.Scanner;

public class TMairella_simplequizgame_v1 {
public static void main(String[] args) {

    // Variables
    char difficulty;
    int score = 0;
    final int NUM_QUESTIONS = 10; 
    Random random = new Random();

    // Easy Questions (E) - 10 Questions Required
    String[] easyQuestions = {
        "1. What is 2 + 2?",
        "2. Which color is in the middle of a rainbow?",
        "3. How many sides does a triangle have?",
        "4. What do bees make?",
        "5. The sun is a:",
        "6. Which animal says 'Moo'?",
        "7. Which finger is the longest?",
        "8. What is the opposite of 'hot'?",
        "9. The capital of France is?",
        "10. Which season comes after spring?"
    };
    String[][] easyChoices = {
        {"A. 3", "B. 4", "C. 5", "D. 6"},
        {"A. Blue", "B. Green", "C. Yellow", "D. Red"},
        {"A. Two", "B. Three", "C. Four", "D. Five"},
        {"A. Syrup", "B. Jam", "C. Honey", "D. Cotton"},
        {"A. Planet", "B. Moon", "C. Star", "D. Rock"},
        {"A. Pig", "B. Sheep", "C. Cow", "D. Horse"},
        {"A. Thumb", "B. Index", "C. Middle", "D. Pinky"},
        {"A. Warm", "B. Cold", "C. Cool", "D. Dry"},
        {"A. Berlin", "B. Rome", "C. London", "D. Paris"},
        {"A. Summer", "B. Winter", "C. Fall", "D. Rainy"}
    };
    char[] easyAnswers = {'B', 'B', 'B', 'C', 'C', 'C', 'C', 'B', 'D', 'A'};

    // Medium Questions (M) - 10 Questions Required
    String[] mediumQuestions = {
        "1. What is the square root of 64?",
        "2. Who wrote 'Romeo and Juliet'?",
        "3. What is the largest organ in the human body?",
        "4. Which element has the symbol 'Fe'?",
        "5. In what year did World War II end?",
        "6. Which unit measures electric current?",
        "7. What type of energy comes from the sun?",
        "8. What is the chemical formula for water?",
        "9. Which country gifted the Statue of Liberty to the US?",
        "10. What is a baby kangaroo called?"
    };
    String[][] mediumChoices = {
        {"A. 6", "B. 7", "C. 8", "D. 9"},
        {"A. Dickens", "B. Twain", "C. Shakespeare", "D. Austen"},
        {"A. Heart", "B. Brain", "C. Liver", "D. Skin"},
        {"A. Fluorine", "B. Iron", "C. Gold", "D. Silver"},
        {"A. 1942", "B. 1945", "C. 1950", "D. 1939"},
        {"A. Volt", "B. Watt", "C. Ampere", "D. Ohm"},
        {"A. Wind", "B. Solar", "C. Nuclear", "D. Geothermal"},
        {"A. CO2", "B. O2", "C. H2O", "D. NaCl"},
        {"A. Spain", "B. Germany", "C. France", "D. UK"},
        {"A. Cub", "B. Fawn", "C. Joey", "D. Kit"}
    };
    char[] mediumAnswers = {'C', 'C', 'D', 'B', 'B', 'C', 'B', 'C', 'C', 'C'};

    // Hard Questions (H) - 10 Questions Required
    String[] hardQuestions = {
        "1. What is the chemical symbol for Gold?",
        "2. In which year did the Western Roman Empire fall?",
        "3. Who developed the theory of relativity?",
        "4. What is the speed of light in a vacuum (approx.)?",
        "5. The smallest country in the world is?",
        "6. What does the acronym 'HTML' stand for?",
        "7. Who was the first person to walk on the moon?",
        "8. What is the largest ocean on Earth?",
        "9. What is the primary gas found in the air we breathe?",
        "10. What is the study of mushrooms called?"
    };
    String[][] hardChoices = {
        {"A. Ag", "B. Au", "C. Fe", "D. Hg"},
        {"A. 395 AD", "B. 476 AD", "C. 565 AD", "D. 1453 AD"},
        {"A. Newton", "B. Einstein", "C. Bohr", "D. Galileo"},
        {"A. 100,000 km/s", "B. 300,000 km/s", "C. 500,000 km/s", "D. 1,000,000 km/s"},
        {"A. Monaco", "B. Nauru", "C. Vatican City", "D. San Marino"},
        {"A. Markup Language", "B. Hypertext Markup Language", "C. Text Markup Language", "D. Link Markup Language"},
        {"A. Buzz Aldrin", "B. Neil Armstrong", "C. Michael Collins", "D. Yuri Gagarin"},
        {"A. Atlantic", "B. Indian", "C. Arctic", "D. Pacific"},
        {"A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen", "D. Hydrogen"},
        {"A. Biology", "B. Botany", "C. Mycology", "D. Zoology"}
    };
    char[] hardAnswers = {'B', 'B', 'B', 'B', 'C', 'B', 'B', 'D', 'C', 'C'};
   
    // Arrays for Selected Set & for Questions Answered
    String[] questions;
    String[][] choices;
    char[] answers;
    boolean[] asked = new boolean[NUM_QUESTIONS];

    // User Input for Difficulty
    Scanner input = new Scanner(System.in); 
    System.out.println("Welcome to the SIMPLE QUIZ GAME!");
    System.out.println("Select your difficulty: (E/M/H)");
    difficulty = input.next().toUpperCase().charAt(0);

    // Selecting Questions
    if (difficulty == 'E') {
        System.out.println("\nStarting the Easy Quiz!");
            questions = easyQuestions;
            choices = easyChoices;
            answers = easyAnswers;
    } else if (difficulty == 'M') {
        System.out.println("\nStarting the Medium Quiz!");
            questions = mediumQuestions;
            choices = mediumChoices;
            answers = mediumAnswers;
    } else if (difficulty == 'H') {
        System.out.println("\nStarting Hard Quiz!");
            questions = hardQuestions;
            choices = hardChoices;
            answers = hardAnswers;
    } else {
        System.out.println("Invalid difficulty selection. Please restart the game and choose E, M, or H.");
        input.close(); // Close Scanner Before Exiting
        return;
    }
    // Quiz Logic
    for (int i = 0; i < NUM_QUESTIONS; i++) {
        int qIndex;
        do {
            qIndex = random.nextInt(NUM_QUESTIONS);
        } while (asked[qIndex]);
        asked[qIndex] = true;

        System.out.println("\n" + questions[qIndex]);
        for (String choice : choices[qIndex]) {
            System.out.println(choice);
        }
        System.out.print("Your answer: ");
        char userAnswer = input.next().toUpperCase().charAt(0);

        if (userAnswer == answers[qIndex]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was: " + answers[qIndex]);
        }
    }
    // Final Score
    System.out.println("\nQuiz is Over!");
    System.out.println("Your final score is: " + score + " out of " + NUM_QUESTIONS + ".");
    
    // Close Initial Scanner
    input.close();
  }
}