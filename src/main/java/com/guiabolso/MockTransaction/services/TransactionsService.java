package com.guiabolso.MockTransaction.services;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.BusinessRuleException;
import com.guiabolso.MockTransaction.helpers.StringHelper;
import com.guiabolso.MockTransaction.services.mock.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class TransactionsService {

    @Autowired
    private MockService mockService;

    @Autowired
    private StringHelper stringHelper;

    public List<TransactionOutputDTO> find(String id, String ano, String mes) throws BusinessRuleException {
        try {


            stringHelper.validateDateString(mes);
            List<TransactionOutputDTO> transactionOutputDTOList = mockService.makeMockTransactions(id, ano, mes);

            //transactionOutputDTOList.stream()
                    //.sorted((d1, d2) -> d1.getData().compareTo(d2.getData()))
                    //;
/*
            depositTransactionAtmOutDTOList = depositTransactionList.stream()
                    .filter(depositTransaction -> ! depositTransaction.getType().equals(DepositTransaction.TypeEnum.BRANCH_CHANGED))
                    .map(DepositTransactionAtmOutDTO::new)
                    .sorted((d1, d2) -> d1.getCreationDate().compareTo(d2.getCreationDate()))
                    .collect(Collectors.toList());

*/
            return transactionOutputDTOList;
        } catch (BusinessRuleException ex) {
            throw new BusinessRuleException(ex.getErrorDto());
        } catch (Exception e) {
            throw new BusinessRuleException(BusinessRulesEnum.FORMAT_DATE_INVALID, getClass(), "Datas incorresrta teste.");
        }

    }

}
