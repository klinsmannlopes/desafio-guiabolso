package com.guiabolso.MockTransaction.resources;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class TransactionsResource {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("{id}/transacoes/{ano}/{mes}")
    @ResponseBody
    public ResponseEntity<List<TransactionOutputDTO>> hello(@PathVariable("id") String id, @PathVariable("ano") String year, @PathVariable("mes") String month) throws Exception {

        List<TransactionOutputDTO> transactionOutputDTOList = transactionsService.find(id, year, month);

        final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<List<TransactionOutputDTO>>(transactionOutputDTOList, headers, HttpStatus.OK);
    }

}
