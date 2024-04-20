package ceing.ceing.web.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {


    @NotBlank
    private String itemName;

    @NotBlank
    private Integer price;

    @NotBlank
    private Integer quantity;
}
