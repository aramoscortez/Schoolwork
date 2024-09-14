$(document).ready(function () {
    $("#button").click(function () {
        var value = 0;

        // First name validation -------------------------------------
        var firstName = $("#first-name").val();
        var namePattern = /.*[A-Z|a-z].*/;
        $("#first-name-feedback").html("");
        if (namePattern.test(firstName) && firstName.length <= 15) {
            value = value + 1;
        } else if (namePattern.test(firstName) && firstName.length > 15) {
            $("#first-name-feedback").html("first name cannot exceed 15 characters");
        } else {
            $("#first-name-feedback").html("invalid input");
        }

        // Last name validation --------------------------------------
        var lastName = $("#last-name").val();
        $("#last-name-feedback").html("");
        if (namePattern.test(lastName) && lastName.length <= 15) {
            value = value + 1;
        } else if (namePattern.test(lastName) && lastName.length > 15) {
            $("#last-name-feedback").html("last name cannot exceed 15 characters");
        } else {
            $("#last-name-feedback").html("invalid input");
        }

        // Username validation ---------------------------------------
        var username = $("#username").val();
        var usernamePattern = /.*[A-Z|a-z|0-9|~!@#$%^&*()].*/;
        $("#username-feedback").html("");
        if (usernamePattern.test(username) && username.length >= 4 && username.length <= 12) {
            value = value + 1;
        } else if (usernamePattern.test(username) && username.length < 4) {
            $("#username-feedback").html("username must be at least 4 characters long");
        } else if (usernamePattern.test(username) && username.length > 12) {
            $("#username-feedback").html("username cannot exceed 12 characters");
        } else {
            $("#username-feedback").html("invalid input");
        }

        // Password validation ---------------------------------------
        var password = $("#password").val();
        var upperCasePattern = /.*[A-Z].*/;
        var lowerCasePattern = /.*[a-z].*/;
        var numberPattern = /.*[0-9].*/;
        var specialCharPattern = /.*[~!@#$%^&*()].*/;
        $("#password-feedback").html("");

        var errorMessages = "";

        if (
            upperCasePattern.test(password) &&
            lowerCasePattern.test(password) &&
            numberPattern.test(password) &&
            specialCharPattern.test(password) &&
            password.length >= 8
        ) {
            value = value + 1;
        } else {
            if (!upperCasePattern.test(password)) {
                errorMessages += "password must have at least 1 uppercase letter. \n";
            }
            if (!lowerCasePattern.test(password)) {
                errorMessages += "password must have at least 1 lowercase letter. \n";
            }
            if (!numberPattern.test(password)) {
                errorMessages += "password must have at least 1 number. \n";
            }
            if (!specialCharPattern.test(password)) {
                errorMessages += "password must have at least 1 special character: ~!@#$%^&*(). \n";
            }
            if (password.length < 8) {
                errorMessages += "password must be at least 8 characters long. \n";
            }

            // Set the error messages in one go
            $("#password-feedback").html(errorMessages);
        }


        // Output -----------------------------------------------------
        console.log(value);
        if (value == 4) {
            console.log("Meets requirements");
        } else {
            console.log("Does not meet requirements");
        }
    });
});

