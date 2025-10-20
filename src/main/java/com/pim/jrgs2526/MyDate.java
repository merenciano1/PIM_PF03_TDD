package com.pim.jrgs2526;

public class MyDate {

    private int day;
    private Months month;
    private int year;

    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";

    public MyDate() {}

    public MyDate(int day, Months month, int year) {
        if(checkValidity(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
            return;
        }
        throw new IllegalArgumentException(ERR_INVALID_DATE);
    }

    public void setMonth(Months month) {
        if(checkValidity(day, month, year)){
            this.month = month;
            return;
        }
        throw new IllegalArgumentException(ERR_INVALID_MONTH);
    }

    public void setYear(int year) {
        if(checkValidity(day, month, year)){
            this.year = year;
            return;
        }
        throw new IllegalArgumentException(ERR_INVALID_YEAR);
    }
    public void setDay(int day) {
        if(checkValidity(day, month, year)){
            this.day = day;
            return;
        }
        throw new IllegalArgumentException(ERR_INVALID_DAY);
    }

    public boolean checkValidity(int day, Months month, int year) {
        if(day >= 32 || day <= 0 || month == null || year < 0){
            return false;
        }
        int maxDay;
        switch (month) {
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                maxDay = 30;
                break;
            case FEBRUARY:
                if (isLeapYear(year))
                    maxDay = 29;
                else
                    maxDay = 28;
                break;
            default:
                maxDay = 31;
        }
        return day <= maxDay;
    }

    public boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }
}
