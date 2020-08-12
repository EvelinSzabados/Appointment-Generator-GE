import java.sql.*;
import java.util.Date;

public class WriteToDatabase {

    public static void writeAppointmentToDatabase(String[] names, Date date) throws SQLException {
        Connection conn = getConnection();
        String query = "INSERT INTO scheduled_patient (id,first_name,last_name,exam_datetime)" +
                "VALUES(DEFAULT,?,?,?);";

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, names[0]);
        st.setString(2, names[1]);
        st.setTimestamp(3, new java.sql.Timestamp(date.getTime()));

        st.executeUpdate();
        st.close();

    }
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost/appointments", "evelin", "password");
    }
}
