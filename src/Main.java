import java.util.Scanner;
import java.util.List;
import java.sql.Date;
import com.library.dao.BookDAO;
import com.library.dao.PublisherDAO;
import com.library.dao.ReadersDAO;
import com.library.dao.StaffDAO;
import com.library.dao.IssueTransactionDAO;

import com.library.model.Book;
import com.library.model.Publisher;
import com.library.model.Reader;
import com.library.model.Staff;
import com.library.model.IssueTransaction;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Manage Books");
            System.out.println("2. Manage Publishers");
            System.out.println("3. Manage Readers");
            System.out.println("4. Manage Staff");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Transactions");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            System.out.println("You selected : " + choice);

            switch (choice) {

                case 1:
                    System.out.println("\n===== BOOK MENU =====");
                    System.out.println("1. Add Book");
                    System.out.println("2. View Books");
                    System.out.println("3. Search Book");
                    System.out.println("4. Update Book");
                    System.out.println("5. Delete Book");
                    System.out.println("0. Back");

                    int bookChoice = sc.nextInt();

                    switch (bookChoice) {
                        case 1:
                            sc.nextLine(); // clear buffer

                            System.out.print("Enter Title: ");
                            String title = sc.nextLine();

                            System.out.print("Enter Author: ");
                            String author = sc.nextLine();

                            System.out.print("Enter Category: ");
                            String category = sc.nextLine();

                            System.out.print("Enter Quantity: ");
                            int quantity = sc.nextInt();

                            System.out.println("Enter Publisher ID : ");
                            int publisherid = sc.nextInt();

                            Book book = new Book(
                                    0,
                                    title,
                                    author,
                                    publisherid,
                                    category,
                                    quantity
                            );

                            BookDAO bookDAO = new BookDAO();
                            bookDAO.addBook(book);

                            System.out.println("Book Added Successfully!");
                            break;

                        case 2:

                            System.out.println("View Books");

                            BookDAO viewBookDAO = new BookDAO();

                            List<Book> books = viewBookDAO.getAllBooks();

                            for (Book b : books) {
                                System.out.println("ID: " + b.getBook_id());
                                System.out.println("Title: " + b.getTitle());
                                System.out.println("Author: " + b.getAuthor());
                                System.out.println("Publisher ID: " + b.getPublisher_id());
                                System.out.println("Category: " + b.getCategory());
                                System.out.println("Quantity: " + b.getQuantity());
                                System.out.println("----------------------------");
                            }

                            break;

                        case 3:
                            System.out.print("Enter Book ID: ");
                            int bookId = sc.nextInt();

                            BookDAO searchBookDao = new BookDAO();

                            Book foundBook = searchBookDao.searchBookById(bookId);

                            if (foundBook != null) {
                                System.out.println("Book Found!");
                                System.out.println(foundBook.getTitle());
                                System.out.println(foundBook.getAuthor());
                            } else {
                                System.out.println("Book Not Found!");
                            }

                            break;

                        case 4:
                            System.out.print("Enter Book ID: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Title: ");
                            String newTitle = sc.nextLine();

                            System.out.print("Enter New Author: ");
                            String newAuthor = sc.nextLine();

                            System.out.print("Enter New Publisher ID: ");
                            int newPublisherId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Category: ");
                            String newCategory = sc.nextLine();

                            System.out.print("Enter New Quantity: ");
                            int newQuantity = sc.nextInt();

                            Book updatedBook = new Book(
                                    updateId,
                                    newTitle,
                                    newAuthor,
                                    newPublisherId,
                                    newCategory,
                                    newQuantity
                            );

                            BookDAO updateBookDao = new BookDAO();
                            updateBookDao.updateBook(updatedBook);

                            System.out.println("Book Updated Successfully!");
                            break;

                        case 5:
                            System.out.print("Enter Book ID to Delete: ");
                            int deleteBookId = sc.nextInt();

                            BookDAO deleteBookDAO = new BookDAO();
                            deleteBookDAO.deleteBook(deleteBookId);

                            System.out.println("Book Deleted Successfully!");
                            break;

                        case 0:
                            break;
                    }
                    break;

                case 2:
                    BookDAO bookDAO = new BookDAO();

                    for (Book book : bookDAO.getAllBooks()) {
                        System.out.println(
                                book.getBook_id() + " | " +
                                        book.getTitle() + " | " +
                                        book.getAuthor() + " | " +
                                        book.getCategory() + " | " +
                                        book.getQuantity()
                        );
                    }
                    break;

                case 3:
                    System.out.println("===== READER MODULE =====");
                    System.out.println("1. Add Reader");
                    System.out.println("2. View Readers");
                    System.out.println("3. Search Reader");
                    System.out.println("4. Update Reader");
                    System.out.println("5. Delete Reader");
                    System.out.println("0. Back");

                    System.out.print("Enter choice: ");
                    int readerChoice = sc.nextInt();

                    switch (readerChoice) {

                        case 1:
                            System.out.print("Enter Reader ID: ");
                            int readerId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Reader Name: ");
                            String readerName = sc.nextLine();

                            System.out.print("Enter Phone: ");
                            String phone = sc.nextLine();

                            System.out.print("Enter Email: ");
                            String email = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String address = sc.nextLine();

                            Reader reader = new Reader(
                                    readerId,
                                    readerName,
                                    phone,
                                    email,
                                    address
                            );

                            ReadersDAO readersDAO = new ReadersDAO();

                            boolean result = readersDAO.addReader(reader);

                            if (result) {
                                System.out.println("Reader Added Successfully!");
                            } else {
                                System.out.println("Failed to Add Reader.");
                            }

                            break;

                        case 2:
                            ReadersDAO viewReadersDAO = new ReadersDAO();

                            for (Reader r : viewReadersDAO.getAllReaders()) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + r.getReader_id());
                                System.out.println("Name: " + r.getName());
                                System.out.println("Phone: " + r.getPhone());
                                System.out.println("Email: " + r.getEmail());
                                System.out.println("Address: " + r.getAddress());
                            }

                            break;

                        case 3:

                            System.out.print("Enter Reader ID to search: ");
                            int searchId = sc.nextInt();

                            ReadersDAO searchReadersDAO = new ReadersDAO();

                            Reader foundReader = searchReadersDAO.searchReaderById(searchId);

                            if (foundReader != null) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + foundReader.getReader_id());
                                System.out.println("Name: " + foundReader.getName());
                                System.out.println("Phone: " + foundReader.getPhone());
                                System.out.println("Email: " + foundReader.getEmail());
                                System.out.println("Address: " + foundReader.getAddress());

                            } else {

                                System.out.println("Reader Not Found!");

                            }

                            break;

                        case 4:

                            System.out.print("Enter Reader ID to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Reader Name: ");
                            String updateName = sc.nextLine();

                            System.out.print("Enter New Phone: ");
                            String updatePhone = sc.nextLine();

                            System.out.print("Enter New Email: ");
                            String updateEmail = sc.nextLine();

                            System.out.print("Enter New Address: ");
                            String updateAddress = sc.nextLine();

                            Reader updateReader = new Reader(
                                    updateId,
                                    updateName,
                                    updatePhone,
                                    updateEmail,
                                    updateAddress
                            );

                            ReadersDAO updateReadersDAO = new ReadersDAO();

                            boolean updateResult = updateReadersDAO.updateReader(updateReader);

                            if (updateResult) {
                                System.out.println("Reader Updated Successfully!");
                            } else {
                                System.out.println("Reader Not Found!");
                            }

                            break;

                        case 5:

                            System.out.print("Enter Reader ID to delete: ");
                            int deleteId = sc.nextInt();

                            ReadersDAO deleteReadersDAO = new ReadersDAO();

                            boolean deleteResult = deleteReadersDAO.deleteReader(deleteId);

                            if (deleteResult) {
                                System.out.println("Reader Deleted Successfully!");
                            } else {
                                System.out.println("Reader Not Found!");
                            }

                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid Reader Choice");
                    }

                    break;

                case 4:
                    System.out.println("\n===== STAFF MENU =====");
                    System.out.println("1. Add Staff");
                    System.out.println("2. View Staff");
                    System.out.println("3. Search Staff");
                    System.out.println("4. Update Staff");
                    System.out.println("5. Delete Staff");
                    System.out.println("0. Back");

                    System.out.print("Enter choice: ");
                    int staffChoice = sc.nextInt();

                    switch (staffChoice) {

                        case 1:
                            System.out.print("Enter Staff Name: ");
                            sc.nextLine();
                            String staffName = sc.nextLine();

                            System.out.print("Enter Username: ");
                            String username = sc.nextLine();

                            System.out.print("Enter Password: ");
                            String password = sc.nextLine();

                            System.out.print("Enter Role: ");
                            String role = sc.nextLine();

                            Staff staff = new Staff(
                                    0,
                                    staffName,
                                    username,
                                    password,
                                    role
                            );

                            StaffDAO staffDAO = new StaffDAO();

                            boolean result = staffDAO.addStaff(staff);

                            if (result) {
                                System.out.println("Staff Added Successfully!");
                            } else {
                                System.out.println("Failed to Add Staff.");
                            }

                            break;
                        case 2:

                            StaffDAO viewStaffDAO = new StaffDAO();

                            for (Staff s : viewStaffDAO.getAllStaff()) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + s.getStaff_id());
                                System.out.println("Name: " + s.getName());
                                System.out.println("Username: " + s.getUsername());
                                System.out.println("Password: " + s.getPassword());
                                System.out.println("Role: " + s.getRole());
                            }

                            break;
                        case 3:

                            System.out.print("Enter Staff ID to search: ");
                            int searchStaffId = sc.nextInt();

                            StaffDAO searchStaffDAO = new StaffDAO();

                            Staff foundStaff = searchStaffDAO.searchStaffById(searchStaffId);

                            if (foundStaff != null) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + foundStaff.getStaff_id());
                                System.out.println("Name: " + foundStaff.getName());
                                System.out.println("Username: " + foundStaff.getUsername());
                                System.out.println("Password: " + foundStaff.getPassword());
                                System.out.println("Role: " + foundStaff.getRole());

                            } else {
                                System.out.println("Staff Not Found!");
                            }

                            break;
                        case 4:

                            System.out.print("Enter Staff ID to update: ");
                            int updateStaffId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Staff Name: ");
                            String updateStaffName = sc.nextLine();

                            System.out.print("Enter New Username: ");
                            String updateUsername = sc.nextLine();

                            System.out.print("Enter New Password: ");
                            String updatePassword = sc.nextLine();

                            System.out.print("Enter New Role: ");
                            String updateRole = sc.nextLine();

                            Staff updateStaff = new Staff(
                                    updateStaffId,
                                    updateStaffName,
                                    updateUsername,
                                    updatePassword,
                                    updateRole
                            );

                            StaffDAO updateStaffDAO = new StaffDAO();

                            boolean updateStaffResult = updateStaffDAO.updateStaff(updateStaff);

                            if (updateStaffResult) {
                                System.out.println("Staff Updated Successfully!");
                            } else {
                                System.out.println("Staff Not Found!");
                            }

                            break;
                        case 5:

                            System.out.print("Enter Staff ID to delete: ");
                            int deleteStaffId = sc.nextInt();

                            StaffDAO deleteStaffDAO = new StaffDAO();

                            boolean deleteStaffResult = deleteStaffDAO.deleteStaff(deleteStaffId);

                            if (deleteStaffResult) {
                                System.out.println("Staff Deleted Successfully!");
                            } else {
                                System.out.println("Staff Not Found!");
                            }

                            break;

                        case 0:
                            break;

                        default:
                            System.out.println("Invalid Staff Choice");
                    }

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter Reader ID: ");
                    int issueReaderId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Issue Date (YYYY-MM-DD): ");
                    String issueDateInput = sc.nextLine();

                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    String returnDateInput = sc.nextLine();

                    Date issueDate = Date.valueOf(issueDateInput);
                    Date returnDate = Date.valueOf(returnDateInput);

                    IssueTransaction transaction = new IssueTransaction(
                            0,
                            issueBookId,
                            issueReaderId,
                            issueDate,
                            returnDate,
                            "Issued"
                    );

                    IssueTransactionDAO transactionDAO = new IssueTransactionDAO();

                    boolean issueResult = transactionDAO.issueBook(transaction);

                    if (issueResult) {
                        System.out.println("Book Issued Successfully!");
                    } else {
                        System.out.println("Failed to Issue Book.");
                    }

                    break;

                case 6:
                    System.out.print("Enter Transaction ID to return: ");
                    int returnTransactionId = sc.nextInt();

                    IssueTransactionDAO returnTransactionDAO = new IssueTransactionDAO();

                    boolean returnResult = returnTransactionDAO.returnBook(returnTransactionId);

                    if (returnResult) {
                        System.out.println("Book Returned Successfully!");
                    } else {
                        System.out.println("Transaction Not Found!");
                    }

                    break;

                case 7:

                    IssueTransactionDAO viewTransactionDAO = new IssueTransactionDAO();

                    viewTransactionDAO.displayTransactions();

                    break;

                case 8:

                    System.out.println("\n===== PUBLISHER MENU =====");
                    System.out.println("1. Add Publisher");
                    System.out.println("2. View Publishers");
                    System.out.println("3. Search Publisher");
                    System.out.println("4. Update Publisher");
                    System.out.println("5. Delete Publisher");
                    System.out.println("0. Back");

                    System.out.print("Enter choice: ");
                    int publisherChoice = sc.nextInt();

                    switch (publisherChoice) {

                        case 1:

                            sc.nextLine();

                            System.out.print("Enter Publisher Name: ");
                            String publisherName = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String publisherAddress = sc.nextLine();

                            System.out.print("Enter Phone: ");
                            String publisherPhone = sc.nextLine();

                            Publisher publisher = new Publisher(
                                    0,
                                    publisherName,
                                    publisherAddress,
                                    publisherPhone
                            );

                            PublisherDAO publisherDAO = new PublisherDAO();

                            boolean publisherResult = publisherDAO.addPublisher(publisher);

                            if (publisherResult) {
                                System.out.println("Publisher Added Successfully!");
                            } else {
                                System.out.println("Failed to Add Publisher.");
                            }

                            break;

                        case 2:

                            PublisherDAO viewPublisherDAO = new PublisherDAO();

                            for (Publisher p : viewPublisherDAO.getAllPublishers()) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + p.getPublisher_id());
                                System.out.println("Name: " + p.getPublisher_name());
                                System.out.println("Address: " + p.getAddress());
                                System.out.println("Phone: " + p.getPhone());
                            }

                            break;

                        case 3:

                            System.out.print("Enter Publisher ID to search: ");
                            int searchPublisherId = sc.nextInt();

                            PublisherDAO searchPublisherDAO = new PublisherDAO();

                            Publisher foundPublisher =
                                    searchPublisherDAO.searchPublisherById(searchPublisherId);

                            if (foundPublisher != null) {

                                System.out.println("-------------------------");
                                System.out.println("ID: " + foundPublisher.getPublisher_id());
                                System.out.println("Name: " + foundPublisher.getPublisher_name());
                                System.out.println("Address: " + foundPublisher.getAddress());
                                System.out.println("Phone: " + foundPublisher.getPhone());

                            } else {
                                System.out.println("Publisher Not Found!");
                            }

                            break;
                        case 4:

                            System.out.print("Enter Publisher ID to update: ");
                            int updatePublisherId = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter New Publisher Name: ");
                            String updatePublisherName = sc.nextLine();

                            System.out.print("Enter New Address: ");
                            String updatePublisherAddress = sc.nextLine();

                            System.out.print("Enter New Phone: ");
                            String updatePublisherPhone = sc.nextLine();

                            Publisher updatePublisher = new Publisher(
                                    updatePublisherId,
                                    updatePublisherName,
                                    updatePublisherAddress,
                                    updatePublisherPhone
                            );

                            PublisherDAO updatePublisherDAO = new PublisherDAO();

                            boolean updatePublisherResult =
                                    updatePublisherDAO.updatePublisher(updatePublisher);

                            if (updatePublisherResult) {
                                System.out.println("Publisher Updated Successfully!");
                            } else {
                                System.out.println("Publisher Not Found!");
                            }
                            break;

                        case 5:

                            System.out.print("Enter Publisher ID to delete: ");
                            int deletePublisherId = sc.nextInt();

                            PublisherDAO deletePublisherDAO = new PublisherDAO();

                            boolean deletePublisherResult =
                                    deletePublisherDAO.deletePublisher(deletePublisherId);

                            if (deletePublisherResult) {
                                System.out.println("Publisher Deleted Successfully!");
                            } else {
                                System.out.println("Publisher Not Found!");
                            }

                            break;
                        case 0:
                            System.exit(0);

                        default:
                            System.out.println("Invalid Choice");
                    }
            }
        }
    }
}






















