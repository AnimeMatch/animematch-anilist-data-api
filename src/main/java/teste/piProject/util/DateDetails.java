package teste.piProject.util;
import java.time.Year;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.LocalDate;

public class DateDetails {
    public static int anoAtual(){
        Year year = Year.now();
        int currentYear = year.getValue();
        return currentYear;
    }

    public static String estacaoAtual() {
        LocalDate hoje = LocalDate.now();
        Month mesAtual = hoje.getMonth();

        String estacao = "";

        switch (mesAtual) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                estacao = "WINTER";
                break;
            case MARCH:
            case APRIL:
            case MAY:
                estacao = "SPRING";
                break;
            case JUNE:
            case JULY:
            case AUGUST:
                estacao = "SUMMER";
                break;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                estacao = "FALL";
                break;
            default:
                System.out.println("Estação do ano não encontrada");;
        }
        return estacao;
    }
}
