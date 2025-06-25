window.onload = function() {
  var successMessage = document.getElementById('successMessage');
  var errorMessage = document.getElementById('errorMessage');
  if (successMessage) {
    successMessage.style.display = 'block';
    setTimeout(function() {
      successMessage.style.display = 'none';
    }, 2000);
  }
  if (errorMessage) {
    errorMessage.style.display = 'block';
    setTimeout(function() {
      errorMessage.style.display = 'none';
    }, 2000);
  }
}; 