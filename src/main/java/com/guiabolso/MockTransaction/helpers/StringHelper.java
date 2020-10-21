package com.guiabolso.MockTransaction.helpers;

import com.guiabolso.MockTransaction.enums.BusinessRulesEnum;
import com.guiabolso.MockTransaction.exceptions.BusinessRuleException;
import org.springframework.stereotype.Service;

@Service
public class StringHelper {

    public boolean validateMonthString(String month) throws BusinessRuleException {

        boolean validateDate = month.matches("(^$|01|02|03|04|05|06|07|08|09|10|11|12)");
        if (!validateDate) {
            throw new BusinessRuleException(BusinessRulesEnum.FORMAT_MONTH_INVALID, getClass(), "Formato da data informado incorretamente, exemplos de datas de mês validas: 01, 02, 05 ...");
        }
        return validateDate;

    }

    public boolean validateYearString(String month) throws BusinessRuleException {

        boolean validateDate = month.matches("[0-9]{4}");
        if (!validateDate) {
            throw new BusinessRuleException(BusinessRulesEnum.FORMAT_YEAR_INVALID, getClass(), "Formato do ano informado incorretamente, exemplos de datas de anos validas: 2012, 2013, 2020 ...");
        }
        return validateDate;

    }

    public boolean validateIdString(String month) throws BusinessRuleException {

        boolean validateDate = month.matches("^(1[0-9]{3,8})$");
        if (!validateDate) {
            throw new BusinessRuleException(BusinessRulesEnum.ID_INVALID, getClass(), "ID invalido, Por favor inserir ID entre o intervalo de 1.000 a 100.000.000");
        }
        return validateDate;

    }

}
