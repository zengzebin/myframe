package ssxt.com.zeng.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
import common.dao.GenericDaoImpl2;
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.BasDeviceInfo;

@Repository(value = "deviceDao")
public class DeviceDao extends GenericDaoImpl<BasDeviceInfo, Long> {
	// public class DeviceDao extends GenericDaoImpl2<BasDeviceInfo, Long> {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DeviceDao.class);

	public void commonConList(List<SqlCondGroup> conList, BasDeviceInfo bean) {
		// TODO Auto-generated method stub

	}

}
