package it.gestioneordini.dao.ordine;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine",Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(o);
	}

	@Override
	public void delete(Ordine o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Categoria> findAllCategorieByOrdine(Ordine ordine) throws Exception {
		Set<Categoria> lc= new HashSet<>();
		String q="select o.articoli from Ordine o where o.id=?1";
		TypedQuery<Collection> query = entityManager.createQuery(q,Collection.class);
		List<Collection> lista_articoli =query.setParameter(1, ordine.getId()).getResultList();
		
		for(int i=0;i<lista_articoli.size();i++) {
			Articolo ar=(Articolo)lista_articoli.get(i);
			lc.addAll(ar.getCategorie());
		}
		return lc.stream().collect(Collectors.toList());
	}

}
