package com.riwi.filtro.api.dto.response;

import java.util.List;

import com.riwi.filtro.Util.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResp {
    private Long id;
    private String text;
    private Type type;
    private Boolean active;
    private List<OptionQuesResp> options;
    
}
