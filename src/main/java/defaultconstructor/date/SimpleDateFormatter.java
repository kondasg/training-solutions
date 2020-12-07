package defaultconstructor.date;

public class SimpleDateFormatter {

    public SimpleDateFormatter() {

    }

    public String formatDateString(SimpleDate simpleDate) {
        return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if (countryCode == CountryCode.EN) {
            return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
        }
        if (countryCode == CountryCode.US) {
            return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
        }
        return formatDateString(simpleDate);
    }
}
