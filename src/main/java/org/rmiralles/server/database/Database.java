package org.rmiralles.server.database;

import org.hibernate.Query;
import org.hibernate.Session;
import org.rmiralles.server.base.Text;
import org.rmiralles.server.base.User;
import org.rmiralles.server.util.HibernateUtil;
import java.util.List;

public class Database {

    public boolean register(User user){
        String userRegister = user.getUsername();
        String stringQuery = "SELECT * FROM User U WHERE U.username = :userRegister";
        Query query = HibernateUtil.getCurrentSession().createSQLQuery(stringQuery).addEntity(User.class);
        query.setParameter("userRegister", userRegister);

        if (query.list().size() >= 1){
            return false;
        }

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        return true;
    }

    public User login(String username, String password) {
        String stringQuery = "SELECT * FROM User U WHERE U.username = :username AND U.password = :password";
        Query query = HibernateUtil.getCurrentSession().createSQLQuery(stringQuery).addEntity(User.class);

        query.setParameter("username", username);
        query.setParameter("password", password);

        User user;

        List<User> userList = query.list();

        if (userList.size() == 0){
            return null;
        }

        user = userList.get(0);

        return user;
    }

    public List<Text> getTexts() {
        String stringQuery = "FROM Text T";
        Query query = HibernateUtil.getCurrentSession().createQuery(stringQuery);

        List<Text> text = query.list();

        return text;
    }

    public List<Text> getBcTexts(String business_title) {
        String stringQuery = "SELECT * FROM Text T WHERE T.business_title = :business_title";
        Query query = HibernateUtil.getCurrentSession().createSQLQuery(stringQuery).addEntity(Text.class);
        query.setParameter("business_title",business_title);

        List<Text> text = query.list();

        return text;
    }

    public Text getTextDetail(int id){
        String stringQuery = "SELECT * FROM Text T WHERE T.id = :id";
        Query query = HibernateUtil.getCurrentSession().createSQLQuery(stringQuery).addEntity(Text.class);
        query.setParameter("id", id);

        List<Text> texts = query.list();

        return texts.get(0);
    }

    public void addText(Text text, int idUser) {
        String stringQuery = "SELECT * FROM User U WHERE U.id = :idUser";
        Query query = HibernateUtil.getCurrentSession().createSQLQuery(stringQuery).addEntity(User.class);
        query.setParameter("idUser", idUser);

        List<User> userList = query.list();

        if (userList.size() != 0){
            text.setId_user(userList.get(0));
        }

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(text);
        session.getTransaction().commit();
        session.close();
    }
}
