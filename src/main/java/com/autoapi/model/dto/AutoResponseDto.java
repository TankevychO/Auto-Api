package com.autoapi.model.dto;

import com.autoapi.model.Auto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AutoResponseDto {
    private Long id;
    private int year;
    private String vinCode;
    private Auto.Color color;
    private String number;
    private String manufacturerName;
    private String modelName;
    private String ownerName;
}
