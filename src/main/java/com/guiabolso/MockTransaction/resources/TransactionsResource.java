package com.guiabolso.MockTransaction.resources;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TransactionsResource {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("{id}/transacoes/{ano}/{mes}")
    @ResponseBody
    public ResponseEntity<List<TransactionOutputDTO>> hello(@PathVariable("id") String id, @PathVariable("ano") String ano, @PathVariable("mes") String mes) throws Exception {

        List<TransactionOutputDTO> transactionOutputDTOList = transactionsService.find(id, ano, mes);

        return new ResponseEntity<List<TransactionOutputDTO>>(transactionOutputDTOList, HttpStatus.OK);
    }

}
