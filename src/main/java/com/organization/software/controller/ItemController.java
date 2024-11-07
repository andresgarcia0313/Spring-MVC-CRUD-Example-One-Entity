package com.organization.software.controller;

import com.organization.software.model.Item;
import com.organization.software.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los items.
 * Este controlador maneja la lógica para listar, crear, editar y eliminar items.
 * Se integra con la capa de persistencia a través del repositorio ItemRepository.
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    // Repositorio utilizado para acceder a los datos de los items en la base de datos
    private final ItemRepository itemRepository;

    // Constante para manejar la redirección a la lista de items de manera uniforme
    // Esto facilita la mantenibilidad, evitando errores de escritura al usar la URL de redirección en varios lugares
    private static final String REDIRECT_ITEMS = "redirect:/items";

    /**
     * Constructor del controlador. Utiliza inyección de dependencias para obtener una instancia del repositorio.
     * 
     * @param itemRepository Instancia del repositorio que maneja los items.
     */
    public ItemController(ItemRepository itemRepository) { 
        // Inyecta el repositorio para que pueda ser utilizado en las acciones del controlador
        this.itemRepository = itemRepository; 
    }

    /**
     * Maneja la solicitud GET a "/items" para listar todos los items en la base de datos.
     * 
     * @param model El objeto que transporta los atributos para la vista.
     * @return La vista que lista los items.
     */
    @GetMapping
    public String listItems(Model model) {
        // Agrega la lista de todos los items al modelo para que estén disponibles en la vista
        model.addAttribute("items", itemRepository.findAll());
        // Retorna la vista que muestra la lista de items
        return "items/list";
    }

    /**
     * Muestra el formulario para crear un nuevo item.
     * 
     * @param model El objeto que transporta los atributos para la vista.
     * @return La vista del formulario para crear un item.
     */

    @GetMapping("/new") 
    public String newItemForm(Model model) {
        // Crea un nuevo objeto de tipo Item y lo agrega al modelo, este objeto se usará en el formulario
        model.addAttribute("item", new Item());
        // Retorna la vista del formulario para crear un nuevo item
        return "items/form";
    }

    /**
     * Guarda un nuevo item en la base de datos.
     * 
     * @param item El objeto Item con los datos ingresados por el usuario en el formulario.
     * @return Redirige a la lista de todos los items después de guardar el nuevo item.
     */
    @PostMapping
    public String saveItem(@ModelAttribute Item item) {
        // Guarda el nuevo item utilizando el repositorio
        itemRepository.save(item);
        // Redirige a la lista de items después de guardar el nuevo item
        return REDIRECT_ITEMS;
    }

    /**
     * Muestra el formulario para editar un item existente.
     * 
     * @param id El id del item que se va a editar.
     * @param model El objeto que transporta los atributos para la vista.
     * @return La vista del formulario con los datos del item para editar.
     */
    @GetMapping("/edit/{id}") 
    public String editItem(@PathVariable Long id, Model model) {
        // Busca el item por su id. Si no se encuentra, lanza una excepción.
        model.addAttribute(
                "item", 
            itemRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Invalid item ID")
                    )
        );
        // Retorna la vista para editar el item
        return "items/form";
    }

    /**
     * Actualiza un item existente en la base de datos.
     * 
     * @param id El id del item que se va a actualizar.
     * @param item El objeto Item con los datos actualizados del formulario.
     * @return Redirige a la lista de todos los items después de actualizar el item.
     */
    @PostMapping("/update/{id}") 
    public String updateItem(
            @PathVariable Long id,  // Obtiene el id del item desde la URL
            @ModelAttribute Item item // Obtiene los datos del item desde el formulario
    ) {
        // Establece el id del item antes de guardarlo para que el repositorio sepa que es una actualización
        item.setId(id);
        // Guarda el item actualizado
        itemRepository.save(item);
        // Redirige a la lista de items después de la actualización
        return REDIRECT_ITEMS;
    }

    /**
     * Elimina un item de la base de datos por su id.
     * 
     * @param id El id del item que se va a eliminar.
     * @return Redirige a la lista de todos los items después de eliminar el item.
     */
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        // Elimina el item utilizando el repositorio por su id
        itemRepository.deleteById(id);
        // Redirige a la lista de items después de eliminar el item
        return REDIRECT_ITEMS;
    }
}
