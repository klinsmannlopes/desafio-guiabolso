package com.guiabolso.MockTransaction.services.mock;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.helpers.DateHelper;
import com.guiabolso.MockTransaction.helpers.mocks.MockHelpers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        List<TransactionOutputDTO> transactionOutputDTOList = new ArrayList<>();


        for (int i = 0; i <= transactions; i++) {
            TransactionOutputDTO transactionOutputDTO = new TransactionOutputDTO();
            int randomMonth = randomMonthTransactions.nextInt((12 - (Integer.parseInt(month) -1 )) + 1) + (Integer.parseInt(month) -1 );

            transactionOutputDTO.setDescricao(MockHelpers.randomAlhaNumeric(randomNumberDescription.nextInt((60 - 10) + 1) + 10, generateDescription));
            transactionOutputDTO.setData(MockHelpers.randomDateLong(randomMonth ,year, month ,generateDayTransaction.nextInt(30)));
            transactionOutputDTO.setValor(generateValue.nextInt(9999999));
            comparatorTransactionsDuplicated(transactionOutputDTOList, transactionOutputDTO);
            transactionOutputDTOList.add(transactionOutputDTO);
        }

        makeDuplicated(transactionOutputDTOList, year, month);

        return transactionOutputDTOList;

    }

    private void comparatorTransactionsDuplicated(List<TransactionOutputDTO> transactions, TransactionOutputDTO transaction) {

        transactions.forEach(transactionOutputDTO -> {
            if (transactionOutputDTO.equals(transaction)) {
                transaction.setDuplicated(true);
            }
        });

    }

    private void makeDuplicated(List<TransactionOutputDTO> transactions, String year, String month) {

        List<Integer> listMonthTransactions = new ArrayList<>();
        List<Integer> listMonths = new ArrayList<>();

        transactions.stream().forEach(transactionOutputDTO -> {
            LocalDateTime date = null;
            date = DateHelper.longToLocalDateTime(transactionOutputDTO);
            listMonthTransactions.add(date.getMonth().getValue());
        });

        for(int i = 1; i <= 12; i++) {
            int countMonth = i;
            listMonthTransactions.forEach(integer -> {
                if (integer == countMonth && !listMonths.contains(countMonth)) {
                    listMonths.add(integer);
                }
            });
        }

        if (!listMonths.isEmpty() && listMonths.size() >= 12) {
            createTransactionsDuplicated(transactions, year, month);
        }

    }

    private void createTransactionsDuplicated(List<TransactionOutputDTO> transactions, String year, String month) {

        Long uniqueNumber =  Long.parseLong(year+month);

        Random generateValue = new Random(uniqueNumber);
        Random generateDayTransaction = new Random(uniqueNumber);
        Random generateDescription = new Random(uniqueNumber);
        Random randomNumberDescription = new Random(uniqueNumber);
        Random randomMonthTransactions = new Random(uniqueNumber);


        for (int i = 0; i <= 2; i++) {

            int randomMonth = randomMonthTransactions.nextInt(12);
            int randomDay = generateDayTransaction.nextInt(30);
            int randomValue = generateValue.nextInt(9999999);
            int randomDescription = randomNumberDescription.nextInt((60 - 10) + 1) + 10;

            String description = MockHelpers.randomAlhaNumeric(randomDescription, generateDescription);
            Long dateLong = MockHelpers.randomDateLong(randomMonth ,year, month ,randomDay);

            TransactionOutputDTO transactionOutputDTO = new TransactionOutputDTO();

            transactionOutputDTO.setDescricao(description);
            transactionOutputDTO.setData(dateLong);
            transactionOutputDTO.setValor(randomValue);
            transactions.add(transactionOutputDTO);

            TransactionOutputDTO transactionOutputDTO2 = new TransactionOutputDTO();

            transactionOutputDTO2.setDescricao(description);
            transactionOutputDTO2.setData(dateLong);
            transactionOutputDTO2.setValor(randomValue);
            transactionOutputDTO2.setDuplicated(true);

            transactions.add(transactionOutputDTO2);

        }

    }

}