package com.hong.project.service;

import com.hong.project.pojo.Customer;

import java.util.List;

/**
 * @Description：客户服务层接口
 */
public interface CustomerService {

    /**
     * @param customer 用户对象信息
     * @return 影响行数
     * @Description 保存用户
     */
    Integer saveCustomer(Customer customer);

    /**
     * @param custId 用户Id
     * @return 影响行数
     * @Description 删除用户
     */
    Integer deleteCustomer(Integer custId);

    /**
     * @param customer 用户对象，其中custId不可以为空
     * @return 影响行数
     * @Description 修改用户
     */
    Integer updateCusTomerByCustId(Customer customer);

    /**
     * @param custId 用户Id
     * @return Customer用户对象
     * @Description 按cusId查询用户
     */
    Customer findCustomerByCustId(Integer custId);

    /**
     * @return 所有用户
     * @Description 查询所有用户
     */
    List<Customer> findAll();
}


