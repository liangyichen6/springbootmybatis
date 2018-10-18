package ivan.learn.springboot.mybatis.controller;

import ivan.learn.springboot.mybatis.service.CustomerService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listCustomers(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        return ResponseEntity.ok(customerService.listCustomers(pageNum, pageSize));
    }
}
