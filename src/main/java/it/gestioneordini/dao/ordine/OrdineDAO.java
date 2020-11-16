package it.gestioneordini.dao.ordine;

import java.util.List;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.*;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	
	public List<Categoria> findAllCategorieByOrdine(Ordine ordine) throws Exception;

}
