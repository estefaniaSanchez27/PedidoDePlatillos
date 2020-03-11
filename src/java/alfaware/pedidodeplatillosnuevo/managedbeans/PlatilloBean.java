/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.IngredienteController;
import alfaware.pedidodeplatillosnuevo.controllers.PlatilloController;
import alfaware.pedidodeplatillosnuevo.controllers.PlatilloIngredienteController;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platilloingrediente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@ManagedBean
@Named(value = "platilloBean")
@SessionScoped
public class PlatilloBean implements Serializable {

    private String id;
    private String nombre;
    private Double costoPrep;
    private boolean disable;

    private PlatilloController platilloController;
    private PlatilloIngredienteController platilloingredienteController;
    private IngredienteController ingredienteController;
    Platillo pl = new Platillo();
    Ingrediente i = new Ingrediente();
    IngredienteBean ib = new IngredienteBean();
    Platilloingrediente plaing = new Platilloingrediente();
    private List<Ingrediente> ingredientes;
    private List<Ingrediente> ingrePla;
    private List<Ingrediente> ingreDispo;

    @PostConstruct
    public void init() {
        platilloController = new PlatilloController();
        platilloingredienteController = new PlatilloIngredienteController();
        ingredienteController = new IngredienteController();
        ingredientes = new ArrayList();
        ingrePla = new ArrayList();
        ingreDispo = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoPrep() {
        return costoPrep;
    }

    public void setCostoPrep(Double costoPrep) {
        this.costoPrep = costoPrep;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<Ingrediente> getIngrePla() {
        return ingrePla;
    }

    public void setIngrePla(List<Ingrediente> ingrePla) {
        this.ingrePla = ingrePla;
    }

    /*public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }*/
    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngreDispo() {
        return ingreDispo;
    }

    public void setIngreDispo(List<Ingrediente> ingreDispo) {
        this.ingreDispo = ingreDispo;
    }


    /*public String guardar() {
        this.platilloController.insert(pl, nombre, costoPrep);
        return "platillo";
    }

    public String editar(PlatilloBean plb) {
        this.platilloController.update(pl, id, plb.nombre, plb.costoPrep);
        return "platillo";
    }*/
    public String guarduar(PlatilloBean bl) {
        if (this.disable == true) {
            this.platilloController.update(pl, id, bl.nombre, bl.costoPrep);
            return "platillo";
        } else {
            this.platilloController.insert(pl, nombre, costoPrep);
            return "platillo";
        }
    }

    public String eliminar() {
        this.platilloController.delete(pl, id);
        return "platillo";
    }

    public List<Platillo> getPlatillos() {
        Map<String, Object> plat = this.platilloController.select(new Platillo());
        List<Platillo> result = new ArrayList(plat.values());
        return result;
    }

    public List<Ingrediente> obtenerIngredientesdePlatillo(Platillo p, String id) {
        Map<String, Object> ing = this.platilloingredienteController.obtenerIngredientesdePlatillo(p, i, plaing, id);
        List<Ingrediente> ingre = new ArrayList(ing.values());
        return ingre;
    }

    public List<Ingrediente> getIngredientes() {
        /*if (ingredientes == null) {
            //this.ingredientes = this.obtenerIngredientes();
            this.ingredientes = this.obtenerIngredientes();
        }*/

        return ingredientes;
    }

    public List<Ingrediente> obtenerIngredientes() {
        Map<String, Object> ing = this.ingredienteController.select(new Ingrediente());
        List<Ingrediente> listing = new ArrayList(ing.values());
        //List<Ingrediente> listplaing = this.ingrePla;
        //List<Ingrediente> resultado = new ArrayList<>();
        //resultado.addAll(listing);
        //resultado.retainAll(listplaing);        
        return listing;
    }

    public String limpiar() {
        this.setNombre(null);
        this.setCostoPrep(null);
        this.disable = false;
        return "platillo";
    }

    public void onSelect(Platillo pla) {
        this.id = pla.getId();
        this.nombre = pla.getNombre();
        this.costoPrep = pla.getCostoPrep();
        this.disable = true;
        this.ingrePla = this.obtenerIngredientesdePlatillo(pla, pla.getId());
        this.ingredientes = this.obtenerIngredientes();
        //this.ingredientes = new ArrayList();
        //this.ingreDispo = Stream.concat(ingredientes.stream(), ingrePla.stream()).distinct().collect(Collectors.toList());
        //this.ingredientes.removeAll(ingrePla);
        this.ingreDispo = this.diferencia(ingrePla, ingredientes);

    }

    public void onDeselect() {
        this.nombre = null;
        this.costoPrep = null;
        this.disable = false;
    }

    public void insertarIngredienteaPlatillo(Ingrediente i) {
        this.platilloingredienteController.insert(new Platilloingrediente(), i.getId(), id);
        this.ingrePla = this.obtenerIngredientesdePlatillo(pl, id);
        Ingrediente ingBus = i;
        int posicion = this.ingreDispo.indexOf(ingBus);
        this.ingreDispo.remove(posicion);
    }

    public void eliminarIngredienteaPlatillo(Ingrediente i) {
        this.platilloingredienteController.delete(i, id, new Platilloingrediente());
        this.ingrePla = this.obtenerIngredientesdePlatillo(pl, id);
        this.ingreDispo.add(i);
    }

    /*public List<Ingrediente> interseccion(List<Ingrediente> lista1, List<Ingrediente> lista2){
        Iterator<Ingrediente> i;
        Iterator<Ingrediente> j;
        List<Ingrediente> listafinal = new ArrayList();
        Ingrediente ingrediente1, ingrediente2;
        i=lista1.iterator();
        j=lista2.iterator();
        
        while(i.hasNext()){
            ingrediente1=i.next();
            
            while(j.hasNext()){
                ingrediente2=j.next();
                
                if(ingrediente1.equals(ingrediente2)){
                    listafinal.add(ingrediente1);
                }
            }
            j=lista2.iterator();
        }
        return listafinal;
    }*/
    public List<Ingrediente> diferencia(List<Ingrediente> lista1, List<Ingrediente> lista2) {
        Iterator<Ingrediente> i;
        Iterator<Ingrediente> j;
        //List<Ingrediente> listafinal=new ArrayList<>();
        List<Ingrediente> l2 = new ArrayList<>();
        l2.addAll(lista2);
        Ingrediente i1, i2;
        i = lista1.iterator();
        j = l2.iterator();

        while (i.hasNext()) {
            i1 = i.next();
            //i2=j.next();
            //if(!i1.getId().equals(i2.getId())){
            //  listafinal.add(i2);
            //}

            /*if(!lista2.contains(i1.getId())){
                listafinal.add(i1);
            }*/
            while (j.hasNext()) {
                i2 = j.next();
                if (i1.getId().equals(i2.getId())) {
                    lista2.remove(i2);
                } else {

                }
            }
            j = l2.iterator();

        }
        return lista2;
    }

    //public List<Ingrediente> compararlistas(){
    //}

    /*public int buscarIngrediente(String nombre) {
        int index = 0;
        for (Ingrediente item : ingredientes) {
            while (ingredientes.iterator().hasNext()) {
                if (ingredientes.stream().anyMatch(i -> i.getNombre().equals(nombre))) {
                    index = ingredientes.indexOf(item);
                    break;
                }
            }
        }

        return index;
    }*/
    /**
     * Creates a new instance of PlatilloBean
     */
    public PlatilloBean() {
        this.disable = false;
    }

}
