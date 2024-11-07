package com.organization.software.repository;

import com.organization.software.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de acceso a los datos de la entidad Item.
 * Este repositorio extiende de JpaRepository, lo que proporciona métodos básicos para manejar
 * operaciones de persistencia de datos (guardar, eliminar, actualizar, etc.) automáticamente.
 * Además, define consultas personalizadas específicas para buscar y contar items.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Encuentra un item por su nombre.
     * 
     * @param name El nombre del item que se desea encontrar.
     * @return Un objeto Item si se encuentra un item con el nombre especificado, o null si no existe.
     */
    Item findByName(String name); // Consulta de encontrar por nombre

    /**
     * Encuentra todos los items cuya descripción contiene una palabra clave.
     * 
     * @param keyword La palabra clave que se buscará dentro de las descripciones de los items.
     * @return Una lista de items cuyas descripciones contienen la palabra clave.
     */
    List<Item> findByDescriptionContaining(String keyword); // Consulta de encontrar por descripción

    /**
     * Cuenta cuántos items existen con el mismo nombre.
     * 
     * @param name El nombre del item para contar cuántos existen con ese nombre.
     * @return El número de items que tienen el nombre especificado.
     */
    Long countByName(String name); // Consulta de contar por nombre

    /**
     * Verifica si existe al menos un item con el nombre especificado.
     * 
     * @param name El nombre del item a verificar.
     * @return true si existe al menos un item con ese nombre, de lo contrario false.
     */
    boolean existsByName(String name); // Consulta de existir por nombre

    /**
     * Encuentra todos los items ordenados por su nombre de forma ascendente.
     * 
     * @return Una lista de items ordenada alfabéticamente por su nombre.
     */
    List<Item> findAllByOrderByNameAsc(); // Consulta de encontrar todos ordenados por nombre

    /**
     * Encuentra todos los items cuyo nombre de descripción coincida exactamente (sin importar mayúsculas o minúsculas).
     * 
     * @param description La descripción para la búsqueda sin considerar el caso (mayúsculas/minúsculas).
     * @return Una lista de items cuya descripción coincida con el parámetro.
     */
    List<Item> findByDescriptionIgnoreCase(String description); // Consulta de encontrar por descripción ignorando mayúsculas y minúsculas

    /**
     * Encuentra todos los items que coincidan tanto con el nombre como con la descripción especificados.
     * 
     * @param description La descripción que debe coincidir.
     * @param name El nombre que debe coincidir.
     * @return Una lista de items que coincidan con ambos parámetros.
     */
    List<Item> findByDescriptionAndName(String description, String name); // Consulta de encontrar por descripción y nombre

    /**
     * Encuentra todos los items cuyo nombre contenga una parte específica del nombre.
     * 
     * @param name La parte del nombre a buscar dentro de los items.
     * @return Una lista de items cuyos nombres contienen el texto proporcionado.
     */
    List<Item> findByNameContaining(String name); // Consulta de encontrar por nombre conteniendo

}
