package com.guiabolso.MockTransaction.services;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.helpers.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


@Service
public class TransactionsService {

    private static final String STRINGS = "ABCDEFGHIJKLMNOPQRSTUVWYZ";

    @Autowired
    private DateHelper dateHelper;

    public List<TransactionOutputDTO> find(String id, String ano, String mes) throws Exception {
        try {

            List<TransactionOutputDTO> transactionOutputDTOList = makeMock(id, ano, mes);

            return transactionOutputDTOList;
        } catch (Exception e) {
            throw e;
        }

    }


    public List<TransactionOutputDTO> makeMock(String id, String year, String month) {

        Long.parseLong(id+year+month);

        Random generateValue = new Random(Long.parseLong(id+year+month));
        Random generateNumberTransaction = new Random(Long.parseLong(id+year+month));
        Random generateDayTransaction = new Random(Long.parseLong(id+year+month));
        Random generateDescription = new Random(Long.parseLong(id+year+month));
        int transactions = generateNumberTransaction.nextInt(50);


        TransactionOutputDTO t = new TransactionOutputDTO();
        List<TransactionOutputDTO> transactionOutputDTOList = new ArrayList<TransactionOutputDTO>();

        
        for (int i = 1; i < transactions; i++) {

            TransactionOutputDTO transactionOutputDTO = new TransactionOutputDTO();
            transactionOutputDTO.setDescricao(randomAlhaNumeric(11, generateDescription));
            transactionOutputDTO.setData(randomDate(year, month, generateDayTransaction.nextInt(30)));
            transactionOutputDTO.setValor(generateValue.nextInt(9999999));
            transactionOutputDTOList.add(transactionOutputDTO);
        }

        return transactionOutputDTOList;

    }


    public static String randomAlhaNumeric(int count, Random random) {

        StringBuilder builder = new StringBuilder();
        while(count-- != 0 ) {
            int character = random.nextInt(25);
            builder.append(STRINGS.charAt(character));
        }

        return builder.toString();

    }

    public String randomDate(String year, String month, int count) {

        var mescerto = Integer.parseInt(month) -1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(year));
        c.set(Calendar.MONTH, mescerto);
        c.set(Calendar.DAY_OF_MONTH, count);

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data formatada: "+ sdf.format(c.getTime()));

        return sdf.format(c.getTime()).toString();

    }

}
