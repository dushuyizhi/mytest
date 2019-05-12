package cn.itheima.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.itheima.crm.po.BaseDict;

/**
 * 数据字典mapper接口
 * @author 刘政
 *
 */
public interface BaseDictMapper {
	
	/**
	 * 根据数据字典类型编码查询
	 * //根据type-code查找数据字典(页面需要对应的type-name的集合)
	 */
	List<BaseDict> queryBaseDictByTypeCode(String typeCode);
}
