package calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar
{
    private int year;

    public Calendar(int year)
    {
        this.year = year;
    }

    private int calculateFirstDay(int year, Months month)
    {
        int calYear =  month.equals(Months.JANUARY) || month.equals(Months.FEBRUARY) ? year - 1 : year;
        int d= calYear % 100;
        int c = calYear / 100;
        int sum = (1 + ((13 * month.number - 1) / 5) + d + (d / 4) + (c / 4) - (2 * c)) % 7;
        return sum >= 0 ? sum : sum + 7;
    }

    public void printCalendar()
    {
        System.out.println(space(60) + year);
        printMonths(List.of(Months.JANUARY, Months.FEBRUARY, Months.MARCH, Months.APRIL));
        printMonths(List.of(Months.MAY, Months.JUNE, Months.JULY, Months.AUGUST));
        printMonths(List.of(Months.SEPTEMBER, Months.OCTOBER, Months.NOVEMBER, Months.DECEMBER));
    }

    private void printMonths(List<Months> months)
    {
        List<Integer> firstDays = new ArrayList<>();
        String monthsNames = "";
        for (Months month : months)
        {
            firstDays.add(calculateFirstDay(year, month));
            monthsNames += space(10) + month.name() + space(15);
        }
        System.out.println(monthsNames);
        for (int i = 0; i < months.size(); i++)
        {
            printDays();
        }
        System.out.println();
        for (int i = 0; i < 6; i++)
        {
            String line = "";
            for (int k = 0; k < months.size(); k++)
            {
                for (int j = 1; j <= 7; j++)
                {
                    if ( i * 7 + j <= firstDays.get(k) || i * 7 + j - firstDays.get(k) > (year % 4 == 0 && months.get(k).equals(Months.FEBRUARY)
                    ? months.get(k).days + 1 : months.get(k).days))
                    {
                        line += space(4);
                    }
                    else
                    {
                        int day = i * 7 + j - firstDays.get(k);
                        line += (day < 10 ? space(2) : space(1)) + day + space(1);
                    }
                }
                line += space(4);
            }
            System.out.println(line);
        }

    }

    private void printDays()
    {
        String print = "";
        for (WeekDays value : WeekDays.values())
        {
            print += value.name() + space(1);
        }
        print += space(4);
        System.out.printf(print);
    }

    private String space(int i)
    {
        String result = "";
        while (i > 0)
        {
            result += " ";
            i--;
        }
        return result;
    }
}
