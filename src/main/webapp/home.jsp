<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="SecHallSolution.model.Product" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="css/home-style.css">
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
</head>
<body>
<header>
    <div class="nav">
        <a href="#" class="logo">
            <img src="program-images/XavierLogo.png" alt="Xavier Logo" class="logo-img">
            <span class="logo-text">Sec Hall</span>
        </a>
        <div class="box">
            <div class="cart-count">0</div>
            <ion-icon name="cart" id="cart-icon"></ion-icon>
        </div>
        <div class="user-info">
            <span>ID: <%= (request.getSession(false) != null) ? (String) request.getSession(false).getAttribute("student_id") : "" %></span>
            <a href="LogoutServlet" class="logout-button">Logout</a>
        </div>
    </div>
    <div class="cart">
        <div class="cart-title">Cart Items</div>
        <div class="cart-content"></div>
        <div class="total">
            <div class="total-title">Total</div>
            <div class="total-price">Php.0</div>
        </div>
        <button class="btn-buy">Place Order</button>
        <ion-icon name="close" id="cart-close"></ion-icon>
    </div>
</header>
<div class="container">
    <h2 class="title">Order Delicious Products Here!</h2>
    <div class="shop-content">
        <%-- Dynamically display products from the database --%>
        <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
        <% if (products != null) { %>
            <% for (Product product : products) { %>
                <div class="food-box">
                    <div class="pic">
                        <img src="program-images/<%= product.getImageUrl() %>" class="food-img">
                    </div>
                    <h2 class="food-title"><%= product.getTitle() %></h2>
                    <span class="food-price">Php.<%= product.getPrice() %></span>
                    <ion-icon name="cart" class="add-cart"></ion-icon>
                </div>
            <% } %>
        <% } else { %>
            <div>No products available.</div>
        <% } %>
    </div>
</div>
<script src="js/home-script.js"></script>

<!-- Custom Modal for Alerts -->
<div id="customModal" class="custom-modal">
  <div class="custom-modal-content">
    <span id="customModalMsg"></span>
    <button onclick="hideModal()">OK</button>
  </div>
</div>
<!-- Custom Modal for Confirms -->
<div id="customConfirmModal" class="custom-modal">
  <div class="custom-modal-content">
    <span id="customConfirmMsg"></span>
    <button id="confirmYes">Yes</button>
    <button id="confirmNo">No</button>
  </div>
</div>
</body>
</html>
