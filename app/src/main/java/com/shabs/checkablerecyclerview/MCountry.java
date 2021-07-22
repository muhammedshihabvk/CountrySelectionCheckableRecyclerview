package com.shabs.checkablerecyclerview;

public class MCountry {
    String countryId;
    String countryName;
    String countryFlag;
    boolean isChecked;

    public MCountry(String countryId, String countryName, String countryFlag, boolean isChecked) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryFlag = countryFlag;
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "MCountry{" + "countryId='" + countryId + '\'' + ", countryName='" + countryName + '\'' + ", countryFlag='" + countryFlag + '\'' + ", isChecked=" + isChecked + '}';
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
