package it.gestioneordini.service.ordine;

import java.util.List;

import it.gestioneordini.dao.ordine.OrdineDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.IBaseService;

public interface OrdineService extends IBaseService<Ordine> {

	//per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
	
	public List<Categoria> tutteLeCategorieDiUnOrdine(Ordine ordine) throws Exception;

	public Ordine inserisciArticolo(Ordine o1, Articolo a1) throws Exception;

}
