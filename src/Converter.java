public class Converter {
    int distance = 75;
    int kilocalories = 1000;

    int convertToKm(int steps) {

        return steps * distance;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * kilocalories;
    }
}
