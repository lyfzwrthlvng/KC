package KC;

import KC.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.io.File;
import java.util.ArrayList;

public class DbOperations {
    public static SessionFactory factoryS = null;
    public static SessionFactory getSessionFactory() {
        Configuration config = new Configuration();
        config.configure(new File("/Users/shrey.malik/machines/revel/KC/src/resources/hibernate.cfg.xml"));
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

    public static int persistKCEntity(KCEntity entity) {
        Session session = getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(entity);

        session.close();
        return entity.getId();
    }

    public static KnowledgeTag getKnowledgeTag(String tag) {
        Session session = getSessionFactory().openSession();
        TypedQuery query = session.getNamedQuery("findTagByKeyword");
        query.setParameter("keyword",tag);
        KnowledgeTag knowledgeTag = (KnowledgeTag) query.getSingleResult();
        return knowledgeTag;
    }

    public static ArrayList<Knowledge> getKnowledge(KnowledgeTag tag) {
        ArrayList<Knowledge> knowledges = new ArrayList<>();
        Session session = getSessionFactory().openSession();
        TypedQuery<KnowledgeMapping> kmQuery = session.getNamedQuery("findKnowledgeMappingByTagId");
        kmQuery.setParameter("tagId", tag.getId());
        ArrayList<KnowledgeMapping> mappings = (ArrayList<KnowledgeMapping>) kmQuery.getResultList();
        for(KnowledgeMapping mapping: mappings) {
            Knowledge knowledge = session.get(Knowledge.class, mapping.getCloudId());
            knowledges.add(knowledge);
        }
        return knowledges;
    }
}
