/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.controllers.apirest;

import com.google.gson.Gson;
import sinensia.controllers.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sinensia.model.logic.UserService;
import sinensia.model.User;
import sinensia.model.persistence.IUserDAO;
import sinensia.model.persistence.UserDAO_DerbyDB;

/**
 *
 * @author alumno
 */
@WebServlet(asyncSupported = true, urlPatterns = "/api/users")
public class UsersRestController extends HttpServlet {

    UserService userSrv;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        IUserDAO usersDAO = new UserDAO_DerbyDB();
        this.userSrv = new UserService(usersDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        try {
            User userJson = userSrv.create(user.getEmail(), user.getPassword(), user.getName(), String.valueOf(user.getAge()));
            String usertext = gson.toJson(userJson);
            resp.getWriter().print(usertext);
        } catch (SQLException ex) {
            Logger.getLogger(UsersRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        
        try {
            List<User> usersList = userSrv.getAll();
            // Serializamos el List en un JSON
            Gson gson = new Gson();
            String textJson = gson.toJson(usersList);
            // Devolverá [ {"id": 1, "email": "aaa@aaa.com"...},  ]
            resp.getWriter().print(textJson);
        } catch (Exception ex) {
            Logger.getLogger(UsersRestController.class.getName()).log(Level.SEVERE, null, ex);
            resp.getWriter().print("{\"error\": \"" 
                    + ex.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        try {
            User userJson = userSrv.update(userSrv.getOneByEmail(user.getEmail()).getId(), user.getEmail(), user.getPassword(), user.getName(), String.valueOf(user.getAge()));
            String usertext = gson.toJson(userJson);
            resp.getWriter().print(usertext);
        } catch (SQLException ex) {
            Logger.getLogger(UsersRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        
        try {
            userSrv.remove(userSrv.getOneByEmail(user.getEmail()).getId());
        } catch (SQLException ex) {
            Logger.getLogger(UsersRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
