package org.rmiralles.server.control;

import org.rmiralles.server.base.Text;
import org.rmiralles.server.base.User;
import org.rmiralles.server.database.Database;
import org.rmiralles.server.util.HibernateUtil;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/register")
    public @ResponseBody Boolean register(@RequestParam(value = "username") String username,
                                          @RequestParam(value = "password") String password,
                                          @RequestParam(value = "business_title") String business_title){
        boolean ok;
        HibernateUtil.buildSessionFactory();

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setBusiness_title(business_title);
        ok = new Database().register(user);

        return ok;
    }

    @RequestMapping("/login")
    public User login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        HibernateUtil.buildSessionFactory();

        User user = new Database().login(username, password);

        if (user == null){
            return new User();
        }

        return user;
    }

    @RequestMapping("/gettexts")
    public List<Text> getTexts(){
        HibernateUtil.buildSessionFactory();

        List<Text> text = new Database().getTexts();

        if (text == null){
            text = new ArrayList<>();
        }

        return text;
    }

    @RequestMapping("/getbctexts")
    public List<Text> getBcTexts(@RequestParam(value = "business_title") String business_title){
        HibernateUtil.buildSessionFactory();

        List<Text> text = new Database().getBcTexts(business_title);

        if (text == null){
            text = new ArrayList<>();
        }
        return text;
    }

    @RequestMapping("/gettextdetail")
    public Text getTextDetail(@RequestParam(value = "id") int id){
        HibernateUtil.buildSessionFactory();

        Text text = new Database().getTextDetail(id);

        if (text == null){
            text = new Text();
        }

        return text;
    }

    @RequestMapping("/addtext")
    public @ResponseBody boolean addText(@RequestParam(value = "text") String text,@RequestParam(value = "business_title") String business_title,
                                         @RequestParam(value = "lat") String lat,@RequestParam(value = "lon") String lon,@RequestParam(value = "id") int idUser){

        HibernateUtil.buildSessionFactory();

        Text textAdd = new Text();

        textAdd.setText(text);
        textAdd.setBusiness_title(business_title);
        textAdd.setLatitude(lat);
        textAdd.setLongitude(lon);
        textAdd.setDatetime(new Timestamp(new Date().getTime()));

        new Database().addText(textAdd, idUser);

        return true;
    }
}
