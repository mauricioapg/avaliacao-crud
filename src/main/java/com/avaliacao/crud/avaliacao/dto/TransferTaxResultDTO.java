package com.avaliacao.crud.avaliacao.dto;

public class TransferTaxResultDTO {

    private Double tax;
    private Double finalValue;

    public TransferTaxResultDTO(double tax, double finalValue) {
        this.tax = tax;
        this.finalValue = finalValue;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(Double finalValue) {
        this.finalValue = finalValue;
    }
}
