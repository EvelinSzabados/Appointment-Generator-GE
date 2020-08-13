# Appointment-Generator-GE

Java program with JDBC that generates medical appointments with random names.<br>
Appointments can only be booked on weekdays between 7:00 to 20:00 (last appointment is at 19:45). In every hour, the program assign 0-4 patients evenly and saves the name and time of examination to database. 
<br> <br> At start, user input is needed to tell how many days should be booked in advance. <br> If weekend is within this range, the program puts appointments to the next week. You can not book slots for the current day, only the next day.
