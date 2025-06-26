import java.time.LocalDateTime;

public class Record {
    private User user;
    private Book book;
    private LocalDateTime issueTime;
    private LocalDateTime returnTime;

    public Record(User user, Book book) {
        this.user = user;
        this.book = book;
        this.issueTime = LocalDateTime.now();
    }

    public void returnBook() {
        this.returnTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public void showRecord() {
        System.out.println("User: " + user.getName() + ", Book: " + book.getTitle() +
            ", Issued: " + issueTime +
            (returnTime != null ? ", Returned: " + returnTime : ", Not returned yet"));
    }
}
