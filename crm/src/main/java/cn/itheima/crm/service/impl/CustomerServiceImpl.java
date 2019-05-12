package cn.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.CustomerMapper;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;
/**
 * 客户service实现
 * @author 刘政
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	//注入mapper
	@Autowired
	private CustomerMapper customerMapper;
	/**
	 * 1.根据条件查询顾客，并分页
	 */
	public Page<Customer> queryCustomerList(QueryVo queryVo) {
		//计算从第几条记录开始
		int start = 0;
		start = (queryVo.getPage() -1 )*queryVo.getRows();
		//将起始数封装到queryVo对象中
		queryVo.setStart(start);
		//查询符合条件的客户集合
		List<Customer> rows = customerMapper.queryCustomerList(queryVo);
		//总记录数
		Integer total = customerMapper.countUsers(queryVo);
		
		//创建page对象
		Page<Customer> page = new Page<Customer>(total, queryVo.getPage(), queryVo.getRows(), rows);
		return page;
	}
	/**
	 * 2.根据id查询客户信息
	 */
	public Customer queryUserById(Long id) {
		return customerMapper.queryUserById(id);
	}
	/**
	 * 3.修改客户
	 */
	public void updateUser(Customer customer) {
		customerMapper.updateUser(customer);
	}
	/**
	 * 4.删除客户
	 */
	public void delCust(Long custId) {
		customerMapper.delCust(custId);
	}

}
