package com.library.dao;
import com.library.model.Publisher;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

    public class PublisherDAO {

        // Add Publisher
        public boolean addPublisher(Publisher publisher) {
            String query = "INSERT INTO publisher (publisher_name, address, phone) VALUES (?, ?, ?)";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, publisher.getPublisher_name());
                ps.setString(2, publisher.getAddress());
                ps.setString(3, publisher.getPhone());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

        // Search Publisher By ID
        public Publisher searchPublisherById(int id) {
            String query = "SELECT * FROM publisher WHERE publisher_id = ?";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return new Publisher(
                            rs.getInt("publisher_id"),
                            rs.getString("publisher_name"),
                            rs.getString("address"),
                            rs.getString("phone")
                    );
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

            public List<Publisher> getAllPublishers() {

                List<Publisher> publisherList = new ArrayList<>();

                String sql = "SELECT * FROM publisher";

                try (Connection con = DBConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {

                        Publisher publisher = new Publisher(
                                rs.getInt("publisher_id"),
                                rs.getString("publisher_name"),
                                rs.getString("address"),
                                rs.getString("phone")
                        );

                        publisherList.add(publisher);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return publisherList;
            }
        public boolean updatePublisher(Publisher publisher) {

            String sql = "UPDATE publisher SET publisher_name=?, address=?, phone=? WHERE publisher_id=?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, publisher.getPublisher_name());
                ps.setString(2, publisher.getAddress());
                ps.setString(3, publisher.getPhone());
                ps.setInt(4, publisher.getPublisher_id());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }
        public boolean deletePublisher(int publisherId) {

            String sql = "DELETE FROM publisher WHERE publisher_id=?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, publisherId);

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }
        }



