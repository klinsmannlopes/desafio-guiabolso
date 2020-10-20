package com.guiabolso.MockTransaction.services.mock;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.helpers.mocks.MockHelpers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockService {

    public List<TransactionOutputDTO> makeMockTransactions(String id, String year, String month) {

        Long uniqueNumber =  Long.parseLong(id+year+month);

        Random generateValue = new Random(uniqueNumber);
        Random generateNumberTransaction = new Random(uniqueNumber);
        Random generateDayTransaction = new Random(uniqueNumber);
        Random generateDescription = new Random(uniqueNumber);
        Random randomNumberDescription = new Random(uniqueNumber);
        Random randomMonthTransactions = new Random(uniqueNumber);

        int transactions = generateNumberTransaction.nextInt(25);

        List<TransactionOutputDTO> transactionOutputDTOList = new ArrayList<TransactionOutputDTO>();


        for (int i = 0; i <= transactions; i++) {
            TransactionOutputDTO transactionOutputDTO = new TransactionOutputDTO();
            int randomMonth = randomMonthTransactions.nextInt((12 - Integer.parseInt(month)) + 1) + Integer.parseInt(month);
            transactionOutputDTO.setDescricao(MockHelpers.randomAlhaNumeric(randomNumberDescription.nextInt((60 - 10) + 1) + 10, generateDescription));
            //transacoes apenas para o mes passado no endpoint
            //transactionOutputDTO.setData(MockHelpers.randomDate(year, month, generateDayTransaction.nextInt(30)));
            transactionOutputDTO.setData(MockHelpers.randomDateBigMonth(randomMonth ,year, month, generateDayTransaction.nextInt(30)));
            transactionOutputDTO.setValor(generateValue.nextInt(9999999));
            comparatorTransactions(transactionOutputDTOList.get(i-1), transactionOutputDTO, i);
            transactionOutputDTOList.add(transactionOutputDTO);
        }

        return transactionOutputDTOList;

    }

    private void comparatorTransactions(TransactionOutputDTO transaction1, TransactionOutputDTO transaction2, int count) {

        if (count > 0) {
            if (transaction1.equals(transaction2)) {
                transaction2.setDuplicated(true);
            }
        }
    }

}
