package expense_tracker1;
import java.util.List;
import java.util.Scanner;

public class Tracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Save to CSV");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addExpense(scanner, expenseManager);
                    break;
                case 2:
                    viewAllExpenses(expenseManager);
                    break;
                case 3:
                    saveToCSV(expenseManager);
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addExpense(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter expense date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        Expense newExpense = new Expense(date, category, amount);
        expenseManager.addExpense(newExpense);

        System.out.println("Expense added successfully!");
    }

    private static void viewAllExpenses(ExpenseManager expenseManager) {
        List<Expense> expenses = expenseManager.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("All Expenses:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private static void saveToCSV(ExpenseManager expenseManager) {
        String filePath = "C:\\Users\\amolp\\eclipse-workspace\\Expense\\src\\Expense\\expense.csv";
        expenseManager.writeexpenseinfo(filePath);
    }
}
