package com.avaliacao.crud.avaliacao.controller;

import com.avaliacao.crud.avaliacao.dto.TransferRequestDTO;
import com.avaliacao.crud.avaliacao.model.Transfer;
import com.avaliacao.crud.avaliacao.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public List<Transfer> listAll(){
        System.out.println("Listando todas as transferências");
        return transferService.listAllTransfers();
    }

    @PostMapping
    public Transfer addTransfer(@RequestBody TransferRequestDTO TransferRequestDTO){
        System.out.println("Iniciando inclusão de nova transferência");
        return transferService.addTransfer(TransferRequestDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editTransfer(@PathVariable Long id, @RequestBody TransferRequestDTO TransferRequestDTO){
        System.out.println("Iniciando alteração da transferência id: " + id);

        try {
            transferService.editTransfer(id, TransferRequestDTO);
            return ResponseEntity.ok("Transferência alterada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTransfer(@PathVariable Long id){
        System.out.println("Iniciando remoção da transferência id: " + id);

        try {
            transferService.deleteTransfer(id);
            return ResponseEntity.ok("Transferência removida com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
