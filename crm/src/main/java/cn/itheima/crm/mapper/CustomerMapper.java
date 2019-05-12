package cn.itheima.crm.mapper;

import java.util.List;

import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;

/**
 * 客户mapper
 * @author 刘政
 *
 */
public interface CustomerMapper {
	/**
	 * 1.根据查询条件查询客户
	 * @param queryVo
	 * @return
	 */
	List<Customer> queryCustomerList(QueryVo queryVo);
	/**
	 * 2.符合条件的客户的数量
	 */
	Integer countUsers(QueryVo queryVo);
	/**
	 * 3.根据id查询客户信息
	 */
	Customer queryUserById(Long id);
	/**
	 * 4.修改客户
	 */
	void updateUser(Customer customer);
	/**
	 * 5.删除客户
	 */
	void delCust(Long custId);
}
