package cn.itheima.crm.service.impl;
/**
 * 数据字典service实现类
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.crm.mapper.BaseDictMapper;
import cn.itheima.crm.po.BaseDict;
import cn.itheima.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	//注入mapper
	@Autowired
	private BaseDictMapper baseDictMapper;
	/**
	 * 根据数据字典类型编码查询
	 */
	public List<BaseDict> queryBaseDictByTypeCode(String typeCode) {
		List<BaseDict> list = this.baseDictMapper.queryBaseDictByTypeCode(typeCode);
		return list;
	}

}
