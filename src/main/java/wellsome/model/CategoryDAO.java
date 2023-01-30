package wellsome.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CategoryDAO {
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
	
	// 카테고리 저장
	public int categoryInput(CategoryDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("categoryInput", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	// 카테고리 리스트
	public List<CategoryDTO> categoryList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<CategoryDTO> list = sqlSession.selectList("categoryList");
		sqlSession.close();
		
		return list;
	}
	
	// 카테고리 삭제
	public int categoryDelete(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		int cnt = sqlSession.delete("categoryDelete", num);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
}
