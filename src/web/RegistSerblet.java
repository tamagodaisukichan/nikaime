package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistBean;
import domain.SexEnum;
import servise.KaiinServise;

/**
 * Servlet implementation class RegistSerblet
 */
@WebServlet("/RegistSerblet")
public class RegistSerblet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSerblet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //フォーム内の値を取得
        String registIdStr = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        //IDを数値に変換
        int registId = Integer.parseInt(registIdStr);

        //文字化け解消
        byte[] bi = name.getBytes("iso-8859-1");
        String registName = new String( bi, "UTF-8" );

        byte[] bi2 = sex.getBytes("iso-8859-1");
        String namestr = new String( bi2, "UTF-8" );

        SexEnum registSex = SexEnum.valueOf(namestr);
        KaiinServise ks = new KaiinServise();
        RegistBean rb = ks.setKaiin(registId, registName, registSex);
        request.setAttribute("bean", rb);
        RequestDispatcher disp = request.getRequestDispatcher("/regist.jsp");
        disp.forward(request, response);

    }

}
