package calendar;

public enum Months
{
    JANUARY(11,31),
    FEBRUARY(12,28),
    MARCH(1,31),
    APRIL(2,30),
    MAY(3,31),
    JUNE(4,30),
    JULY(5,31),
    AUGUST(6,31),
    SEPTEMBER(7,30),
    OCTOBER(8,31),
    NOVEMBER(9,30),
    DECEMBER(10,31);

    public final int number;
    public final int days;

    Months(int number, int days)
    {
        this.number = number;
        this.days = days;
    }
}
