package ivan.learn.springboot.mybatis.controller;

import ivan.learn.springboot.mybatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity getCustomers(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        return ResponseEntity.ok(customerService.getCustomers(pageNum,pageSize));
    }
}
