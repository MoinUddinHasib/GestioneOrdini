package it.gestioneordini.main;

import javax.persistence.EntityManager;

import it.gestioneordini.dao.EntityManagerUtil;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.MyServiceFactory;
import it.gestioneordini.service.articolo.ArticoloService;
import it.gestioneordini.service.categoria.CategoriaService;
import it.gestioneordini.service.ordine.OrdineService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {
			
			Articolo a1=new Articolo("d1",2);
			Articolo a2=new Articolo("d2",3);
			Articolo a3=new Articolo("d3",7);
			Articolo a4=new Articolo("d4",9);
			Articolo a5=new Articolo("d5",11);
			
			Categoria c1=new Categoria("dd1");
			Categoria c2=new Categoria("dd2");
			Categoria c3=new Categoria("dd3");
			
			Ordine o1=new Ordine("n1","i1");
			Ordine o2=new Ordine("n2","i2");
			
			categoriaServiceInstance.inserisciNuovo(c1);
			categoriaServiceInstance.inserisciNuovo(c2);
			categoriaServiceInstance.inserisciNuovo(c3);
			
			a1=articoloServiceInstance.inserisciCategoria(a1,c1);
			a2=articoloServiceInstance.inserisciCategoria(a2,c1);
			a3=articoloServiceInstance.inserisciCategoria(a3,c1);
			a4=articoloServiceInstance.inserisciCategoria(a4,c2);
			a5=articoloServiceInstance.inserisciCategoria(a5,c3);
			
			c1=categoriaServiceInstance.inserisciArticolo(c1,a1);
			c1=categoriaServiceInstance.inserisciArticolo(c1,a2);
			c1=categoriaServiceInstance.inserisciArticolo(c1,a3);
			c2=categoriaServiceInstance.inserisciArticolo(c2,a4);
			c3=categoriaServiceInstance.inserisciArticolo(c3,a5);
			
			
			o1=ordineServiceInstance.inserisciArticolo(o1,a1);
			o1=ordineServiceInstance.inserisciArticolo(o1,a2);
			o1=ordineServiceInstance.inserisciArticolo(o1,a3);
			o2=ordineServiceInstance.inserisciArticolo(o2,a4);
			o2=ordineServiceInstance.inserisciArticolo(o2,a5);
			
			o1=articoloServiceInstance.inserisciOrdine(a1,o1);
			o1=articoloServiceInstance.inserisciOrdine(a2,o1);
			o1=articoloServiceInstance.inserisciOrdine(a3,o1);
			o2=articoloServiceInstance.inserisciOrdine(a4,o2);
			o2=articoloServiceInstance.inserisciOrdine(a5,o2);
		
			System.out.println("Elenco articoli: ");
			for (Articolo articoloItem : articoloServiceInstance.listAll()) {
				System.out.println(articoloItem);
			}
			
			System.out.println("Elenco categorie: ");
			for (Categoria categoriaIteam : categoriaServiceInstance.listAll()) {
				System.out.println(categoriaIteam);
			}
			
			System.out.println("Elenco ordini: ");
			for (Ordine ordineItem : ordineServiceInstance.listAll()) {
				System.out.println(ordineItem);
			}
			
			System.out.println("-----------------------------------------1----------------------------------------------------------");
			categoriaServiceInstance.tuttiGliOrdiniDiUnaCategoria(
					categoriaServiceInstance.caricaSingoloElemento(1L)).forEach(o -> System.out.println(o));
			System.out.println("-----------------------------------------2----------------------------------------------------------");
			ordineServiceInstance.tutteLeCategorieDiUnOrdine(
					ordineServiceInstance.caricaSingoloElemento(1L)).forEach(c -> System.out.println(c));
			System.out.println("-----------------------------------------3----------------------------------------------------------");
			System.out.println(categoriaServiceInstance.totalePrezziDiUnaCategoria(
					categoriaServiceInstance.caricaSingoloElemento(1L)));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
    }
}
