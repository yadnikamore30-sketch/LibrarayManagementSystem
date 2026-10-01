package com.library.model;

public class Staff {
        private int staff_id;
        private String name;
        private String username;
        private String password;
        private String role;

        public Staff(int staff_id, String name, String username, String password, String role) {
                this.staff_id = staff_id;
                this.name = name;
                this.username = username;
                this.password = password;
                this.role = role;
        }

        public int getStaff_id() {
                return staff_id;
        }

        public void setStaff_id(int staff_id) {
                this.staff_id = staff_id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        @Override
        public String toString() {
                return "Staff{" +
                        "staff_id=" + staff_id +
                        ", name='" + name + '\'' +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", role='" + role + '\'' +
                        '}';
        }
}

