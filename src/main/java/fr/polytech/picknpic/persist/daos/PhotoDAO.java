package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Photo;
import java.util.List;

/**
 * Interface for photo-related data access operations.
 * Provides methods for CRUD operations and fetching photo data.
 */
public interface PhotoDAO {

    /**
     * Publishes a new photo by inserting it into the database.
     *
     * @param photo The photo to be published.
     */
    void publishPhoto(Photo photo);

    /**
     * Updates the details of an existing photo in the database.
     *
     * @param photo The photo with updated information.
     */
    void updatePhoto(Photo photo);

    /**
     * Deletes a photo from the database by its ID.
     *
     * @param photoId The ID of the photo to be deleted.
     */
    void deletePhoto(int photoId);

    /**
     * Retrieves a photo by its ID.
     *
     * @param photoId The ID of the photo to be retrieved.
     * @return The photo object corresponding to the ID, or null if not found.
     */
    Photo getPhotoById(int photoId);

    /**
     * Retrieves all photos from the database.
     *
     * @return A list of all photos in the database.
     */
    List<Photo> getAllPhotos();
}
