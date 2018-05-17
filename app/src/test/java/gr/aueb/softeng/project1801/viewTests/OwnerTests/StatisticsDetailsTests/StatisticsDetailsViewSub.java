package gr.aueb.softeng.project1801.viewTests.OwnerTests.StatisticsDetailsTests;

import gr.aueb.softeng.project1801.view.Owner.StatisticsDetails.StatisticsDetailsView;

public class StatisticsDetailsViewSub implements StatisticsDetailsView {

    private String destination, departurePoint, departureDate, departureTime, estimatedArrivalTime, busType, driverID, message, value, warning;
    private double statistics;
    private int availableSeats;

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String getDeparturePoint() {
        return departurePoint;
    }

    @Override
    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String getDepartureTime() {
        return departureTime;
    }

    public StatisticsDetailsViewSub(){
        destination = departurePoint = departureDate = departureTime = estimatedArrivalTime = busType = driverID = message = value = warning = "";
        statistics = 0.0;
        availableSeats = 30;
     //   value = "2018/06/30";
    }



    @Override
    public void setDestination(String destination) {
        this.destination = destination;

    }

    @Override
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;

    }

    @Override
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    @Override
    public void setBusType(String busType) {
        this.busType = busType;

    }

    @Override
    public void setDriverID(String driver) {
        this.driverID = driver;
    }

    @Override
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public void setStatistic(double statistic) {
        this.statistics = statistic;
    }

    @Override
    public void showToast(String value) {
        this.value = value;
    }

    @Override
    public void setActivityName(String value) {
        this.value = value;
    }

    @Override
    public void ClickDeleteButton(String warning) {
        this.warning = warning;
    }

    @Override
    public void delete(String message) {
        this.message = message;
    }

    public String getToast(){
        return value;
    }

    public String getDeleteMessage()
    {
        return message;
    }
}
