package com.example.laboratorio1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Categoria {
    private String id;
    private String titulo;

    public Categoria(){}

    public Categoria(Consumer<Categoria> c){
        c.accept(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo.substring(0,3)+" ";
    }

    public static List<Categoria> ejemplos(){

        ArrayList<Categoria> as = new ArrayList<>();
        as.add( new Categoria(
                s -> {
                    s.setId("MLA5725");
                    s.setTitulo("Accesorios para Vehículos");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1512");
                    s.setTitulo("Agro");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1403");
                    s.setTitulo("Alimentos y Bebidas");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1071");
                    s.setTitulo("Animales y Mascotas");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1367");
                    s.setTitulo("Antigüedades y Colecciones");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1368");
                    s.setTitulo("Arte, Librería y Mercería");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1743");
                    s.setTitulo("Autos, Motos y Otros");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1384");
                    s.setTitulo("Bebés");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1246");
                    s.setTitulo("Belleza y Cuidado Personal");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1039");
                    s.setTitulo("Cámaras y Accesorios");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1051");
                    s.setTitulo("Celulares y Teléfonos");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1648");
                    s.setTitulo("Computación");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1144");
                    s.setTitulo("Consolas y Videojuegos");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1500");
                    s.setTitulo("Construcción");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1276");
                    s.setTitulo("Deportes y Fitness");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA5726");
                    s.setTitulo("Electrodomésticos y Aires Ac.");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1000");
                    s.setTitulo("Electrónica, Audio y Video");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA2547");
                    s.setTitulo("Entradas para Eventos");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA407134");
                    s.setTitulo("Herramientas");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1574");
                    s.setTitulo("Hogar, Muebles y Jardín");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1499");
                    s.setTitulo("Industrias y Oficinas");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1459");
                    s.setTitulo("Inmuebles");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1182");
                    s.setTitulo("Instrumentos Musicales");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA3937");
                    s.setTitulo("Joyas y Relojes");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1132");
                    s.setTitulo("Juegos y Juguetes");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA3025");
                    s.setTitulo("Libros, Revistas y Comics");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1168");
                    s.setTitulo("Música, Películas y Series");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1430");
                    s.setTitulo("Ropa y Accesorios");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA409431");
                    s.setTitulo("Salud y Equipamiento Médico");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1540");
                    s.setTitulo("Servicios");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA9304");
                    s.setTitulo("Souvenirs, Cotillón y Fiestas");
                }
        ));
        as.add( new Categoria(
                s -> {
                    s.setId("MLA1953");
                    s.setTitulo("Otras categorías");
                }
        ));
        return as;
    }

}
