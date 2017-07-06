package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.SawonDao;
import vo.SawonVo;

/**
 * Servlet implementation class SawonListSapayAction
 */
@WebServlet("/sawon/list_sapay.do")
public class SawonListSapayAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// list_sapay.do?start=3000&end=3500
		
		int start 
		  = Integer.parseInt(request.getParameter("start"));
		int end 
		  = Integer.parseInt(request.getParameter("end"));
		
		//2개이상의 파라메터정보를 1개의 객체로 묶는다
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		
		List<SawonVo> list 
		   = SawonDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);

		//forward
		String forward_page = "sawon_list.jsp";
		request.getRequestDispatcher(forward_page).forward(request, response);

	}

}