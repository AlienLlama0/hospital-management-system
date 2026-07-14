package storage;

import java.sql.*;

public class Connect {
    private static final String URL = "jdbc:sqlite:db/db.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        String createPatientSql = """
            CREATE TABLE IF NOT EXISTS patient (
                id INTEGER PRIMARY KEY,
                patient_id  TEXT UNIQUE NOT NULL,
                name TEXT NOT NULL,
                age REAL NOT NULL,
                phone TEXT NOT NULL,
                blood_group TEXT NOT NULL,
                symptom TEXT NOT NULL,
                gender TEXT NOT NULL CHECK (gender IN ('Male', 'Female'))
            )
            """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createPatientSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}