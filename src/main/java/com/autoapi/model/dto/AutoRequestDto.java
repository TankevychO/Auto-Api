package com.autoapi.model.dto;

import com.autoapi.lib.ValidColor;
import com.autoapi.lib.ValidNumber;
import com.autoapi.lib.ValidVinCode;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutoRequestDto {
    @ValidVinCode
    private String vinCode;
    @ValidColor
    private String color;
    @ValidNumber
    private String number;
    @Size(min = 3)
    private String nameOwner;
}
