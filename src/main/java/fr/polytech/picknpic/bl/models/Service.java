package fr.polytech.picknpic.bl.models;

/**
 * Represents a service in the application.
 * Contains details such as the service ID, owner, name, example image, price, description, and the number of buyers.
 */
public class Service {

    /** The unique identifier of the service. */
    private int id_service;

    /** The unique identifier of the user who owns the service. */
    private int id_user_owner;

    /** The name of the service. */
    private String name;

    /** The example image of the service. */
    private String example_image;

    /** The price of the service. */
    private float price;

    /** The description of the service. */
    private String description;

    /** The number of buyers of the service. */
    private int nb_buyers;

    // Getters and Setters

    /**
     * Gets the service ID.
     *
     * @return the service ID.
     */
    public int getIdService() {
        return id_service;
    }

    /**
     * Sets the service ID.
     *
     * @param id_service the service ID to set.
     */
    public void setIdService(int id_service) {
        this.id_service = id_service;
    }

    /**
     * Gets the user owner ID.
     *
     * @return the user owner ID.
     */
    public int getIdUserOwner() {
        return id_user_owner;
    }

    /**
     * Sets the user owner ID.
     *
     * @param id_user_owner the user owner ID to set.
     */
    public void setIdUserOwner(int id_user_owner) {
        this.id_user_owner = id_user_owner;
    }

    /**
     * Gets the name of the service.
     *
     * @return the name of the service.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the service.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the example image of the service.
     *
     * @return the example image of the service.
     */
    public String getExampleImage() {
        return example_image;
    }

    /**
     * Sets the example image of the service.
     *
     * @param example_image the example image to set.
     */
    public void setExampleImage(String example_image) {
        this.example_image = example_image;
    }

    /**
     * Gets the price of the service.
     *
     * @return the price of the service.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the service.
     *
     * @param price the price to set.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Gets the description of the service.
     *
     * @return the description of the service.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the service.
     *
     * @param description the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the number of buyers of the service.
     *
     * @return the number of buyers.
     */
    public int getNbBuyers() {
        return nb_buyers;
    }

    /**
     * Sets the number of buyers of the service.
     *
     * @param nb_buyers the number of buyers to set.
     */
    public void setNbBuyers(int nb_buyers) {
        this.nb_buyers = nb_buyers;
    }
}