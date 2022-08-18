/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listerners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.Activity;

/**
 * Web application lifecycle listener.
 *
 * @author Tyrese Fisher
 */
public class ContextServletListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("categories", Activity.CATEGORIES);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
