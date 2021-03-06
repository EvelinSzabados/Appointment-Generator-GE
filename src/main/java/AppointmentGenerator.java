import java.sql.SQLException;
import java.util.*;

public class AppointmentGenerator {
    private Calendar calendar = new GregorianCalendar();
    private Calendar appointmentsCalendar = calendar;

    public AppointmentGenerator() {
        //Appointments can only be booked from tomorrow
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    public void createAppointment(int numOfDays) throws SQLException {

        for (int day = 1; day < numOfDays + 1; day++) {
            resetCalendar();

            for (int hour = 1; hour < 14; hour++) {
                int numOfPersons = new Random().nextInt(5);

                createAppointmentForHour(numOfPersons);
                incrementHours();
            }
            incrementDay();
        }
    }


    private void resetCalendar() {
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private void resetHoursForAppointments() {
        appointmentsCalendar.set(Calendar.MINUTE, 0);
        appointmentsCalendar.set(Calendar.SECOND, 0);
        appointmentsCalendar.set(Calendar.MILLISECOND, 0);
    }

    private void incrementHours() {
        calendar.add(Calendar.HOUR, 1);
    }

    private void incrementDay() {
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 3);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 2);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

    }

    private void createAppointmentForHour(int numOfPersons) throws SQLException {

        if (numOfPersons > 0) {
            WriteToDatabase.writeAppointmentToDatabase(NameGenerator.generateName(), appointmentsCalendar.getTime());

            if (numOfPersons > 1) {
                for (int i = 1; i < numOfPersons; i++) {
                    appointmentsCalendar.add(Calendar.MINUTE, 60 / numOfPersons);
                    WriteToDatabase.writeAppointmentToDatabase(NameGenerator.generateName(), appointmentsCalendar.getTime());
                }
                resetHoursForAppointments();
            }
        }
    }
}
