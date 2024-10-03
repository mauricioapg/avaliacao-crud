package com.avaliacao.crud.avaliacao.dto;

public class TransferRequestDTO {

    private int originAccount;
    private int destinyAccount;
    private Double transferValue;
    private String transferDate;
    private String scheduleDate;

    public int getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(int originAccount) {
        this.originAccount = originAccount;
    }

    public int getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(int destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
