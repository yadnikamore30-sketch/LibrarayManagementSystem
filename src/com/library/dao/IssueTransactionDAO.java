package com.library.dao;
import com.library.model.IssueTransaction;
import java.sql.Date;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueTransactionDAO {
    public boolean issueBook(IssueTransaction transaction) {

        String sql =
                "INSERT INTO issue_transaction(book_id, reader_id, issue_date, return_date, status) VALUES(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, transaction.getBook_id());
            ps.setInt(2, transaction.getReader_id());
            ps.setDate(3, transaction.getIssue_Date());
            ps.setDate(4, transaction.getReturn_Date());
            ps.setString(5, transaction.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("SQL Error : " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
    public void displayTransactions() {
        String sql = "SELECT * FROM issue_transaction";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("transaction_id") + " | " +
                                rs.getInt("book_id") + " | " +
                                rs.getInt("reader_id") + " | " +
                                rs.getDate("issue_date") + " | " +
                                rs.getDate("return_date") + " | " +
                                rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean returnBook(int transactionId) {

        String sql =
                "UPDATE issue_transaction SET status='Returned' " +
                        "WHERE transaction_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, transactionId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public static void main(String[] args) {
        IssueTransactionDAO dao = new IssueTransactionDAO();

        IssueTransaction transaction =
                new IssueTransaction(
                        0,
                        3,
                        2,
                        java.sql.Date.valueOf("2026-09-21"),
                        java.sql.Date.valueOf("2026-10-21"),
                        "Issued"
                );

        boolean result = dao.issueBook(transaction);
        System.out.println("Book Issued: " + result);
        dao.displayTransactions();
        boolean returned = dao.returnBook(8);
        System.out.println("Returned: " + returned);
        dao.displayTransactions();
    }

}


