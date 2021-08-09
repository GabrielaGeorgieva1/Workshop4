package com.telerikacademy.oop.dealership.models;

import com.telerikacademy.oop.dealership.models.contracts.Comment;
import com.telerikacademy.oop.dealership.models.contracts.User;
import com.telerikacademy.oop.dealership.models.contracts.Vehicle;
import com.telerikacademy.oop.dealership.models.enums.UserRole;
import com.telerikacademy.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class UserImpl implements User {

    public static final int USERNAME_LEN_MIN = 2;
    public static final int USERNAME_LEN_MAX = 20;
    private static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]+$";
    private static final String USERNAME_PATTERN_ERR = "Username contains invalid symbols!";
    private static final String USERNAME_LEN_ERR = format(
            "Username must be between %d and %d characters long!",
            USERNAME_LEN_MIN,
            USERNAME_LEN_MAX);

    public static final int PASSWORD_LEN_MIN = 5;
    public static final int PASSWORD_LEN_MAX = 30;
    private static final String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9@*_-]+$";
    private static final String PASSWORD_PATTERN_ERR = "Password contains invalid symbols!";
    private static final String PASSWORD_LEN_ERR = format(
            "Password must be between %s and %s characters long!",
            PASSWORD_LEN_MIN,
            PASSWORD_LEN_MAX);

    public static final int LASTNAME_LEN_MIN = 2;
    public static final int LASTNAME_LEN_MAX = 20;
    private static final String LASTNAME_LEN_ERR = format(
            "Lastname must be between %s and %s characters long!",
            LASTNAME_LEN_MIN,
            LASTNAME_LEN_MAX);

    public static final int FIRSTNAME_LEN_MIN = 2;
    public static final int FIRSTNAME_LEN_MAX = 20;
    private static final String FIRSTNAME_LEN_ERR = format(
            "Firstname must be between %s and %s characters long!",
            FIRSTNAME_LEN_MIN,
            FIRSTNAME_LEN_MAX);

    private final static String NOT_AN_VIP_USER_VEHICLES_ADD = "You are not VIP and cannot add more than %d vehicles!";
    private final static String ADMIN_CANNOT_ADD_VEHICLES = "You are an admin and therefore cannot add vehicles!";
    private static final int VIP_MAX_VEHICLES_TO_ADD = 5;

    private static final String YOU_ARE_NOT_THE_AUTHOR = "You are not the author of the comment you are trying to remove!";
    private final static String USER_TO_STRING = "Username: %s, FullName: %s %s, Role: %s";
    private final static String NO_VEHICLES_HEADER = "--NO VEHICLES--";
    private final static String USER_HEADER = "--USER %s--";
    private static final int NORMAL_ROLE_VEHICLE_LIMIT = 5;

    private List<Vehicle> vehicles;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private final UserRole userRole;


    public UserImpl(String username, String firstName, String lastName, String password, UserRole userRole) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        this.userRole = userRole;
    }

    private void setUsername(String username) {
        ValidationHelpers.validateStringRange(username
                , USERNAME_LEN_MIN
                , USERNAME_LEN_MAX
                , USERNAME_LEN_ERR);
        ValidationHelpers.validatePattern(username
                , USERNAME_REGEX_PATTERN
                , USERNAME_PATTERN_ERR);
    }

    private void setFirstName(String firstName) {
        ValidationHelpers.validateStringRange(firstName
                , FIRSTNAME_LEN_MIN
                , FIRSTNAME_LEN_MAX
                , FIRSTNAME_LEN_ERR);
    }

    private void setLastName(String lastName) {
        ValidationHelpers.validateStringRange(lastName
                , LASTNAME_LEN_MIN
                , LASTNAME_LEN_MAX
                , LASTNAME_LEN_ERR);
    }

    private void setPassword(String password) {
        ValidationHelpers.validateStringRange(password
                , PASSWORD_LEN_MIN
                , PASSWORD_LEN_MAX
                , PASSWORD_LEN_ERR);
        ValidationHelpers.validatePattern(password
                , PASSWORD_REGEX_PATTERN
                , PASSWORD_PATTERN_ERR);
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public UserRole getRole() {
        return userRole;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (userRole == UserRole.VIP) {
            this.vehicles.add(vehicle);
        }
        if (userRole == UserRole.ADMIN) {
            throw new IllegalArgumentException(ADMIN_CANNOT_ADD_VEHICLES);
        }
        if (userRole == UserRole.NORMAL && vehicles.size() < 5) {
            this.vehicles.add(vehicle);
        } else {
            throw new IllegalArgumentException(NOT_AN_VIP_USER_VEHICLES_ADD);
        }

    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle);
        } else {
            throw new IllegalArgumentException(NO_VEHICLES_HEADER);
        }
    }

    @Override
    public void addComment(Comment commentToAdd, Vehicle vehicleToAddComment) {
        vehicleToAddComment.addComment(commentToAdd);
    }

    @Override
    public void removeComment(Comment commentToRemove, Vehicle vehicleToRemoveComment) {
        if (!username.equals(commentToRemove.getAuthor())) {
            vehicleToRemoveComment.removeComment(commentToRemove);
        } else {
            throw new IllegalArgumentException(YOU_ARE_NOT_THE_AUTHOR);
        }

    }

    @Override
    public String printVehicles() {
        return String.format("--USER {Username: %s, FullName: %s %s, Role: %s}--"
                , getUsername()
                , getFirstName()
                , getLastName()
                , getRole());
    }

    @Override
    public boolean isAdmin() {
        return userRole.equals(UserRole.ADMIN);
    }


}
