package gr.aueb.softeng.project1801.view.Owner.StatisticsDetails;

public interface StatisticsDetailsView {

    String getDestination();

    String getDeparturePoint();

    String getDepartureDate();

    String getDepartureTime();

    void setDestination(String destination);

    void setDeparturePoint(String departurePoint);

    void setDepartureTime(String departureTime);

    void setDepartureDate(String departureDate);

    void setEstimatedArrivalTime(String estimatedArrivalTime);

    void setBusType(String busType);

    void setDriverID(String driver);

    void setAvailableSeats(int availableSeats);

    void setStatistic(double statistic);

    void showToast(String value);

    void setActivityName(String value);
}
