import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryImpl implements Library {

    private Map<String,Book> books = new HashMap<>();
    private Map<String,User> users = new HashMap<>();
    private List<Record> records = new ArrayList<>();

    @Override
    public boolean validateUser(String id) {
        return users.containsKey(id);

    }
     @Override
    public void userRegistration(String name, String id) {
        users.put(id,new User(id, name));
        System.out.println("User Registed Successfully");
        
    }

    @Override
    public void showBooks() {
        System.out.println("====== Books ========");
        for(Book book : books.values()){
            System.out.println(book);
        }
    }

     @Override
    public boolean issueBook(String bookId,String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if(book==null){
            System.out.println("book is not found with Id: "+bookId);
            return false;
        }
        if(user == null){
            System.out.println("user not found with ID: "+userId+".please register first.");
        }

        if(book.isAvailable()){
            book.setAvailable(false);          //if available setting it to false
            Record record = new Record(user, book);         //adding user and book details in the record
            records.add(record);
            System.out.println("Book issued SuccessFully to "+ user.getName()+" : "+book.getTitle());
                return true;

        }else{
            System.out.println("Book is not available right now.");
               return false;
        }
      
    }

    @Override
    public void returnBook(String bookId,String userId) {
        Book book=books.get(bookId); //todo

        if (book == null) { 
        System.out.println("Book with ID " + bookId + " not found.");
        return;
    }

     User user = users.get(userId);   //todo
    if (user == null) {
        System.out.println("User with ID " + userId + " not found.");
        return;
    }

       for(Record record:records){
        if(record.getBook().getId().equals(bookId) &&
           record.getUser().getUserId().equals(userId)&&
           record.getReturnTime()==null){
            book.setAvailable(true);
            record.returnBook();                      //sets returntime 
            System.out.println("Book returned successfully by :"+user.getName());
            return;
           }
       }
       System.out.println("No matching issued record found for return.");
      
    }
    @Override
    public void addBook(Book book) {
       books.put(book.getId(),book);
    }
   
}

