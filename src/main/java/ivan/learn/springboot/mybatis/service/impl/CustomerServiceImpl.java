package ivan.learn.springboot.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ivan.learn.springboot.mybatis.dao.CustomerMapper;
import ivan.learn.springboot.mybatis.model.Customer;
import ivan.learn.springboot.mybatis.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getCustomerByName(String name) {
        LOGGER.info("Customer name: [{}]", name);
        return customerMapper.selectCustomerByName(name);
    }

    @Override
    public PageInfo<Customer> getCustomers(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Customer> result = customerMapper.selectCustomers();


        return new PageInfo<Customer>(result);


    }
}
