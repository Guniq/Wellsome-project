package wellsome.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
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
	
	// 공지사항 저장
	public int boardInput(BoardDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("boardInput", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	// 공지사항 리스트
	public List<BoardDTO> boardList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardList");
		sqlSession.close();
		
		return list;
	}
	
	// bNum에 해당하는 공지사항 불러오기
	public BoardDTO getBoard(int bNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO dto = sqlSession.selectOne("getBoard", bNum);
		sqlSession.close();
		
		return dto;
	}
	
	// 공지사항 수정하기
	public int boardUpdate(BoardDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("boardUpdate", dto);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	// 공지사항 삭제
	public int boardDelete(int bNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		int cnt = sqlSession.delete("boardDelete", bNum);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
}
