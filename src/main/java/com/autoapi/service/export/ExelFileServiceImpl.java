package com.autoapi.service.export;

import com.autoapi.model.dto.AutoResponseDto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExelFileServiceImpl implements ExelFileService<AutoResponseDto> {
    @Override
    public void writeExcel(List<AutoResponseDto> models) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        int i = 0;
        XSSFRow row = sheet.createRow(i);
        row.createCell(0, CellType.NUMERIC).setCellValue("ID auto");
        row.createCell(1, CellType.STRING).setCellValue("Number");
        row.createCell(2, CellType.STRING).setCellValue("Vin Code");
        row.createCell(3, CellType.STRING).setCellValue("Color");
        row.createCell(4, CellType.NUMERIC).setCellValue("Year");
        row.createCell(5, CellType.STRING).setCellValue("Manufacturer");
        row.createCell(6, CellType.STRING).setCellValue("Model");
        row.createCell(7, CellType.STRING).setCellValue("Owner");
        for (AutoResponseDto auto : models) {
            row = sheet.createRow(++i);
            row.createCell(0, CellType.NUMERIC).setCellValue(auto.getId());
            row.createCell(1, CellType.STRING).setCellValue(auto.getNumber());
            row.createCell(2, CellType.STRING).setCellValue(auto.getVinCode());
            row.createCell(3, CellType.STRING).setCellValue(auto.getColor().name());
            row.createCell(4, CellType.NUMERIC).setCellValue(auto.getYear());
            row.createCell(5, CellType.STRING).setCellValue(auto.getManufacturerName());
            row.createCell(6, CellType.STRING).setCellValue(auto.getModelName());
            row.createCell(7, CellType.STRING).setCellValue(auto.getOwnerName());
        }
        FileOutputStream outputStream = new FileOutputStream(new File(
                    "autos.xls"));
        workbook.write(outputStream);
        workbook.close();
    }
}
