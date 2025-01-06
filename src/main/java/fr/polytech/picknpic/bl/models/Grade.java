package fr.polytech.picknpic.bl.models;

/**
 * Represents a grade for a service in the application.
 * This class contains details about the grading criteria,
 * such as friendliness, rapidity, and quality, along with an average grade.
 */
public class Grade {

    /** Unique identifier for the grade. */
    private int id_grade;

    /** Identifier of the user being graded. */
    private int id_user_graded;

    /** Identifier of the service being graded. */
    private int id_service_graded;

    /** Grade for friendliness. */
    private int friendliness;

    /** Grade for rapidity. */
    private int rapidity;

    /** Grade for quality. */
    private int quality;

    /** Average grade based on the individual criteria. */
    private float avg_grade;

    /**
     * Gets the unique identifier for the grade.
     *
     * @return the grade ID.
     */
    public int getIdGrade() {
        return id_grade;
    }

    /**
     * Sets the unique identifier for the grade.
     *
     * @param id_grade the grade ID to set.
     */
    public void setIdGrade(int id_grade) {
        this.id_grade = id_grade;
    }

    /**
     * Gets the identifier of the user being graded.
     *
     * @return the user ID being graded.
     */
    public int getIdUserGraded() {
        return id_user_graded;
    }

    /**
     * Sets the identifier of the user being graded.
     *
     * @param id_user_graded the user ID to set.
     */
    public void setIdUserGraded(int id_user_graded) {
        this.id_user_graded = id_user_graded;
    }

    /**
     * Gets the identifier of the service being graded.
     *
     * @return the service ID being graded.
     */
    public int getIdServiceGraded() {
        return id_service_graded;
    }

    /**
     * Sets the identifier of the service being graded.
     *
     * @param id_service_graded the service ID to set.
     */
    public void setIdServiceGraded(int id_service_graded) {
        this.id_service_graded = id_service_graded;
    }

    /**
     * Gets the grade for friendliness.
     *
     * @return the friendliness grade.
     */
    public int getFriendliness() {
        return friendliness;
    }

    /**
     * Sets the grade for friendliness.
     *
     * @param friendliness the friendliness grade to set.
     */
    public void setFriendliness(int friendliness) {
        this.friendliness = friendliness;
    }

    /**
     * Gets the grade for rapidity.
     *
     * @return the rapidity grade.
     */
    public int getRapidity() {
        return rapidity;
    }

    /**
     * Sets the grade for rapidity.
     *
     * @param rapidity the rapidity grade to set.
     */
    public void setRapidity(int rapidity) {
        this.rapidity = rapidity;
    }

    /**
     * Gets the grade for quality.
     *
     * @return the quality grade.
     */
    public int getQuality() {
        return quality;
    }

    /**
     * Sets the grade for quality.
     *
     * @param quality the quality grade to set.
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * Gets the average grade based on the individual criteria.
     *
     * @return the average grade.
     */
    public float getAvgGrade() {
        return avg_grade;
    }

    /**
     * Sets the average grade based on the individual criteria.
     *
     * @param avg_grade the average grade to set.
     */
    public void setAvgGrade(float avg_grade) {
        this.avg_grade = avg_grade;
    }
}
