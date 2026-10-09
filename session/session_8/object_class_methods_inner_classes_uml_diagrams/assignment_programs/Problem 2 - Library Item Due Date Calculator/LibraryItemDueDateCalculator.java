import java.time.LocalDate;

abstract class LibraryItem {
    String title;
    public LibraryItem(String title) { this.title = title; }
    abstract int getBorrowingPeriod();
    public String getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingPeriod()).toString();
    }
}
class Book extends LibraryItem {
    public Book(String title) { super(title); }
    int getBorrowingPeriod() { return 14; }
}
class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    int getBorrowingPeriod() { return 7; }
}
class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    int getBorrowingPeriod() { return 3; }
}
public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("1984"),
            new DVD("The Matrix"),
            new Magazine("Forbes Issue 500")
        };
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate(currentDate));
        }
    }
}
