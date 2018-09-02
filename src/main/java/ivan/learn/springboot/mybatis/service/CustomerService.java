package ivan.learn.springboot.mybatis.service;

import ivan.learn.springboot.mybatis.model.Customer;

public interface CustomerService {

    Customer getCustomerByName(String name);

}
