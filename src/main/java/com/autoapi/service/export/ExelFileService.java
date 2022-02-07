package com.autoapi.service.export;

import java.io.IOException;
import java.util.List;

public interface ExelFileService<T> {
    void writeExcel(List<T> models) throws IOException;
}
