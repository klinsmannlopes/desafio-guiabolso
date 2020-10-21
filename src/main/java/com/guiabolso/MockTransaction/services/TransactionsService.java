package com.guiabolso.MockTransaction.services;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.BusinessRuleException;
import com.guiabolso.MockTransaction.helpers.StringHelper;
import com.guiabolso.MockTransaction.services.mock.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionsService {

    @Autowired
    private MockService mockService;

    @Autowired
    private StringHelper stringHelper;

    public List<TransactionOutputDTO> find(String id, String year, String month) throws BusinessRuleException {
        try {

            //validando formato do conjunto de dados
            validateYearString(id, year, month);
            List<TransactionOutputDTO> transactionOutputDTOList = mockService.makeMockTransactions(id, year, month);

            //ordenando as transações
            return transactionOutputDTOList.stream()
                    .sorted((transaction1, transaction2) -> transaction1.getData().compareTo(transaction2.getData())
                    ).collect(Collectors.toList());

        } catch (BusinessRuleException ex) {
            throw new BusinessRuleException(ex.getErrorDto());
        } catch (Exception e) {
            throw new BusinessRuleException(BusinessRulesEnum.ERROR_SERVER, getClass(), e.getMessage());
        }

    }

    public void validateYearString(String id,String ano, String mes) throws BusinessRuleException {
        stringHelper.validateIdString(id);
        stringHelper.validateYearString(ano);
        stringHelper.validateMonthString(mes);
    }


}
