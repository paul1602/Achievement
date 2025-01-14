package controller.admin.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminPost;
import service.admin.post.face.AdminPostService;
import service.admin.post.impl.AdminPostServiceImpl;


@WebServlet("/admin/postdelete")
public class AdminPostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminPostService adminPostService = new AdminPostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("login") == null) {
			 resp.sendRedirect("/member/login");
			 
			 return;
		 }
		
		AdminPost adminPost = adminPostService.getP_no(req);
		
		adminPostService.delete(adminPost);
		
		resp.sendRedirect("/admin/postlist");
	}
	

}
