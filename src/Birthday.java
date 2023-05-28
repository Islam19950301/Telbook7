public class Birthday extends PersonalInfo {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws OperationException {
        if (month==1 || month==3) {
            if (day > 0 && day <= 31) {
                this.day = day;
            } else {
                throw new OperationException("day value is incorrect, should be less then 31");
            }
        } else if (month==2) {
            if (day > 0 && day < 28) {
                this.day = day;
            } {
                throw new OperationException("day value is incorrect, should be less then 28");
            }
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws OperationException {
        if (month > 0 && month < 13) {
            this.month = month;
        } else {
            throw new OperationException("month should be between 1 and 12");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws OperationException {
        if (year > 0) {
            this.year = year;
        } else {
            throw new OperationException("year should be positive number");
        }
    }

    @Override
    public String getPersonInfoAsString() {
        return "Birthday/" + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}
