package cn.itheima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.po.Customer;
import cn.itheima.crm.po.QueryVo;
import cn.itheima.crm.service.BaseDictService;
import cn.itheima.crm.service.CustomerService;
import cn.itheima.crm.utils.Page;


/**
 * 客户页面
 * @author 刘政
 *
 */
@Controller
@RequestMapping("cust")
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	//1.顾客页面显示
	@RequestMapping("list")
	public String list(ModelMap modelMap,QueryVo queryVo){
		//1.第一步需求，加载客户来源，所属行业，客户级别的下拉框显示
		//1.1查找对应数据
//		客户来源fromType
		List<BaseDict> fromType = baseDictService.queryBaseDictByTypeCode("002");
//		所属行业industryType
		List<BaseDict> industryType = baseDictService.queryBaseDictByTypeCode("001");
//		客户级别levelType
		List<BaseDict> levelType = baseDictService.queryBaseDictByTypeCode("006");
		
		//1.2响应数据
		modelMap.addAttribute("fromType", fromType);
		modelMap.addAttribute("industryType",industryType );
		modelMap.addAttribute("levelType", levelType);
		
		//2.需求：根据查询条件，查询客户，并分页
		Page<Customer> page = customerService.queryCustomerList(queryVo);
		modelMap.addAttribute("page", page);
		
		modelMap.addAttribute("custName", queryVo.getCustName());
		modelMap.addAttribute("custIndustry", queryVo.getCustIndustry());
		modelMap.addAttribute("custLevel", queryVo.getCustLevel());
		modelMap.addAttribute("custSource", queryVo.getCustSource());
		
		return "customer";
	}
	/**
	 * 2.去往修改客户信息页面
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Model model,Long id){
		//根据id查找客户原本信息
		Customer customer = customerService.queryUserById(id);
		return customer;
	}
	/**
	 * 3.保存信息
	 */
	@RequestMapping("update")
	@ResponseBody
	public void update(Customer customer){ 
		customerService.updateUser(customer);
	}
	/**
	 * 4.删除客户
	 */
	@RequestMapping("delcust")
	@ResponseBody
	public Map<String, String> delcust(Long id){
		//定义结果对象
		Map<String, String> resultMap = new HashMap<String, String>();
		
		try{
//			增加异常
//			int i = 1/0;
			//删除客户数据
			customerService.delCust(id);
			resultMap.put("flag", "success");
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("flag", "failure");
		}
		return resultMap;
	}
	
	
	

}
