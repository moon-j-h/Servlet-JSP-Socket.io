package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
	// mybatis.xml(설정정보)파일의 위치
	private final static String RESOURCE="mybatis/mybatis.xml";
	private static SqlSessionFactory sqlMapper = null;
	//MyBatis 세션 팩토리를 얻는 메소드
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlMapper == null){
			Reader reader=null;
			try{
				// mybatis.xml의 자원을 얻는다.
				reader = Resources.getResourceAsReader(RESOURCE);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		return sqlMapper;
	}
}
