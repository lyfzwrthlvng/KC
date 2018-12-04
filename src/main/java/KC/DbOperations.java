package KC;

import KC.entities.Knowledge;
import KC.entities.KnowledgeMapping;
import KC.entities.KnowledgeTag;
import KC.entities.UserKC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbOperations {
    public static SessionFactory factoryS = null;
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        registerEntities(config);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(registry);
        factoryS = factory;
        return factory;
    }

    private static void registerEntities(Configuration config) {
        config.addAnnotatedClass(KC.entities.Knowledge.class);
        config.addAnnotatedClass(KC.entities.KnowledgeTag.class);
        config.addAnnotatedClass(KC.entities.KnowledgeMapping.class);
        config.addAnnotatedClass(KC.entities.UserKC.class);
    }

    // move this logic away, keep only session factory here TODO
    public static int persistKnowledge(Knowledge knowledge) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(knowledge);
        transaction.commit();

        session.close();
        return knowledge.getId();
    }

    public static int persistKnowledgeTag(KnowledgeTag tag) {
        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(tag);

        session.close();
        return tag.getId();
    }

    public static int persistKnowledgeMapping(KnowledgeMapping mapping) {
        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(mapping);

        session.close();
        return mapping.getId();
    }

    // TODO: refactor all this, this is all duplicate code, could be fixed via template etc
    public static int persistUserKC(UserKC userKC) {
        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(userKC);

        session.close();
        return userKC.getId();
    }
}
