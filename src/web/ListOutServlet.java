package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KaiinLineBean;
import bean.ListOutBean;
import servise.KaiinServise;

/**
 * Servlet implementation class ListOutServlet
 */
@WebServlet("/ListOutServlet")
public class ListOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOutServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<KaiinLineBean> list =new  ArrayList<KaiinLineBean>();

        KaiinServise ks = new KaiinServise();

        ListOutBean lob = ks.allKaiinList();
        request.setAttribute("bean", lob);

        //JSPに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/next.jsp");
        disp.forward(request, response);

        doGet(request, response);
    }

}
