package com.skeleton.model;

/**
 * Created by user on 5/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDetails {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("orientation")
    @Expose
    private String orientation;
    @SerializedName("newNumber")
    @Expose
    private String newNumber;
    @SerializedName("userImages")
    @Expose
    private List<UserImage> userImages = null;
    @SerializedName("admin_deactivateAccount")
    @Expose
    private Boolean adminDeactivateAccount;
    @SerializedName("timeOffset")
    @Expose
    private Integer timeOffset;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("aboutMe")
    @Expose
    private String aboutMe;
    @SerializedName("step2CompleteOrSkip")
    @Expose
    private Boolean step2CompleteOrSkip;
    @SerializedName("step1CompleteOrSkip")
    @Expose
    private Boolean step1CompleteOrSkip;
    @SerializedName("interestCategories")
    @Expose
    private List<Object> interestCategories = null;
    @SerializedName("profilePicURL")
    @Expose
    private ProfilePicURL profilePicURL;
    @SerializedName("defaultAddressId")
    @Expose
    private Object defaultAddressId;
    @SerializedName("currentLocation")
    @Expose
    private CurrentLocation currentLocation;
    @SerializedName("phoneVerified")
    @Expose
    private Boolean phoneVerified;
    @SerializedName("emailVerified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("drinking")
    @Expose
    private Object drinking;
    @SerializedName("smoking")
    @Expose
    private Object smoking;
    @SerializedName("bodyType")
    @Expose
    private Object bodyType;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("religion")
    @Expose
    private Object religion;
    @SerializedName("ethnicity")
    @Expose
    private Object ethnicity;
    @SerializedName("relationshipHistory")
    @Expose
    private Object relationshipHistory;
    @SerializedName("notificationEnable")
    @Expose
    private Boolean notificationEnable;
    @SerializedName("directDateRequestEnable")
    @Expose
    private Boolean directDateRequestEnable;
    @SerializedName("privacy")
    @Expose
    private Boolean privacy;
    @SerializedName("isDisable")
    @Expose
    private Boolean isDisable;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("firstTimeLogin")
    @Expose
    private Boolean firstTimeLogin;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("firstName")
    @Expose
    private String firstName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(String newNumber) {
        this.newNumber = newNumber;
    }

    public List<UserImage> getUserImages() {
        return userImages;
    }

    public void setUserImages(List<UserImage> userImages) {
        this.userImages = userImages;
    }

    public Boolean getAdminDeactivateAccount() {
        return adminDeactivateAccount;
    }

    public void setAdminDeactivateAccount(Boolean adminDeactivateAccount) {
        this.adminDeactivateAccount = adminDeactivateAccount;
    }

    public Integer getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(Integer timeOffset) {
        this.timeOffset = timeOffset;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Boolean getStep2CompleteOrSkip() {
        return step2CompleteOrSkip;
    }

    public void setStep2CompleteOrSkip(Boolean step2CompleteOrSkip) {
        this.step2CompleteOrSkip = step2CompleteOrSkip;
    }

    public Boolean getStep1CompleteOrSkip() {
        return step1CompleteOrSkip;
    }

    public void setStep1CompleteOrSkip(Boolean step1CompleteOrSkip) {
        this.step1CompleteOrSkip = step1CompleteOrSkip;
    }

    public List<Object> getInterestCategories() {
        return interestCategories;
    }

    public void setInterestCategories(List<Object> interestCategories) {
        this.interestCategories = interestCategories;
    }

    public ProfilePicURL getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(ProfilePicURL profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public Object getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Object defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }

    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(CurrentLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Object getDrinking() {
        return drinking;
    }

    public void setDrinking(Object drinking) {
        this.drinking = drinking;
    }

    public Object getSmoking() {
        return smoking;
    }

    public void setSmoking(Object smoking) {
        this.smoking = smoking;
    }

    public Object getBodyType() {
        return bodyType;
    }

    public void setBodyType(Object bodyType) {
        this.bodyType = bodyType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Object getReligion() {
        return religion;
    }

    public void setReligion(Object religion) {
        this.religion = religion;
    }

    public Object getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Object ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Object getRelationshipHistory() {
        return relationshipHistory;
    }

    public void setRelationshipHistory(Object relationshipHistory) {
        this.relationshipHistory = relationshipHistory;
    }

    public Boolean getNotificationEnable() {
        return notificationEnable;
    }

    public void setNotificationEnable(Boolean notificationEnable) {
        this.notificationEnable = notificationEnable;
    }

    public Boolean getDirectDateRequestEnable() {
        return directDateRequestEnable;
    }

    public void setDirectDateRequestEnable(Boolean directDateRequestEnable) {
        this.directDateRequestEnable = directDateRequestEnable;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    public Boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(Boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
