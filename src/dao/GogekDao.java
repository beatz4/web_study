package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDao {

	//Mybatis ��ü
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� ���� ����
	static GogekDao single = null;

	public static GogekDao getInstance() {

		if (single == null)
			single = new GogekDao();

		return single;
	}

	public GogekDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<GogekVo> selectList() {
		// TODO Auto-generated method stub
		List<GogekVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("gogek_list");
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
}
