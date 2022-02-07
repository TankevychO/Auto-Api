package com.autoapi.controller;

import com.autoapi.service.AutoUploadData;
import com.autoapi.service.downloader.DownloadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InjectController {
    private final DownloadService downloadService;
    private final AutoUploadData autoLoadData;

    @GetMapping("/inject")
    public String inject() {
        downloadService.fetchInfo();
        autoLoadData.load();
        return "Done!";
    }
}

