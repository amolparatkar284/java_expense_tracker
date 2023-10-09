package expense_tracker1;
public class Expense {
 private String date;
 private String category;
 private double amount;

 public Expense(String date, String category, double amount) {
     this.date = date;
     this.category = category;
     this.amount = amount;
 }

 public String toString() {
     return "Date: " + date + ", Category: " + category + ", Amount: $" + amount;
 }

 public String toCSVString() {
     return date + "," + category + "," + amount;
 }
}
