package Behavioral_Pattern.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // 这里的写法是传入了subject来注册this，也可以从外部注册
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
}
