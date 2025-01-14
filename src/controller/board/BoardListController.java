package controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.board.face.BoardService;
import service.board.impl.BoardServiceImpl;
import util.Paging;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/3")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search_type = request.getParameter("search_type");
		String keyword = request.getParameter("keyword");
		Paging paging = null;

		List<Board> boardList = new ArrayList<Board>();

		if(search_type == null) {
			paging = boardService.getPaging(request, 3);
			boardList = boardService.Select(paging, 3);
			
		}else if(search_type.equals("title_content")) {
			paging = boardService.getPaging(request, 3);
			boardList = boardService.pSearch(paging, 3, keyword);
			
		}else {
			paging = boardService.getPaging(request, 3);
			boardList = boardService.cSearch(paging, 3, keyword);
			
		}
		

		request.setAttribute("paging", paging);
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/WEB-INF/views/post/Board.jsp")
			.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("도착");
		doGet(request, response);
	}

}
