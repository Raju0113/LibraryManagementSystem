import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new LibraryImpl();

        library.addBook(new Book("A11", "Core Java Fundamentals"));
        library.addBook(new Book("A12", "Data base management system"));
        library.addBook(new Book("A13", "Data Structures and Algorithms"));
        library.addBook(new Book("A14", "Spring boot and micro services"));

        System.out.println(
                "==============================================Welcome to Library================================================================");

        while (true) {
                System.out.println(
                        "-------------------------------------------------Main page -------------------------------------------------------------");
                System.out.print("Enter your Id :");
                String userId = sc.next();
                sc.nextLine(); // consume the leftover newline

                if (!library.validateUser(userId)) {
                    System.out.println("You are the new User.Need to register first");
                    System.out.print("Enter your name :");
                    String name = sc.nextLine();
                    System.out.print("Enter your Id :");
                    String id = sc.next();
                    library.userRegistration(name, id);

                } // else {
                while (true) {
                    try {
                        System.out.println("1.Borrowing a Book");
                        System.out.println("2.Returning a Book");

                        System.out.print("Enter your option (1 or 2): ");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                library.showBooks(); // it showing all books

                                while (true) {
                                    try {
                                        System.out.println("Enter Book Id for borrow :");
                                        String borrowBookId = sc.next();

                                        if (library.issueBook(borrowBookId, userId)) { // passing borrowId,userId and
                                                                                       // getting bookId is available or
                                                                                       // not
                                            break;
                                        } else {
                                            System.out.println("Please try a different Book ID.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Enter a Valid option( 1 or 2 )");
                                        sc.nextLine();
                                    }
                                } // TODO calling issue book by passing book id and userId that is entered in the
                                  // begining of the verification
                                break;

                            case 2:
                                System.out.println("Enter your book Id :");
                                String returnBookId = sc.next();
                                sc.nextLine();                                    //clears buffer
                                library.returnBook(returnBookId, userId);
                                break;

                            default:
                                System.out.println("Enter a Valid option( 1 or 2 ).");
                                continue; // it allows us to go back to the while loop if we enter wrong option
                        }
                        break; // exit book operation menu after valid choice
                        // }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Enter valid number");
                        sc.nextLine();
                    }
                }
                System.out.println("Do you want to continew? (yes/no): ");
                String ans = sc.next().toLowerCase();
                if(!ans.equals("yes")){
                    System.out.println("Thank you for using the Library System!");
                    break;
                }

            } 
        }
    }

