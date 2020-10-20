package com.guiabolso.MockTransaction.services;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.BusinessRuleException;
import com.guiabolso.MockTransaction.helpers.StringHelper;
import com.guiabolso.MockTransaction.services.mock.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class TransactionsService {

    @Autowired
    private MockService mockService;

    @Autowired
    private StringHelper stringHelper;

    public List<TransactionOutputDTO> find(String id, String ano, String mes) throws BusinessRuleException {
        try {


            var t = stringHelper.validateDate(mes);

            List<TransactionOutputDTO> transactionOutputDTOList = mockService.makeMock(id, ano, mes);

            return transactionOutputDTOList;
        } catch (BusinessRuleException ex) {
            throw new BusinessRuleException(ex.getErrorDto());
        } catch (Exception e) {
            throw new BusinessRuleException(BusinessRulesEnum.FORMAT_DATE_INVALID, getClass(), "Datas incorresrta teste.");
        }

    }

}
