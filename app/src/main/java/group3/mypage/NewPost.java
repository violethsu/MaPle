package group3.mypage;



public class NewPost {




    private int postId, pictureId;
    private  String location, comment, countryCode,address,district;
    private double longitude,latitude;






    public NewPost(int postId, int pictureId, String comment) {
        this.postId = postId;
        this.pictureId = pictureId;
        this.comment = comment;
    }


    public NewPost(String countryCode, String address, String district, double longitude, double latitude) {

        this.countryCode = countryCode;
        this.address = address;
        this.district = district;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public NewPost(int postId, int pictureId, String location, String comment, String countryCode, String address, String district, double longitude, double latitude) {
        this.postId = postId;
        this.pictureId = pictureId;
        this.location = location;
        this.comment = comment;
        this.countryCode = countryCode;
        this.address = address;
        this.district = district;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


}
