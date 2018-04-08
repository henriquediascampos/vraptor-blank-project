package br.com.caelum.vraptor.hibernateUtil;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@ApplicationScoped
public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	@Produces
	@RequestScoped
	public Session getCurrentSession() {
		Session session = fabricaDeSessoes.openSession();
		return session;
	}
	
	// @Produces
	// @RequestScoped
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	//@PostConstruct
	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao =new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder()
					.applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
