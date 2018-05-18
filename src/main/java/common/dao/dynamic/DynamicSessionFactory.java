package common.dao.dynamic;

import org.hibernate.SessionFactory;

public interface DynamicSessionFactory extends SessionFactory { 
	public SessionFactory getHibernateSessionFactory();
}
