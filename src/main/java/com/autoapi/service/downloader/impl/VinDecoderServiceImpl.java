package com.autoapi.service.downloader.impl;

import com.autoapi.model.dto.downloader.VinCodeDto;
import com.autoapi.model.dto.downloader.VinCodeResultDto;
import com.autoapi.service.downloader.HttpClient;
import com.autoapi.service.downloader.VinDecoderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VinDecoderServiceImpl implements VinDecoderService {
    @Value("${urlVinDecoder}")
    private String urlVinDecoder;
    @Value("${urlFormat}")
    private String urlFormat;
    private String vinCode;
    private final HttpClient httpClient;

    public VinDecoderServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public VinCodeDto fetchInfo(String vinCode) {
        String url = urlVinDecoder + vinCode + urlFormat;
        VinCodeResultDto vinCodeResultDto =
                httpClient.get(url, VinCodeResultDto.class);
        return vinCodeResultDto.getResults().get(0);
    }
}
