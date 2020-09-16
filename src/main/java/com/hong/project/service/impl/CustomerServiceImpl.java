package com.hong.project.service.impl;

import com.hong.project.mapper.CustomerMapper;
import com.hong.project.pojo.Customer;
import com.hong.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description：用户服务实现层
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    @Transactional
    public Integer saveCustomer(Customer customer) {
        Integer flag = customerMapper.saveCustomer(customer);
        return flag;
    }

    @Override
    @Transactional
    public Integer deleteCustomer(Integer custId) {
        return customerMapper.deleteCustomer(custId);
    }

    @Override
    @Transactional
    public Integer updateCusTomerByCustId(Customer customer) {
        return customerMapper.updateCusTomerByCustId(customer);
    }

    @Override
    public Customer findCustomerByCustId(Integer custId) {
        return customerMapper.findCustomerByCustId(custId);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }
}


