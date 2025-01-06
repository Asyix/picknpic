package fr.polytech.picknpic.bl.models;

/**
 * Represents a service in the application.
 * Contains details such as the service ID, owner, name, example image, price, description, and the number of buyers.
 */
public class Service {

    private int id_service;
    private int id_user_owner;
    private String name;
    private String example_image;
    private float price;
    private String description;
    private int nb_buyers;

    // Getters and Setters

    public int getIdService() {
        return id_service;
    }

    public void setIdService(int id_service) {
        this.id_service = id_service;
    }

    public int getIdUserOwner() {
        return id_user_owner;
    }

    public void setIdUserOwner(int id_user_owner) {
        this.id_user_owner = id_user_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExampleImage() {
        return example_image;
    }

    public void setExampleImage(String example_image) {
        this.example_image = example_image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbBuyers() {
        return nb_buyers;
    }

    public void setNbBuyers(int nb_buyers) {
        this.nb_buyers = nb_buyers;
    }

}
