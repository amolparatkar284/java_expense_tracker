package expense_tracker1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public void writeexpenseinfo(String filePath) {
        try (FileWriter fr = new FileWriter(filePath, false);
             BufferedWriter br = new BufferedWriter(fr)) {

            for (Expense expense : expenses) {
                br.write(expense.toCSVString());
                br.newLine();
            }

            System.out.println("Data written to CSV file successfully!");
        } catch (IOException e) {
        }
    }
}
