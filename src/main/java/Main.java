import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AppointmentGenerator appointmentGenerator = new AppointmentGenerator();

        Scanner in = new Scanner(System.in);
        System.out.println("Number of days to book appointments: ");
        appointmentGenerator.createAppointment(in.nextInt());
        in.close();
        appointmentGenerator.listAppointments();
    }

}
