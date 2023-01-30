package wellsome.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 초기화 블럭 : application 실행시 한번만 실행되는 코드 블럭
	static {
		try {
			String resource = "wellsome/mybatis/config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			
			// build()는 config.xml을 이용해서 커넥션 풀을 만듦
			// sqlSessionFactory 는 커넥션 풀(Connection Pool)을 가리키는 객체 			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // static
	
	// 아이디 중복체크
	public String userIdChk(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String dbId = sqlSession.selectOne("userIdChk", id);
		
		String idChk = "N"; // N(중복x)
		if(dbId !=null) {
			idChk = "Y"; // 중복(o)
		}
		System.out.println("dbId : " + dbId);
		sqlSession.close();
		
		return idChk;
	}
	
	// 회원가입
	public int userJoin(UserDTO dto) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("userJoin", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	// 회원로그인
	public String userLogin(UserDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String userName = sqlSession.selectOne("userLogin", dto);
		sqlSession.close();
		
		return userName;
	}
	
	// no에 해당하는 유저정보 가져오기
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO dto = sqlSession.selectOne("getUser", id);
		sqlSession.close();
		
		return dto;
	}
	
	
	
	
	
	
	
}
