package cn.itheima.crm.service;

import java.util.List;

import cn.itheima.crm.po.BaseDict;

/**
 * 数据字典接口
 * @author 刘政
 *
 */
public interface BaseDictService {
	/**
	 * 根据数据字典类型编码查询
	 * @param typeCode
	 * @return
	 */
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);
}
