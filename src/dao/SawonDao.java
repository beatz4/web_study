package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	//single-ton : ��ü1���� ���� ����
	static SawonDao single = null;

	//SqlSessionFactory ��ü���� ���
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

	
	//������ ��������
	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatisó�� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession�� �̿��� �۾�����
		//                       mapper id="sawon_list"
		list = sqlSession.selectList("sawon.sawon_list");
		
		//3.�ݱ� : connection close()�� ���뵵 ����
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatisó�� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession�� �̿��� �۾�����
		//                 mapper id="sawon_list_deptno"  , parameter(int)
		list = sqlSession.selectList("sawon.sawon_list_deptno",deptno);
		
		//3.�ݱ� : connection close()�� ���뵵 ����
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatisó�� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession�� �̿��� �۾�����
		list = sqlSession.selectList("sawon.sawon_list_sajob",sajob);
		
		//3.�ݱ� : connection close()�� ���뵵 ����
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatisó�� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession�� �̿��� �۾�����
		list = sqlSession.selectList(
				"sawon.sawon_list_sapay",map);
		
		//3.�ݱ� : connection close()�� ���뵵 ����
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList_gogek() {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		
		//1.Mybatisó�� ��ü ������
		SqlSession sqlSession = factory.openSession();
		
		//2.sqlSession�� �̿��� �۾�����
		list = sqlSession.selectList("sawon.sawon_gogek_list");
		
		//3.�ݱ� : connection close()�� ���뵵 ����
		sqlSession.close();
		
		return list;
	}
	
	
	
}





