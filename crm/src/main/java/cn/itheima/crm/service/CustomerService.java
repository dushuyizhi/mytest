package cn.itheima.crm.service;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.utils.Page;

/**
 * 客户service接口
 * @author 刘政
 *
 */
public interface CustomerService {
	/**
	 * 1.多条件查询客户列表
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerList(QueryVo queryVo);
	/**
	 * 2.根据id查询客户信息
	 */
	Customer queryUserById(Long id);
	/**
	 * 3.修改客户
	 */
	void updateUser(Customer customer);
	/**
	 * 4.删除客户
	 */
	void delCust(Long custId);
}
