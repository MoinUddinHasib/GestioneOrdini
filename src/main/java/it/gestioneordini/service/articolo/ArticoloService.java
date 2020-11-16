package it.gestioneordini.service.articolo;

import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.IBaseService;

public interface ArticoloService extends IBaseService<Articolo> {

	//per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);

	public Ordine inserisciOrdine(Articolo a1, Ordine o1) throws Exception;

	public Articolo inserisciCategoria(Articolo a1, Categoria c1) throws Exception;

}
