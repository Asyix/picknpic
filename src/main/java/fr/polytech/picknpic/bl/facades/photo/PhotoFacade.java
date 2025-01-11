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
     * Publishes a new photo to the database.
     *
     * @param title                 The title of the photo.
     * @param description           The description of the photo.
     * @param price                 The price of the photo.
     * @param url                   The url of the photo.
     * @param currentUserId         The ID of the user uploading the photo.
     * @param isForSale             Indicates if the photo is for sale.
     * @param isForSubscribersOnly  Indicates if the photo is for subscribers only.
     * @param nbLikes               The initial number of likes for the photo.
     */
    public void publishPhoto(String title, String description, int price, String url, int currentUserId, boolean isForSale, boolean isForSubscribersOnly, int nbLikes) {
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setDescription(description);
        photo.setPrice(price);
        photo.setUrl(url);
        photo.setUserId(currentUserId);
        photo.setIsForSale(isForSale);
        photo.setIsForSubscribersOnly(isForSubscribersOnly);
        photo.setNbLikes(nbLikes);
        photo.setUploadDate(new java.util.Date()); // Set the current date as the upload date

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
    public void updatePhoto(int photoId, String title, String description, int price, String url) {
        Photo photo = getPhotoById(photoId);
        photo.setTitle(title);
        photo.setDescription(description);
        photo.setPrice(price);
        photo.setUrl(url);

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
