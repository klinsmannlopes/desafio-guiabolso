package com.guiabolso.MockTransaction.dtos.client.transaction.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionOutputDTO {

    private String descricao;
    private Long data;
    private Integer valor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean duplicated;

}
