package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만 생성해서 서비스 하자
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();

		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		List<DeptVo> list = null;
		
		//1.작업세션 얻기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		list = sqlSession.selectList("dept_list");
		
		//3.반환
		sqlSession.close();
		
		
		return list;
	}
	
	
	
	
	
	
}
