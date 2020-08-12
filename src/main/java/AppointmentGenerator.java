import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AppointmentGenerator {
    private Calendar calendar = new GregorianCalendar();
    private Calendar appointmentsCalendar = calendar;
    private List<String> appointments = new ArrayList<String>();

    public AppointmentGenerator(){
        //Appointments can only be booked from tomorrow
        calendar.add(Calendar.DAY_OF_MONTH,1);
    }
    public void createAppointment(int numOfDays) {

        for (int day = 1; day < numOfDays + 1; day++) {
            resetCalendar();

            for (int hour = 1; hour <= 14; hour++) {
                int numOfPersons = 4;
                if(hour == 14){
                    numOfPersons = 1;
                }
                createAppointmentForHour(numOfPersons);
                changeHours();

            }
            incrementDay();
        }
    }

    public void listAppointments(){
        for(String s: appointments){
            System.out.println(s);
        }
    }

    private void resetCalendar() {
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }
    private void resetHoursForAppointments(){
        appointmentsCalendar.set(Calendar.MINUTE, 0);
        appointmentsCalendar.set(Calendar.SECOND, 0);
        appointmentsCalendar.set(Calendar.MILLISECOND, 0);
    }

    private void changeHours() {
        calendar.add(Calendar.HOUR, 1);
    }

    private void incrementDay() {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    private void createAppointmentForHour(int numOfPersons) {

        if(numOfPersons > 0){
            appointments.add(NameGenerator.generateName()[0] + " " + appointmentsCalendar.getTime());
            if(numOfPersons > 1){
                for(int i = 1; i < numOfPersons;i++){
                    appointmentsCalendar.add(Calendar.MINUTE,60/numOfPersons);
                    appointments.add(NameGenerator.generateName()[0] + " " + appointmentsCalendar.getTime());
                }
                resetHoursForAppointments();
            }
        }
    }
}
