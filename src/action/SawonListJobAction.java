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
 * Servlet implementation class SawonListJobAction
 */
@WebServlet("/sawon/list_job.do")
public class SawonListJobAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//list_job.do?sajob=과장
		request.setCharacterEncoding("utf-8");
		
		String sajob = request.getParameter("sajob");
		
		List<SawonVo> list = null;
		
		if(sajob==null || sajob.isEmpty())
		{
			//전체목록 조회
		    list  = SawonDao.getInstance().selectList();
		}else{
			//직급별 목록 조회
			list  = SawonDao.getInstance().selectList(sajob);
		}
		
		
		
		//가져온 데이터를 request binding
		request.setAttribute("list", list);
		
		//forward
		String forward_page = "sawon_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}

}