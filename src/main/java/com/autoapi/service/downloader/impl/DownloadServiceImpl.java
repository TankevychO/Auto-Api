package com.autoapi.service.downloader.impl;

import com.autoapi.model.dto.downloader.ManufacturerDto;
import com.autoapi.model.dto.downloader.ManufacturerResultDto;
import com.autoapi.model.dto.downloader.ModelResultDto;
import com.autoapi.service.ManufacturerService;
import com.autoapi.service.ModelService;
import com.autoapi.service.downloader.DownloadService;
import com.autoapi.service.downloader.HttpClient;
import com.autoapi.service.mapper.impl.ManufacturerMapper;
import com.autoapi.service.mapper.impl.ModelMapper;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Value("${urlManufacturer}")
    private String url;
    @Value("${urlModel}")
    private String urlModel;
    @Value("${urlFormat}")
    private String urlFormat;
    private final HttpClient httpClient;
    private final ManufacturerMapper manufacturerMapper;
    private final ManufacturerService manufacturerService;
    private final ModelMapper modelMapper;
    private final ModelService modelService;

    public DownloadServiceImpl(HttpClient httpClient,
                               ManufacturerMapper manufacturerMapper,
                               ManufacturerService manufacturerService,
                               ModelMapper modelMapper,
                               ModelService modelService) {
        this.httpClient = httpClient;
        this.manufacturerMapper = manufacturerMapper;
        this.manufacturerService = manufacturerService;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
    }

    @Override
    @Scheduled(cron = "@monthly")
    public void fetchInfo() {
        ManufacturerResultDto manufacturerResultDto =
                httpClient.get(url, ManufacturerResultDto.class);
        manufacturerService.saveAll(manufacturerResultDto.getResults().stream()
                .map(manufacturerMapper::mapToModel)
                .collect(Collectors.toList()));
        for (ManufacturerDto manufacturer : manufacturerResultDto.getResults()) {
            modelService.saveAll(httpClient.get(urlModel + manufacturer.getMake_id()
                    + urlFormat, ModelResultDto.class).getResults()
                    .stream().map(modelMapper::mapToModel)
                    .collect(Collectors.toList()));
        }
    }
}
