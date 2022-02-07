package com.autoapi.service.downloader;

import com.autoapi.model.dto.downloader.VinCodeDto;

public interface VinDecoderService {
    VinCodeDto fetchInfo(String vinCode);
}
