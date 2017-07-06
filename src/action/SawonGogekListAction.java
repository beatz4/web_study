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
 * Servlet implementation class SawonGogekListAction
 */
@WebServlet("/sawon/sawon_gogek_list.do")
public class SawonGogekListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SawonVo> list 
		    = SawonDao.getInstance().selectList_gogek();

		request.setAttribute("list", list);
		
		//forward
		String forward_page = "sawon_gogek_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}

}