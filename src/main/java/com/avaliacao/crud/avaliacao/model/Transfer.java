package com.avaliacao.crud.avaliacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int originAccount;
    private int destinyAccount;
    private Double transferValue;
    private String transferTax;
    private LocalDateTime transferDate;
    private LocalDateTime scheduleDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTransferTax() {
        return transferTax;
    }

    public void setTransferTax(String transferTax) {
        this.transferTax = transferTax;
    }

    public LocalDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateTime transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDateTime scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
