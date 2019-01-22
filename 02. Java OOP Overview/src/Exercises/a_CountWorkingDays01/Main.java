package Exercises.a_CountWorkingDays01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String firstDate = bf.readLine();
        String secondDate = bf.readLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int workingDays = 0;

        LocalDate[] holidays = new LocalDate[]
                {
                       LocalDate.of(2016,1,1),
                       LocalDate.of(2016,3,3),
                       LocalDate.of(2016,5,1),
                       LocalDate.of(2016,5,6),
                       LocalDate.of(2016,5,24),
                       LocalDate.of(2016,9,6),
                       LocalDate.of(2016,9,22),
                       LocalDate.of(2016,11,1),
                       LocalDate.of(2016,12,24),
                       LocalDate.of(2016,12,25),
                       LocalDate.of(2016,12,26)
                };
        LocalDate startDate = LocalDate.from(formatter.parse(firstDate));
        LocalDate endDate = LocalDate.from(formatter.parse(secondDate));

        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date= date.plusDays(1)) {
            LocalDate currentDate = LocalDate.of(2016,date.getMonth(),date.getDayOfMonth());

            if(date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY
                && !Arrays.asList(holidays).contains(currentDate))
            {
                workingDays++;
            }
        }
        System.out.println(workingDays);
    }
}
