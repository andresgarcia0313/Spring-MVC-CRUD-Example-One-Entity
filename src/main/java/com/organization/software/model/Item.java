package com.organization.software.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase de modelo que representa un item en la base de datos.
 * Esta clase está marcada con la anotación @Entity, lo que indica que es una
 * entidad persistente que se mapea a una tabla en la base de datos.
 */
@Entity
public class Item {

    // Atributo que representa el ID del item
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributo que representa el nombre del item
    private String name;

    // Atributo que representa la descripción del item
    private String description;

    // Getters y setters para los atributos

    /**
     * Obtiene el ID del item.
     * 
     * @return El ID del item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del item.
     * 
     * @param id El ID a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del item.
     * 
     * @return El nombre del item.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del item.
     * 
     * @param name El nombre a establecer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la descripción del item.
     * 
     * @return La descripción del item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del item.
     * 
     * @param description La descripción a establecer.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
