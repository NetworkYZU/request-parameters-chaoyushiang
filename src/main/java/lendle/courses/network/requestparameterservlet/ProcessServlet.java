/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.requestparameterservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lendle
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/process"})
public class ProcessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            /*新增功能:可以讀取許多東西*/
            Enumeration<String> names=request.getParameterNames();
            while(names.hasMoreElements()){
                String name=names.nextElement();
                out.print(name+"=");
                out.println(request.getParameter(name)+"</br>");
            }
            
            /*新增以下才可以print出大於2個的值*/
            String [] groupValue=request.getParameterValues("group2");
            for(int i=0; i<groupValue.length; i++){
                out.println(""+i+"="+groupValue[i]+"<br/>");
            }
            
            /*新增結束*/
            /*println:有換行*/
            /*print:無換行*/
//            out.println(request.getParameter("username"));
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
