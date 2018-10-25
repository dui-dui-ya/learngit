package com.baizhi.chenly.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{
		//1.使用Resources读取mybatis-config.xml
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			//2.创建SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件数据失败");
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//ThreadLocal可以将一个对象绑定到当前线程
	private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	public static SqlSession openSession(){
		SqlSession sqlSession = tol.get();
		if(sqlSession==null){
			sqlSession = factory.openSession();
			tol.set(sqlSession);
		}
		return sqlSession;
	}
	//释放资源
	public static void close(){
		SqlSession session = openSession();
		session.close();
		tol.remove();
	}
	
	public static Object getMapper(Class c){
		SqlSession session = openSession();
		Object obj = session.getMapper(c);
		return obj;
	}
	
	//提交事务的封装
	public static void commit(){
		SqlSession session = openSession();
		session.commit();
	}
	//事务回滚的封装
	public static void rollback(){
		SqlSession session = openSession();
		session.rollback();
	}
}