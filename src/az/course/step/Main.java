package az.course.step;

import com.company.DbConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DbConnection.getConnection();
            if (connection == null) {
                System.out.println("Connection is failed.");
            } else {
                System.out.println("Connection is success.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
