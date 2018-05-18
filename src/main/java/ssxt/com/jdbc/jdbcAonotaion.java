package ssxt.com.jdbc;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.formula.functions.T;

import common.annotation.Column;
import common.annotation.Table;
import sun.reflect.generics.scope.MethodScope;

public class jdbcAonotaion {

	/**
	 * 
	 * 执行set方法
	 * 
	 * 
	 * 
	 * @param o执行对象
	 * 
	 * @param fieldName属性
	 * 
	 * @param value值
	 * 
	 */

	public static void invokeSet(Object o, String fieldName, Object value) {

		Method method = getSetMethod(o.getClass(), fieldName);

		try {

			method.invoke(o, new Object[] { value });

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * java反射bean的set方法
	 * 
	 * 
	 * 
	 * @param objectClass
	 * 
	 * @param fieldName
	 * 
	 * @return
	 * 
	 */

	@SuppressWarnings("unchecked")

	public static Method getSetMethod(Class objectClass, String fieldName) {

		try {

			Class[] parameterTypes = new Class[1];

			Field field = objectClass.getDeclaredField(fieldName);

			parameterTypes[0] = field.getType();

			StringBuffer sb = new StringBuffer();

			sb.append("set");

			sb.append(fieldName.substring(0, 1).toUpperCase());

			sb.append(fieldName.substring(1));

			Method method = objectClass.getMethod(sb.toString(), parameterTypes);

			return method;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 
	 * 执行get方法
	 * 
	 * 
	 * 
	 * @param o执行对象
	 * 
	 * @param fieldName属性
	 * 
	 */

	public static Object invokeGet(Object o, String fieldName) {

		Method method = getGetMethod(o.getClass(), fieldName);

		try {

			return method.invoke(o, new Object[0]);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 
	 * java反射bean的get方法
	 * 
	 * 
	 * 
	 * @param objectClass
	 * 
	 * @param fieldName
	 * 
	 * @return
	 * 
	 */

	@SuppressWarnings("unchecked")

	public static Method getGetMethod(Class objectClass, String fieldName) {

		StringBuffer sb = new StringBuffer();

		sb.append("get");

		sb.append(fieldName.substring(0, 1).toUpperCase());

		sb.append(fieldName.substring(1));

		try {

			return objectClass.getMethod(sb.toString());

		} catch (Exception e) {

		}

		return null;

	}

	// 获取set get方法
	public static void setMethods(Object o) {
		Class cls = o.getClass();
		Method[] methods = cls.getDeclaredMethods();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			String fieldType = field.getType().getSimpleName();
			System.out.println(field.getName());
			System.out.println();
			System.out.println("字段类型=" + field.getType() + "#####" + fieldType);
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);
				// 获得set方法
				Method set = pd.getWriteMethod();
				// System.out.println("setMethod=" + set.getName());

				Method get = pd.getReadMethod();
				// 负值Object getValue = get.invoke(list.get(0), new Object[]{});
				// System.out.println("getMethod=" + get.getName());

			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * for (Method method : methods) {
		 * 
		 * 
		 * 
		 * System.out.println(method.getName());
		 * 
		 * }
		 */

	}

	public static void insert(Object o) {
		try {

			Connection conn = MyDataSource.getConnection();
			PreparedStatement pstmt;

			Class cls = o.getClass();
			Method[] methods = cls.getDeclaredMethods();
			Field[] fields = cls.getDeclaredFields();
			StringBuffer sql = new StringBuffer("insert into ");
			StringBuffer values = new StringBuffer("values(");
			// StringBuffer values = new StringBuffer("");
			// 有表名称
			List<Object> list = new ArrayList<Object>();
			if (cls.isAnnotationPresent(Table.class)) {
				Table a = (Table) cls.getAnnotation(Table.class);
				System.out.println("表名称" + a.name());
				sql.append(a.name() + "(");
			}

			for (Field field : fields) {

				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);
				Method getMehod = pd.getReadMethod();
				if (getMehod.isAnnotationPresent(Column.class)) {
					Column column = getMehod.getAnnotation(Column.class);
					// System.out.println(column.name());
					Object value = getMehod.invoke(o);
					// System.out.println(value);
					sql.append("" + column.name() + ",");
					values.append("?,");
					list.add(value);
					String fieldType = field.getType().getSimpleName();
				}

			}

			String a = sql.substring(0, sql.length() - 1) + ")";
			sql.append(") ");
			String b = values.substring(0, values.length() - 1) + ")";
			System.out.println(a.toString() + b.toString());
			pstmt = conn.prepareStatement(a.toString() + b.toString());
			for (int i = 0; i < list.size(); i++) {
				pstmt.setObject(i + 1, list.get(i));
			}

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (IntrospectionException e) {
			// TODO Auto-generated catch
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(sql.toString()+values.toString());

	}

	public static <T> T get(Class<T> classz, String sql, Object... args) {
		T entity = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = MyDataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			ResultSetMetaData rsmd = resultSet.getMetaData();
			Map<String, Object> values = new HashMap<String, Object>();
			if (resultSet.next()) {
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					values.put(columnLabel, columnValue);
				}
			}
			if (values.size() > 0) {
				entity = classz.newInstance();
				for (Map.Entry<String, Object> entry : values.entrySet()) {
					String fieldName = entry.getKey();
					Object fieldValue = entry.getValue();
					// ReflectionUtils.setFieldValue(entity, fieldName,
					// fieldValue);
					BeanUtils.setProperty(entity, fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			MyDataSource.release(connection);
		}
		// 返回包含查询信息的实体类对象
		return entity;
	}

	public static List   get2(String   forName, String sql, Object... args) {
	
	 List list=new ArrayList();
 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = MyDataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ResultSetMetaData rsmd = resultSet.getMetaData();
				Map<String, Object> values = new HashMap<String, Object>();

				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					values.put(columnLabel, columnValue);
				}
				if (values.size() > 0) {
 
					Object obj = Class.forName(forName).newInstance(); 
					for (Map.Entry<String, Object> entry : values.entrySet()) {
						String fieldName = entry.getKey();
						Object fieldValue = entry.getValue();
						// ReflectionUtils.setFieldValue(entity, fieldName,
						// fieldValue);
						BeanUtils.setProperty(obj, fieldName, fieldValue);
					}
					list.add(obj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			MyDataSource.release(connection);
		}
		// 返回包含查询信息的实体类对象

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Users user = new Users();
		user.setUsername("初始");
		user.setCreateTime(new Date());
		jdbcAonotaion.insert(user);

	}

}
