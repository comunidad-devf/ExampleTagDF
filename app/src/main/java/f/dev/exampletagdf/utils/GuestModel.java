package f.dev.exampletagdf.utils;

/**
 * Created by sati on 01/07/2015.
 */
public class GuestModel {

    private int idImage;
    private int idName;


    public GuestModel(int idImage, int idName) {
        this.idImage = idImage;
        this.idName = idName;
    }


    public int getIdImage() {
        return idImage;
    }

    public int getIdName() {
        return idName;
    }
}
