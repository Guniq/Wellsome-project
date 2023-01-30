package wellsome.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ProductDAO {
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
	
	// 상품 등록
	public int productInput(ProductDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("productInput", dto);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	// 상품 리스트
	public List<ProductDTO> productList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> list = sqlSession.selectList("productList");
		sqlSession.close();
		
		return list;
	}
	
	// 상품 삭제
	public int productDelete(int pNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		int cnt = sqlSession.delete("productDelete", pNum);
		sqlSession.commit();
		sqlSession.close();
		
		return cnt;
	}
	
	// pNum에 해당하는 상품 가져오기
	public ProductDTO getProduct(int pNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ProductDTO dto = sqlSession.selectOne("getProduct", pNum);
		sqlSession.close();
		
		return dto;
	}
	
	// pSpec에 해당하는 상품 가져오기 
	public List<ProductDTO> getProductBySpec(String pSpec){ 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> list = sqlSession.selectList("getProductBySpec", pSpec);
		sqlSession.close();
	  
		return list; 
	}	
	 
	 
	
	// 장바구니에 담고자하는 상품만 가져오기
	public ProductDTO getProduct(String pNum, String pSpec) {
		
		ArrayList<ProductDTO> dtos = new ArrayList<>();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setpNum(Integer.parseInt(pNum));
		productDTO.setpSpec(pSpec);
		
		if(pSpec == null) {
			System.out.println("해당 상품 리스트가 없습니다!!!");
		}else {
			dtos.add(productDTO);
		}
		
		for(ProductDTO pDto: dtos) {
			
			if(pNum.equals(String.valueOf(pDto.getpNum()))) {
				return pDto;
			}
		}
		
		return null;
	}
	
	// 상품 수정하기
	public int productUpdate(ProductDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("productUpdate", dto);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
}
