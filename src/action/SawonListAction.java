package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// list.do?deptno=10
		int deptno = 0;
		
		String str_deptno = request.getParameter("deptno");
		if(str_deptno!=null && !str_deptno.isEmpty())
			deptno = Integer.parseInt(str_deptno);
			
		
		//사원목록을 SawonDao에게 요청
		List<SawonVo> list = null;
		
		if(deptno==0)
		{
			//전체목록 조회
		    list  = SawonDao.getInstance().selectList();
		}else{
			//부서별 목록 조회
			list  = SawonDao.getInstance().selectList(deptno);
		}
		
		//System.out.println(list.size());
		
		
		//가져온 데이터를 request binding
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "sawon_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}

}