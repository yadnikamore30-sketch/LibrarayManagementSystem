package com.library.dao;
import java.util.List;
import java.util.ArrayList;
import com.library.model.Reader;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadersDAO {
    public boolean addReader(Reader reader) {
        String sql =
                "INSERT INTO readers(name, phone, email, address) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reader.getName());
            ps.setString(2, reader.getPhone());
            ps.setString(3, reader.getEmail());
            ps.setString(4, reader.getAddress());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Reader searchReaderById(int id) {
        String sql = "SELECT * FROM readers WHERE reader_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Reader(
                        rs.getInt("reader_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Reader> getAllReaders() {

        List<Reader> readers = new ArrayList<>();

        String sql = "SELECT * FROM readers";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Reader reader = new Reader(
                        rs.getInt("reader_id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );

                readers.add(reader);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readers;
    }
    public boolean updateReader(Reader reader) {
        String sql =
                "UPDATE readers SET name=?, phone=?, email=?, address=? WHERE reader_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reader.getName());
            ps.setString(2, reader.getPhone());
            ps.setString(3, reader.getEmail());
            ps.setString(4, reader.getAddress());
            ps.setInt(5, reader.getReader_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteReader(int id) {
        String sql = "DELETE FROM readers WHERE reader_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    }

