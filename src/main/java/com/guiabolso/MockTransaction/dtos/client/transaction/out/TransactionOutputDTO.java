package com.guiabolso.MockTransaction.dtos.client.transaction.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionOutputDTO {

    private String descricao;
    private String data;
    private int valor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean duplicated;

}
