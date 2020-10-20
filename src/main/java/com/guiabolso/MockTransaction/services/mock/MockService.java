package com.guiabolso.MockTransaction.services.mock;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.helpers.mocks.MockHelpers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MockService {

    public List<TransactionOutputDTO> makeMock(String id, String year, String month) {

        Long uniqueNumber =  Long.parseLong(id+year+month);

        Random generateValue = new Random(uniqueNumber);
        Random generateNumberTransaction = new Random(uniqueNumber);
        Random generateDayTransaction = new Random(uniqueNumber);
        Random generateDescription = new Random(uniqueNumber);
        Random randomNumberDescription = new Random(uniqueNumber);

        int transactions = generateNumberTransaction.nextInt(50);

        List<TransactionOutputDTO> transactionOutputDTOList = new ArrayList<TransactionOutputDTO>();


        for (int i = 1; i < transactions; i++) {
            TransactionOutputDTO transactionOutputDTO = new TransactionOutputDTO();
            transactionOutputDTO.setDescricao(MockHelpers.randomAlhaNumeric(randomNumberDescription.nextInt((60 - 10) + 1) + 10, generateDescription));
            transactionOutputDTO.setData(MockHelpers.randomDate(year, month, generateDayTransaction.nextInt(30)));
            transactionOutputDTO.setValor(generateValue.nextInt(9999999));
            transactionOutputDTOList.add(transactionOutputDTO);
        }

        return transactionOutputDTOList;

    }

}
