package pl.arnea.footballadventuremanager.models.person;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class PersonBirth {

    private int day;
    private int month;
    private int year;

    //private String birth;

    private DateTime birthDate;
    private DateTime todayDate;

    public PersonBirth(String birth) {

        //this.birth = birth;
        day = Integer.parseInt(birth.substring(0, 2));
        month = Integer.parseInt(birth.substring(3, 5));
        year = Integer.parseInt(birth.substring(6, 10));
        this.birthDate = new DateTime(year, month, day, 0, 0, 0);

    }

    public int calculateAge() {
        todayDate = new DateTime();
        Period period = new Period(birthDate, todayDate);
        return period.getYears();
    }

    public String toString() {
        DateTimeFormatter fmt = DateTimeFormat.shortDate();
        String str = fmt.print(birthDate);
        return str;
    }


}
