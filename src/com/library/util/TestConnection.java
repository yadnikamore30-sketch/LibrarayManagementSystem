package com.library.util;
import java.sql.Connection;

public class TestConnection {
        public static void main(String[] args) {
                    if(DBConnection.getConnection() != null) {
                        System.out.println("Connected Successfully!");
                    }
                }
            }

