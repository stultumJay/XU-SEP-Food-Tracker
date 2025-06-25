<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" class="hydrated">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/common-style.css">
  <link rel="stylesheet" href="css/login-style.css">
</head>
<body>
  <section>
    <div class="login-box">
      <form id="loginForm" action="LoginServlet" method="post">
        <h2>Login</h2>
        <div class="input-box">
          <span class="icon"><ion-icon name="id-card" role="img" class="md hydrated" aria-label="id card"></ion-icon></span>
          <input type="number" name="student_id" required>
          <label>Student ID</label>
        </div>
        <div class="input-box">
          <span class="icon"><ion-icon name="lock-closed" role="img" class="md hydrated" aria-label="lock closed"></ion-icon></span>
          <input type="password" name="password" required>
          <label>Password</label>
        </div>
        <div class="remember-forget">
          <label>
            <input type="checkbox">Remember Me
          </label>
          <a href="#">Forget Password</a>
        </div>
        <button type="submit">Login</button>
        <!-- Display error pop-up -->
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if(errorMessage != null && !errorMessage.isEmpty()) { %>
          <div id="errorMessage" class="popup-message error"><%= errorMessage %></div>
        <% } %>
        <div class="register-link">
          <p>Don't have an account?
            <a href="signup.jsp">Register</a>
          </p>
        </div>
      </form>
    </div>
  </section>
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule="" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <script src="js/login-script.js"></script>
</body>
</html>
