package controller.admin.challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.admin.challenge.face.AdminChallengeService;
import service.admin.challenge.impl.AdminChallengeServiceImpl;

/**
 * Servlet implementation class AdminChallengeDeleteController
 */
@WebServlet("/admin/challenge/delete")
public class AdminChallengeDeleteController extends HttpServlet {
	private static final  long serialVersionUID = 1L;	
	
	private AdminChallengeService adminChallengeService = new AdminChallengeServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인이 되어있지 않으면 리다이렉트
		
		if(req.getSession().getAttribute("login")==null || !"M".equals(req.getSession().getAttribute("u_grade"))) {
			resp.sendRedirect("/");
			return;
		}
				
		adminChallengeService.delete(req);
		resp.sendRedirect("/admin/challenge/list");
	}
	

}
