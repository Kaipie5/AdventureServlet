
package com.stockcharts.interns.adventuregame;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;


public class AdventureServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdventureServlet.class.getName());
    private static final Logger accessLogger = Logger.getLogger("AccessLogger");
    
    
    private final String TEMPLATE_DIRECTORY = "templates";
    private final String GAME = "game";
    
    private Configuration freemarkerConfig;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        logger.warn("============================================================");
        logger.warn("               adventure-servlet init()");
        logger.warn("============================================================");
        
        
        String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/");
        if (!realPath.endsWith("/")) {
            realPath += "/";
        }
        
        String templateDir = realPath + TEMPLATE_DIRECTORY;
        freemarkerConfig = new Configuration(Configuration.VERSION_2_3_23);
        
        logger.warn("Setting template directory...");
        try {
            freemarkerConfig.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            logger.fatal("SHUTTING DOWN - Unable to set template directory", e);
            destroy();
            throw new UnavailableException(e.getMessage());
        }
        logger.warn("...successfully set template directory");
        
        logger.warn("============================================================");
        logger.warn("          adventure-servlet init() ~~~ COMPLETE ~~~");
        logger.warn("============================================================");
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");
        
        if (game == null) {
            game = new Game();
        }
        
        String cmd = request.getParameter("cmd");
        if (cmd == null) cmd = "";
        
        switch (cmd) {
            
            // Navigation
            case "north":
                game.movePlayerNorth();
                break;
                
                
            // Decisions
            case "run":
                game.doPlayerRetreat();
                break;
                
            case "fight":
//                game.doPlayerFight();
                break;
        }
        
        String templateName = game.getTemplate();
        
        Map<String,Object> model = new HashMap<>();
        
        model.put("locationMessage", game.getLocationMessage());
        
        try (PrintWriter out = response.getWriter()) {
            
            Template view = freemarkerConfig.getTemplate(templateName);
            view.process(model, out);
            
        } catch (IOException e) {
        
        } catch (TemplateException e) {
            
        }
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        
    }


}
