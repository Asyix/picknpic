package fr.polytech.picknpic.bl.facades.photo;

import fr.polytech.picknpic.bl.models.Photo;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.PhotoDAO;

import java.util.List;

/**
 * Facade for managing photo-related operations in the application.
 * Provides an abstraction layer between the business logic and the data access layer.
 * Implements the Singleton design pattern.
 */
public class PhotoFacade {

    private final AbstractFactory abstractFactory;
    private static PhotoFacade photoFacade;

    /**
     * Private constructor to initialize the facade with the abstract factory.
     */
    private PhotoFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the PhotoFacade.
     *
     * @return The singleton instance of PhotoFacade.
     */
    public static PhotoFacade getPhotoFacadeInstance() {
        if (photoFacade == null) {
            photoFacade = new PhotoFacade();
        }
        return photoFacade;
    }

    /**
     * Retrieves all photos from the database.
     *
     * @return A list of all photos.
     */
    public List<Photo> getAllPhotos() {
        PhotoDAO photoDAO = abstractFactory.createPhotoDAO();
        return photoDAO.getAllPhotos();
    }

    /**
     * Retrieves a photo by its ID.
     *
     * @param photoId The ID of the photo to retrieve.
     * @return The photo object corresponding to the given ID.
     */
    public Photo getPhotoById(int photoId) {
        PhotoDAO photoDAO = abstractFactory.createPhotoDAO();
        return photoDAO.getPhotoById(photoId);
    }

    /**
     * Adds a new photo to the database.
     *
     * @param title       The title of the photo.
     * @param description The description of the photo.
     * @param price       The price of the photo.
     * @param filePath    The file path of the photo.
     */
    public void addPhoto(String title, String description, int price, String filePath) {
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setDescription(description);
        photo.setPrice(price);
        photo.setFilePath(filePath);

        PhotoDAO photoDAO = abstractFactory.createPhotoDAO();
        photoDAO.publishPhoto(photo);
    }

    /**
     * Updates an existing photo in the database.
     *
     * @param photoId     The ID of the photo to update.
     * @param title       The updated title of the photo.
     * @param description The updated description of the photo.
     * @param price       The updated price of the photo.
     * @param filePath    The updated file path of the photo.
     */
    public void updatePhoto(int photoId, String title, String description, int price, String filePath) {
        Photo photo = getPhotoById(photoId);
        photo.setTitle(title);
        photo.setDescription(description);
        photo.setPrice(price);
        photo.setFilePath(filePath);

        PhotoDAO photoDAO = abstractFactory.createPhotoDAO();
        photoDAO.updatePhoto(photo);
    }

    /**
     * Deletes a photo from the database by its ID.
     *
     * @param photoId The ID of the photo to delete.
     */
    public void deletePhoto(int photoId) {
        PhotoDAO photoDAO = abstractFactory.createPhotoDAO();
        photoDAO.deletePhoto(photoId);
    }
}
