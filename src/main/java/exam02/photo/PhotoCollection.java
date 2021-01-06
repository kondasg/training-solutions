package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... photos) {
        for (String name : photos) {
            this.photos.add(new Photo(name));
        }
    }

    public void starPhoto(String name, Quality quality) {
        boolean noPhoto = true;
        for (Photo photo : photos) {
            if (name.equals(photo.getName())) {
                photo.setQuality(quality);
                noPhoto = false;
            }
        }
        if (noPhoto) {
            throw new PhotoNotFoundException();
        }
    }

    public int numberOfStars() {
        int sumStar = 0;
        for (Photo photo : photos) {
            sumStar += photo.getQuality().getValue();
        }
        return sumStar;
    }


}
