/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Activity;
import model.ActivityDAO;

/**
 *
 * @author Tyrese Fisher
 */
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        String url = "";
        String id = request.getParameter("id");
        int parsedID = Integer.parseInt(id);
        String category = request.getParameter("category");
        String activity = request.getParameter("activity");
        //check and parse
        switch(action){
            case "/add":
                    if(parsedID <=0 || parsedID >=50 || category.trim().isEmpty() 
                    || activity.trim().isEmpty() || category==null || activity==null){
                url = "/index.jsp";
                request.setAttribute("inputmessage", "== input data error ==");
            }
            else{
                Activity activityOb = new Activity(parsedID, category, activity);
                if(ActivityDAO.planExists(activityOb.getId())){
                        request.setAttribute("inputmessage", "==Actvity ID " + activityOb.getId() + " already exists in DB. ==");
                    }else{
                   ActivityDAO.InsertActivity(activityOb); 
                    request.setAttribute("inputmessage", "==New Activity Added " + activityOb.toString());
                }
            }
                    url = "/index.jsp";
                break;
            case "/search":
                ArrayList<Activity> resultsList = new ArrayList<>();
                if(category.equals("All")){
                    //put results into arraylist
                   resultsList.addAll(ActivityDAO.allPlans());
                        request.setAttribute("searchMessage", 
                                "==Found " + resultsList.size() + "(category = " + 
                                        category);
                        request.setAttribute("resultlist", resultsList.toString());
                    
                     }
                else{
                    resultsList.addAll(ActivityDAO.searchPlans(category));
                    request.setAttribute("searchMessage", 
                                "==Found " + resultsList.size() + "(category = " + 
                                        category);
                    request.setAttribute("resultlist", resultsList.toString());
                }
                url = "/search.jsp";
                break;
            default:
                break;
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
