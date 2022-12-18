package cn.tedu.spring.web;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelMessageConverter implements HttpMessageConverter {
    private Class excelObjectClass = XSSFWorkbook.class;
    private MediaType mediaType = new MediaType("application", "xlsx");
    private String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    @Override
    public boolean canRead(Class aClass, MediaType mediaType) {
        //MappingJackson2HttpMessageConverter
        return false;
    }

    @Override
    public boolean canWrite(Class aClass, MediaType mediaType) {
        if (aClass.equals(excelObjectClass)){
            return true;
        }
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<>();
        list.add(mediaType);
        return list;
    }

    @Override
    public Object read(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {

        return null;
    }

    @Override
    public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        if (! (o instanceof XSSFWorkbook)){
            return;
        }
        XSSFWorkbook workbook = (XSSFWorkbook) o;
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        workbook.write(buf);
        workbook.close();
        buf.close();
        byte[] bytes = buf.toByteArray();
        ServletServerHttpResponse response = (ServletServerHttpResponse) httpOutputMessage;

        response.getServletResponse().addHeader("Content-Length", bytes.length+"");
        response.getServletResponse().addHeader("Content-Type", contentType);
        response.getBody().write(bytes);
    }
}
