package com.riwi.filtro.api.dto.request;

import java.util.List;

import com.riwi.filtro.Util.enums.Type;
import com.riwi.filtro.api.dto.response.OptionQuesResp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @NotBlank(message = "The text is required.")
    private String text;
    @NotNull(message = "The type is required")
    private Type type;
    @NotNull
    private Boolean active;
    private List<OptionQuesResp>options;

}
