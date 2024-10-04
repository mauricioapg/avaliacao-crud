package com.avaliacao.crud.avaliacao.service;

import com.avaliacao.crud.avaliacao.dto.TransferRequestDTO;
import com.avaliacao.crud.avaliacao.dto.TransferTaxResultDTO;
import com.avaliacao.crud.avaliacao.model.Transfer;
import com.avaliacao.crud.avaliacao.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public List<Transfer> listAllTransfers(){
        return transferRepository.findAll();
    }

    public Transfer addTransfer(TransferRequestDTO transferRequestDTO){

        Transfer transfer = new Transfer();

        transfer.setOriginAccount(transferRequestDTO.getOriginAccount());
        transfer.setDestinyAccount(transferRequestDTO.getDestinyAccount());
        transfer.setTransferDate(LocalDateTime.parse(transferRequestDTO.getTransferDate()));
        transfer.setScheduleDate(LocalDateTime.now());

        int day = LocalDateTime.parse(transferRequestDTO.getTransferDate()).getDayOfMonth();
        double tax = calcTaxValue(day, transferRequestDTO.getTransferValue()).getTax();
        double finalValue = transferRequestDTO.getTransferValue() +
                calcTaxValue(day, transferRequestDTO.getTransferValue()).getFinalValue();

        DecimalFormat df = new DecimalFormat("#.00");
        String formattedFinalValue = df.format(finalValue);

        transfer.setTransferTax(tax + "%");
        transfer.setTransferValue(Double.valueOf(formattedFinalValue.replace(',', '.')));

        return transferRepository.save(transfer);
    }

    public void editTransfer(Long id, TransferRequestDTO transferRequestDTO) throws Exception {

        Optional<Transfer> transfer = transferRepository.findById(id);

        if(!transfer.isPresent()){
            throw new Exception("Nenhuma transferência encontrada com esse id");
        }

        transfer.get().setOriginAccount(transferRequestDTO.getOriginAccount());
        transfer.get().setDestinyAccount(transferRequestDTO.getDestinyAccount());
        transfer.get().setTransferValue(transferRequestDTO.getTransferValue());
        transfer.get().setTransferDate(LocalDateTime.parse(transferRequestDTO.getTransferDate()));
        transfer.get().setScheduleDate(LocalDateTime.now());

        int day = LocalDateTime.parse(transferRequestDTO.getTransferDate()).getDayOfMonth();
        double tax = calcTaxValue(day, transferRequestDTO.getTransferValue()).getTax();
        double finalValue = transferRequestDTO.getTransferValue() +
                calcTaxValue(day, transferRequestDTO.getTransferValue()).getFinalValue();

        DecimalFormat df = new DecimalFormat("#.00");
        String formattedFinalValue = df.format(finalValue);

        transfer.get().setTransferTax(tax + "%");
        transfer.get().setTransferValue(Double.valueOf(formattedFinalValue.replace(',', '.')));

        transferRepository.save(transfer.get());
    }

    public void deleteTransfer(Long id) throws Exception {

        Optional<Transfer> transfer = transferRepository.findById(id);

        if(!transfer.isPresent()){
            throw new Exception("Nenhuma transferência encontrada com esse id");
        }

        transferRepository.delete(transfer.get());
    }

    public static TransferTaxResultDTO calcTaxValue(int day, double valueTransfer) {
        double finalValue = 0.0;
        double tax = 0;

        if (day == 0) {
            tax = 2.5;
            finalValue = tax / 100 * valueTransfer + 3.00;
        } else if (day >= 1 && day <= 10) {
            tax = 0.0;
            finalValue = tax;
        } else if (day >= 11 && day <= 20) {
            tax = 8.2;
            finalValue = tax / 100 * valueTransfer;
        } else if (day >= 21 && day <= 30) {
            tax = 6.9;
            finalValue = tax / 100 * valueTransfer;
        } else if (day >= 31 && day <= 40) {
            tax = 4.7;
            finalValue = tax / 100 * valueTransfer;
        } else if (day >= 41 && day <= 50) {
            tax = 1.7;
            finalValue = tax / 100 * valueTransfer;
        }

        return new TransferTaxResultDTO(tax, finalValue);
    }

}
