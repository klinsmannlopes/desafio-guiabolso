package com.guiabolso.MockTransaction.dtos.client.transaction.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionOutputDTO {

    @Min(10)
    private String descricao;

    private String data;
    private int valor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean duplicated;

}
