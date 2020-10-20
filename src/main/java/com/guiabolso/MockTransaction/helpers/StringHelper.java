package com.guiabolso.MockTransaction.helpers;

import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.BusinessRuleException;
import org.springframework.stereotype.Service;

@Service
public class StringHelper {

    public boolean validateDate(String month) throws BusinessRuleException {

        boolean validateDate = month.matches("(^$|01|02|03|04|05|06|07|08|09|10|11|12)");
        if (!validateDate) {
            throw new BusinessRuleException(BusinessRulesEnum.FORMAT_DATE_INVALID, getClass(), "Formato da data informado incorretamente, exemplos de datas de mês validas: 01, 02, 05");
        }
        return validateDate;

    }

}
