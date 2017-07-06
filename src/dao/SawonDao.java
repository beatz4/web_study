package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	//SqlSessionFactory 객체정보 얻기
	SqlSessionFactory factory;
	
	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}

	
	//사원목록 가져오기
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession을 이용한 작업수행
		//                       mapper id="sawon_list"
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3.닫기 : connection close()의 내용도 포함
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession을 이용한 작업수행
		//                 mapper id="sawon_list_deptno"  , parameter(int)
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		//3.닫기 : connection close()의 내용도 포함
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession을 이용한 작업수행
		list = sqlSession.selectList("sawon.sawon_list_sajob",sajob);
		
		//3.닫기 : connection close()의 내용도 포함
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession을 이용한 작업수행
		list = sqlSession.selectList(
				"sawon.sawon_list_sapay",map);
		
		//3.닫기 : connection close()의 내용도 포함
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList_gogek() {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatis처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession을 이용한 작업수행
		list = sqlSession.selectList("sawon.sawon_gogek_list");
		
		//3.닫기 : connection close()의 내용도 포함
		sqlSession.close();
		
		return list;
	}
	
	
	
}





