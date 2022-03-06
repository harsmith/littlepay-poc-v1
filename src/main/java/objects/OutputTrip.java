package objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputTrip {
    private final Date startDateTimeUtc;
    private final Date stopDateTimeUtc;
    private final Long durationSeconds;
    private final String fromStopId;
    private final String toStopId;
    private final String fareAmount;
    private final String companyId;
    private final String busId;
    private final Long pan;
    private final String status;

    public OutputTrip(Date startDateTimeUtcInput, Date stopDateTimeUtcInput, Long durationSecondsInput,
                      String fromStopIdInput, String toStopIdInput, String fareAmountInput, String companyIdInput,
                      String busIdInput, Long panInput, String statusInput) {
        startDateTimeUtc = startDateTimeUtcInput;
        stopDateTimeUtc = stopDateTimeUtcInput;
        durationSeconds = durationSecondsInput;
        fromStopId = fromStopIdInput;
        toStopId = toStopIdInput;
        fareAmount = fareAmountInput;
        companyId = companyIdInput;
        busId = busIdInput;
        pan = panInput;
        status = statusInput;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(startDateTimeUtc) + "," + dateFormat.format(stopDateTimeUtc) + "," + durationSeconds + "," + fromStopId + "," + toStopId + "," + fareAmount + "," + companyId + "," + busId + "," + pan + "," + status;
    }

    public Date getStartDateTimeUtc() {
        return startDateTimeUtc;
    }

    public Date getStopDateTimeUtc() {
        return stopDateTimeUtc;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
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

    public String getFareAmount() {
        return fareAmount;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public String getStatus() {
        return status;
    }

    public String getToStopId() {
        return toStopId;
    }
}
