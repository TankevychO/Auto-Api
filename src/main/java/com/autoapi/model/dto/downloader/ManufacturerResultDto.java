package com.autoapi.model.dto.downloader;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerResultDto {
    private List<ManufacturerDto> results;
}
