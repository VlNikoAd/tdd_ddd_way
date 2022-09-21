import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreditCalculatorTest {

    public static CreditCalculator creditCalculator;
    public static int amountOfCredit;
    public static int monthRate;
    public static int termCredit;


    @BeforeEach
    void setUp() {
         creditCalculator = new CreditCalculator();
         amountOfCredit = 1_000_000;    //сумма кредита
         monthRate = 3;  //срок кредита
         termCredit = 15;   //ставка банка
    }

    @Test
    @DisplayName("Рассчет месячного платежа")
    void calculatingMonthPayment() {
        int expected = 40_277;
        int actual = creditCalculator.MonthPayment(amountOfCredit,
                monthRate, termCredit);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Рассчет общей суммы к возврату в банк")
    void calculatingTotalAmountCredit() {
        int expected = 1_450_000;
        int actual = creditCalculator.TotalAmountCredit(amountOfCredit,
                monthRate, termCredit);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Рассчет переплаты за весь период")
    void calculatingOverpayment() {
        int expected = 450_000;
        int actual = creditCalculator.Overpayment(amountOfCredit,
                monthRate, termCredit);

        Assertions.assertEquals(expected, actual);
    }
}
