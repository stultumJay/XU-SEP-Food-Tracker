<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en" class="hydrated">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Signup Form</title>
  <link rel="stylesheet" href="css/common-style.css">
  <link rel="stylesheet" href="css/signup-style.css">
</head>
<body>
  <section>
    <div class="signup-box">
      <form action="SignupServlet" method="post">
        <h2>Signup</h2>
        <div class="input-box">
          <span class="icon"><ion-icon name="person" role="img" class="md hydrated" aria-label="person"></ion-icon></span>
          <input type="text" name="first_name" required>
          <label>Given Name</label>
        </div>
        <div class="input-box">
          <span class="icon"><ion-icon name="person" role="img" class="md hydrated" aria-label="person"></ion-icon></span>
          <input type="text" name="last_name" required>
          <label>Last Name</label>
        </div>
        <div class="input-box">
          <span class="icon"><ion-icon name="id-card" role="img" class="md hydrated" aria-label="id card"></ion-icon></span>
          <input type="number" name="student_id" required>
          <label>Student ID</label>
        </div>
        <div class="input-box">
          <span class="icon"><ion-icon name="mail" role="img" class="md hydrated" aria-label="mail"></ion-icon></span>
          <input type="email" name="email" required>
          <label>Email</label>
        </div>
        <div class="input-box">
          <span class="icon"><ion-icon name="lock-closed" role="img" class="md hydrated" aria-label="lock closed"></ion-icon></span>
          <input type="password" name="password" required>
          <label>Password</label>
        </div>
        <button type="submit">Signup</button>
        <div class="login-link">
          <p>Already have an account?
            <a href="login.jsp">Login</a>
          </p>
        </div>
      </form>
    </div>
  </section>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule="" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

  <%
  String status = (String) request.getAttribute("status");
  if ("success".equals(status)) {
  %>
  <div id="successMessage" class="popup-message">Successfully Registered</div>
  <% } else if ("failed".equals(status)) { %>
  <div id="errorMessage" class="popup-message error">Something Went Wrong. Please Try Again</div>
  <% } %>

  <script>
    // JavaScript to make pop-up disappear after 2 seconds
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
  </script>
</body>
</html>
