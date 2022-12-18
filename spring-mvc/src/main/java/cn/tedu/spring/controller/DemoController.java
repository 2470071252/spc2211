package cn.tedu.spring.controller;

import cn.tedu.spring.entity.User;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/excel")
    @ResponseBody
    public XSSFWorkbook excel(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Demo");
        sheet.createRow(0).createCell(0).setCellValue("Hello World!");
        return workbook;
    }

    @GetMapping("/getparam")
    public String getparam(String username,
                           @RequestParam String password,
                           @RequestParam("goto") String target){
        logger.debug("{}, {}, {}", username, password, target);
        return "OK";
    }

    @PostMapping("/postparam")
    public String postparam(String username,
                            @RequestParam String password,
                            @RequestParam("goto") String target){
        logger.debug("{}, {}, {}", username, password, target);
        return "OK";
    }

    @GetMapping("/users/{id}")
    public String pathValue(@PathVariable("id") Integer uid){
        logger.debug("uid {}", uid);
        return "OK";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        logger.debug("user {}", user);
        return "OK";
    }

    @GetMapping("/headers")
    public String headers(String name,
                          @RequestHeader("Accept") String accept,
                          @RequestHeader("User-Agent") String ua){
        logger.debug("{}，{}，{}", name, accept, ua);
        return "OK";
    }


}


