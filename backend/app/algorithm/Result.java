package algorithm;

public class Result {

    private String firstFactor;

    private String secondFactor;

    private String period;

    private String basis;

    private String time;

    private ResultStatus resultStatus;

    private int parallelNumber;

    public String getFirstFactor() {
        return firstFactor;
    }

    public void setFirstFactor(String firstFactor) {
        this.firstFactor = firstFactor;
    }

    public String getSecondFactor() {
        return secondFactor;
    }

    public void setSecondFactor(String secondFactor) {
        this.secondFactor = secondFactor;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public int getParallelNumber() {
        return parallelNumber;
    }

    public void setParallelNumber(int parallelNumber) {
        this.parallelNumber = parallelNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
