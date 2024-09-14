function formCheck() {
    var value = 0;

    // First name validation -------------------------------------
    var firstName = document.getElementById("first-name").value;
    var namePattern = /.*[A-Z|a-z].*/;
    document.getElementById("first-name-feedback").innerHTML = "";
    if (namePattern.test(firstName) && firstName.length <= 15) {
        value = value + 1;
    } else if (namePattern.test(firstName) && firstName.length > 15) {
        document.getElementById("first-name-feedback").innerHTML += "first name cannot exceed 15 characters";
    } else {
        document.getElementById("first-name-feedback").innerHTML += "invalid input";
    }

    // Last name validation --------------------------------------
    var lastName = document.getElementById("last-name").value;
    document.getElementById("last-name-feedback").innerHTML = "";
    if (namePattern.test(lastName) && lastName.length <= 15) {
        value = value + 1;
    } else if (namePattern.test(lastName) && lastName.length > 15) {
        document.getElementById("last-name-feedback").innerHTML += "last name cannot exceed 15 characters";
    } else {
        document.getElementById("last-name-feedback").innerHTML += "invalid input";
    }

    // Username validation ---------------------------------------
    var username = document.getElementById("username").value;
    var usernamePattern = /.*[A-Z|a-z|0-9|~!@#$%^&*()].*/;
    document.getElementById("username-feedback").innerHTML = "";
    if (usernamePattern.test(username) && username.length >= 4 && username.length <= 12) {
        value = value + 1;
    } else if (usernamePattern.test(username) && username.length < 4) {
        document.getElementById("username-feedback").innerHTML += "username must be at least 4 characters long";
    } else if (usernamePattern.test(username) && username.length > 12) {
        document.getElementById("username-feedback").innerHTML += "username cannot exceed 12 characters";
    } else {
        document.getElementById("username-feedback").innerHTML += "invalid input";
    }

    // Password validation ---------------------------------------
    var password = document.getElementById("password").value;
    var upperCasePattern = /.*[A-Z].*/;
    var lowerCasePattern = /.*[a-z].*/;
    var numberPattern = /.*[0-9].*/;
    var specialCharPattern = /.*[~!@#$%^&*()].*/;
    document.getElementById("password-feedback").innerHTML = "";
    
    if (upperCasePattern.test(password) &&
    lowerCasePattern.test(password) &&
    numberPattern.test(password) &&
    specialCharPattern.test(password) &&
    password.length >= 8) {
    value = value + 1;
    } else {
        if (!upperCasePattern.test(password)) {
            document.getElementById("password-feedback").innerHTML += "password must have at least 1 uppercase letter. \n";
        }
        if (!lowerCasePattern.test(password)) {
            document.getElementById("password-feedback").innerHTML += "password must have at least 1 lowercase letter. \n";
        }
        if (!numberPattern.test(password)) {
            document.getElementById("password-feedback").innerHTML += "password must have at least 1 number. \n";
        }
        if (!specialCharPattern.test(password)) {
            document.getElementById("password-feedback").innerHTML += "password must have at least 1 special character: ~!@#$%^&*(). \n";
        }
        if (password.length < 8) {
            document.getElementById("password-feedback").innerHTML += "password must be at least 8 characters long. \n";
        }
    }
    
    // Output -----------------------------------------------------
    console.log(value);
    if (value == 4) {
        console.log("Meets requirements");
    } else {
        console.log("Does not meet requirements");
    }
}
