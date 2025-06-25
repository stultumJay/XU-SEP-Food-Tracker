window.onload = function() {
  var errorMessageElement = document.getElementById("errorMessage");
  if (errorMessageElement) {
    errorMessageElement.style.display = "block";
    setTimeout(function() {
      errorMessageElement.style.display = "none";
    }, 2000);
  }
}; 