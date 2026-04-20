const loginBtn = document.querySelector("#login-btn");
const registerBtn = document.querySelector("#register-btn");
const loginIconBtn = document.querySelector("#login-icon-btn");
const logInputField = document.getElementById("password");
const logInputIcon = document.getElementById("view-pass-icon");

function viewPass() {
  if (logInputField.type === "password") {
    logInputField.type = "text";

    logInputIcon.name = "eye-off-outline";
    logInputIcon.style.cursor = "pointer";
  } else {
    logInputField.type = "password";

    logInputIcon.name = "eye-outline";
    logInputIcon.style.cursor = "pointer";
  }
}