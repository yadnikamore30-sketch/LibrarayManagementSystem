package com.library.dao;
import java.util.List;
import java.util.ArrayList;
import com.library.model.Staff;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDAO {
        public boolean addStaff(Staff staff) {

            String sql =
                    "INSERT INTO staff(name, username, password, role) VALUES(?,?,?,?)";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, staff.getName());
                ps.setString(2, staff.getUsername());
                ps.setString(3, staff.getPassword());
                ps.setString(4, staff.getRole());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

    public Staff searchStaffById(int id) {
        String sql = "SELECT * FROM staff WHERE staff_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Staff(
                        rs.getInt("staff_id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean updateStaff(Staff staff) {

        String sql = "UPDATE staff SET name=?, username=?, password=?, role=? WHERE staff_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, staff.getName());
            ps.setString(2, staff.getUsername());
            ps.setString(3, staff.getPassword());
            ps.setString(4, staff.getRole());
            ps.setInt(5, staff.getStaff_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Staff> getAllStaff() {

        List<Staff> staffList = new ArrayList<>();

        String sql = "SELECT * FROM staff";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Staff staff = new Staff(
                        rs.getInt("staff_id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );

                staffList.add(staff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }
    public boolean deleteStaff(int id) {

        String sql = "DELETE FROM staff WHERE staff_id=?";

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




