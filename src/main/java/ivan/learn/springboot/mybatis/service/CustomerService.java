package ivan.learn.springboot.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import ivan.learn.springboot.mybatis.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerByName(String name);

    PageInfo<Customer> listCustomers(Integer pageNum, Integer pageSize);
}
