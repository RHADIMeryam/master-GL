package tp1.exo9.monAgenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendrierUtil {
    public static LocalDate dateSelectionner;

    public static String dateFormatter(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    public static String tempsFormatter(LocalTime time)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }

    public static String moisAnneeDeDate(LocalDate date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public static ArrayList<LocalDate> jourDansMoisList(LocalDate date)
    {
        ArrayList<LocalDate> joursDansMoisList = new ArrayList<>();
        YearMonth anneeMois = YearMonth.from(date);

        int joursDansMois = anneeMois.lengthOfMonth();

        LocalDate debutMois = CalendrierUtil.dateSelectionner.withDayOfMonth(1);
        int joursDeSemaine = debutMois.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
            if(i <= joursDeSemaine || i > joursDansMois + joursDeSemaine)
                joursDansMoisList.add(null);
            else
                joursDansMoisList.add(LocalDate.of(dateSelectionner.getYear(), dateSelectionner.getMonth(),i - joursDeSemaine));
        }
        return  joursDansMoisList;
    }

    public static ArrayList<LocalDate> joursDansSemainList(LocalDate dateSelectionner)
    {
        ArrayList<LocalDate> jours = new ArrayList<>();
        LocalDate current = samediDeDate(dateSelectionner);
        LocalDate findate = current.plusWeeks(1);

        while (current.isBefore(findate))
        {
            jours.add(current);
            current = current.plusDays(1);
        }
        return jours;
    }

    private static LocalDate samediDeDate(LocalDate current)
    {
        LocalDate semainePasser = current.minusWeeks(1);

        while (current.isAfter(semainePasser))
        {
            if(current.getDayOfWeek() == DayOfWeek.SUNDAY)
                return current;

            current = current.minusDays(1);
        }

        return null;
    }
}
