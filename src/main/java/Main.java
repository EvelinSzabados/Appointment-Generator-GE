import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        AppointmentGenerator appointmentGenerator = new AppointmentGenerator();
        Scanner in = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("Number of days to book appointments: ");
                String input = in.next();
                appointmentGenerator.createAppointment(Integer.parseInt(input));

                break;
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, try again!");
            }
        }

        System.out.println("Done!");
        in.close();

    }

}
