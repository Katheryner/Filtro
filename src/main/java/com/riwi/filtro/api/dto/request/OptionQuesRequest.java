package com.riwi.filtro.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OptionQuesRequest {
    @NotBlank(message = "The text is required")
    private String text;
    @NotNull(message = "This field is required")
    private Boolean active;

}
