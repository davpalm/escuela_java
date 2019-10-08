package sinensia.controllers.apirest;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = "/api/heroes")
public class HeroRestController extends HttpServlet {

    public class Hero implements Serializable {
        
        private int id;
        private String name;
        private String file;

        public Hero() {
        }

        public Hero(int id, String name, String file) {
            this.id = id;
            this.name = name;
            this.file = file;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }
    
    ArrayList<Hero> listHeroes;
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        listHeroes = new ArrayList<>();
        listHeroes.add(new Hero(1, "Batman", "../sp.jpg"));
        listHeroes.add(new Hero(2, "Super Man", "../sp.jpg"));
        listHeroes.add(new Hero(3, "Green Lantern", "../sp.jpg"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        Hero hero = gson.fromJson(json, Hero.class);
        try {
            listHeroes.add(hero);
            resp.setContentType("application/json;charset=UTF-8");
            setAccessControlHeaders(resp);
            String heroText = gson.toJson(hero);
            resp.getWriter().print(heroText);
        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        setAccessControlHeaders(resp);
        try {
            Gson gson = new Gson();
            String textJson = gson.toJson(listHeroes);
            resp.getWriter().print(textJson);
        } catch (Exception ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
            resp.getWriter().print("{\"error\": \"" 
                    + ex.getMessage() + "\"}");
        }
    }
/*
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
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
/*
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        
        try {
            userSrv.remove(userSrv.getOneByEmail(user.getEmail()).getId());
        } catch (SQLException ex) {
            Logger.getLogger(HeroRestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/    

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    private void setAccessControlHeaders(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "OPTIONS,HEAD,GET,POST,PUT,DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.setHeader("Access-Control-Max-Age", "1728000"); // 20 dias
    }
    
}
