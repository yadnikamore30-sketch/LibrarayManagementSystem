package com.library.dao;
import com.library.model.Book;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public boolean addBook(Book book) {
        String sql = "INSERT INTO books(title, author, publisher_id, category, quantity) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setInt(3, book.getPublisher_id());
            pst.setString(4, book.getCategory());
            pst.setInt(5, book.getQuantity());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("publisher_id"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                );

                books.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book searchBookById(int bookId) {

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, bookId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("publisher_id"),
                        rs.getString("category"),
                        rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateBook(Book book) {

        String sql = "UPDATE books SET title=?, author=?, publisher_id=?, category=?, quantity=? WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, book.getTitle());
            pst.setString(2, book.getAuthor());
            pst.setInt(3, book.getPublisher_id());
            pst.setString(4, book.getCategory());
            pst.setInt(5, book.getQuantity());
            pst.setInt(6, book.getBook_id());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteBook(int bookId) {

        String query = "DELETE FROM books WHERE book_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Deleted Successfully!");
                return true;
            } else {
                System.out.println("Book Not Found!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Cannot delete book. It is being used in transactions.");
            return false;
        }
    }




    public void searchBook(String title) {

        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getString("category")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

