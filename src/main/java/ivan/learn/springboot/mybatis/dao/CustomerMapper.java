package ivan.learn.springboot.mybatis.dao;

import ivan.learn.springboot.mybatis.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectCustomerByName(String name);

    @Select("select * from t_customer")
    List<Customer> selectCustomers();
}