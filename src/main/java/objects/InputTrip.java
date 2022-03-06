package objects;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputTrip {
    @CsvBindByName(column = "ID")
    private Long id;

    @CsvDate(value = "dd-MM-yyyy HH:mm:ss")
    @CsvBindByName(column = "DateTimeUTC")
    private Date dateTimeUtc;

    @CsvBindByName(column = "TapType")
    private String tapType;

    @CsvBindByName(column = "StopId")
    private String stopId;

    @CsvBindByName(column = "CompanyId")
    private String companyId;

    @CsvBindByName(column = "BusID")
    private String busId;

    @CsvBindByName(column = "PAN")
    private Long pan;

    public String getTapType() {
        return tapType;
    }

    public String getStopId() {
        return stopId;
    }

    public Long getPan() {
        return pan;
    }

    public String getBusId() {
        return busId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Date getDateTimeUtc() {
        return dateTimeUtc;
    }

    public Long getId() {
        return id;
    }

    public void setTapType(String tapType) {
        this.tapType = tapType;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public void setPan(Long pan) {
        this.pan = pan;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setDateTimeUtc(Date dateTimeUtc) {
        this.dateTimeUtc = dateTimeUtc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return id + "," + dateFormat.format(dateTimeUtc) + "," + tapType + "," + stopId + "," + companyId + "," + busId + "," + pan;
    }

}
