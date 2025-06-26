interface Library {
    
    boolean validateUser(String id);
    void userRegistration(String name,String id);
    void showBooks();
    boolean issueBook(String bookId,String userId);
    void returnBook(String bookId,String userId);
    void addBook(Book book);

}
