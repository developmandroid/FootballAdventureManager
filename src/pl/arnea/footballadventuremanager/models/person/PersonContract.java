package pl.arnea.footballadventuremanager.models.person;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class PersonContract {
    private int day;
    private int month;
    private int year;

    //private String birth;

    private DateTime contractEndDate;
    private DateTime todayDate;

    private int contractValue;

    public PersonContract(String contractEndDate, int contractValue) {
        //this.birth = birth;
        day = Integer.parseInt(contractEndDate.substring(0, 2));
        month = Integer.parseInt(contractEndDate.substring(3, 5));
        year = Integer.parseInt(contractEndDate.substring(6, 10));
        this.contractEndDate = new DateTime(year, month, day, 0, 0, 0);

        this.contractValue = contractValue;

    }

    public int calculateContractYears() {
        todayDate = new DateTime();
        Period period = new Period(contractEndDate, todayDate);
        return period.getYears();
    }

    public String toString() {

        DateTimeFormatter fmt = DateTimeFormat.shortDate();
        String str = fmt.print(contractEndDate);


        return str;
    }

    public int getContractValue() {
        return contractValue;
    }

    public void setContractValue(int contractValue) {
        this.contractValue = contractValue;
    }


}
