/*
* NAME: Thomas Mairella
* DATE: // 11/02/25
* VERSION: // v1
* SOURCES USED:
// https://gemini.google.com/ (Corrections, Error Fixes, & Overall Help)
// Slides from class (Used as my base code knowledge.)
// https://www.w3schools.com/java/java_try_catch.asp
// https://www.w3schools.com/jsref/jsref_substring.asp
// https://www.tutorialspoint.com/java/number_parseint.htm
* COMMENTS / NOTES:
* - This is a To-Do List. You can make and edit a task-list to fit your need directly through here. 
You can view the task-list, add/remove tasks, and mark/unmark tasks as complete.
* - Instructions: Run the program, enjoy organizing your life using my To-Do List.
*/

// IMPORT STREAMS // 
import java.io.*; 
import java.util.*; 

public class TMairella_todolist_v1 {
    
    // File Name
    private static final String FILE_NAME = "tasks.txt";
    // ArrayList 
    // Tasks will be stored as: "task description" or "[COMPLETE] task description"
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Load Task 
        try {
            loadTask(); 
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        Scanner sc = new Scanner(System.in); 
        boolean running = true; 

        while (running){
            // MENU 
            // ---> Menu List 
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Undo Complete Mark");
            System.out.println("6. Exit and Save");
            System.out.print("Enter your choice: ");

            // ---> User Input
            String choiceStr = sc.nextLine();
            
            // IF/ELSE or SWITCH for the menu
            try {
                int choice = Integer.parseInt(choiceStr);
                switch (choice) {
                    case 1:
                        viewTask();
                        break;
                    case 2:
                        addTask(sc);
                        break;
                    case 3:
                        removeTask(sc);
                        break;
                    case 4:
                        markTaskComplete(sc);
                        break;
                    case 5:
                        undoMarkComplete(sc);
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Save Task
        try {
            saveTask();
            System.out.println("Tasks saved successfully. Goodbye! ;)");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
        // Close Scanner
        sc.close();
    }// END OF MAIN

    // - - - - - - - - - FUNCTIONS  - - - - - - - - - // 

    // Function 1 - loadTask()    // To load the File
    private static void loadTask() throws IOException {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Scanner fileReader = new Scanner(file)) {
                while (fileReader.hasNextLine()) {
                    tasks.add(fileReader.nextLine());
                }
            }
            System.out.println("Tasks loaded from " + FILE_NAME);
        } else {
            System.out.println("No existing task file found. Starting with an empty list.");
        }
    }
    
    // Function 2 - saveTask()    // To save the File
    private static void saveTask() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        }
    }
    
    // Function 3 - viewTask()    // To view the File
    // Make any task marked as "[COMPLETE] " to have a "✓"
    private static void viewTask() {
        System.out.println("\n--- Current To-Do List ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks. Time to add some! :)");
        } else {
            for (int i = 0; i < tasks.size(); i++)  {
                String task = tasks.get(i);
                String displayTask = task;
                
                // Check if tasks are "[COMPLETE] " and display a "✓"
                if (task.startsWith("[COMPLETE] ")) {
                    displayTask = "✓ - " + task.substring("[COMPLETE] ".length());
                }
                System.out.println((i + 1) + ". " + displayTask);
            }
        }
        System.out.println("--------------------------");
    }

    // Function 4 - addTask()     // To add information to the file
    private static void addTask(Scanner sc) {
        System.out.print("Enter the task to add: ");
        String newTask = sc.nextLine().trim();

        if (!newTask.isEmpty()) {
            tasks.add(newTask);
            System.out.println("Task added: " + newTask);
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    // Function 5 - removeTask()  // To remove information from the file
    private static void removeTask(Scanner sc) {
        viewTask();
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskNumber = Integer.parseInt(sc.nextLine());
            int index = taskNumber - 1;

            if (index >= 0 && index < tasks.size()) {
                String removedTask = tasks.remove(index);
                System.out.println("Task removed: " + removedTask);
            } else {
                System.out.println("Invalid task number. Please enter a number from the list.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    
    // - - - - - - - - - OTHER REQUIREMENTS - - - - - - - - - // 

    // Function 6 - Mark tasks as complete
    private static void markTaskComplete(Scanner sc) {
        viewTask();
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to mark as COMPLETE: ");
        try {
            int taskNumber = Integer.parseInt(sc.nextLine());
            int index = taskNumber - 1;

            if (index >= 0 && index < tasks.size()) {
                String task = tasks.get(index);
                if (!task.startsWith("[COMPLETE] ")) {
                    tasks.set(index, "[COMPLETE] " + task);
                    System.out.println("Task marked complete: " + task);
                } else {
                    System.out.println("Task is already marked complete.");
                }
            } else {
                System.out.println("Invalid task number. Please enter a number from the list.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    
    // Function 7 - Undo Mark tasks as incomplete (removes check mark)
    private static void undoMarkComplete(Scanner sc) {
        viewTask();
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to UNMARK as complete: ");
        try {
            int taskNumber = Integer.parseInt(sc.nextLine());
            int index = taskNumber - 1;

            if (index >= 0 && index < tasks.size()) {
                String task = tasks.get(index);
                if (task.startsWith("[COMPLETE] ")) {
                    String unmarkedTask = task.substring("[COMPLETE] ".length());
                    tasks.set(index, unmarkedTask);
                    System.out.println("Task unmarked: " + unmarkedTask);
                } else {
                    System.out.println("Task is not currently marked complete.");
                }
            } else {
                System.out.println("Invalid task number. Please enter a number from the list.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

}// END OF CLASS