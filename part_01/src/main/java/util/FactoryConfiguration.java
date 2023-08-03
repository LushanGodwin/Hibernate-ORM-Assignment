package util;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        //Factory Configuration
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Book.class);
        //create session
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration == null){
            return factoryConfiguration = new FactoryConfiguration();
        }else {
            return factoryConfiguration;
        }
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
