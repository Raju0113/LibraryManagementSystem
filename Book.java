
public class Book {
    private String id;
    private String title;
    private boolean isAvailable = true;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
   
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", isAvailable=" + isAvailable + "]";
    }
    
}
