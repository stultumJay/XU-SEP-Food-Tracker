document.addEventListener('DOMContentLoaded', loadFood);

const btnCart = document.querySelector('#cart-icon');
const cart = document.querySelector('.cart');
const btnClose = document.querySelector('#cart-close');
const btnBuy = document.querySelector('.btn-buy');

btnCart.addEventListener('click', () => {
  cart.classList.add('cart-active');
});

btnClose.addEventListener('click', () => {
  cart.classList.remove('cart-active');
});

btnBuy.addEventListener('click', placeOrder);

function loadFood() {
  loadContent();
}

function loadContent() {
  const btnRemove = document.querySelectorAll('.cart-remove');
  btnRemove.forEach((btn) => {
    btn.addEventListener('click', removeItem);
  });

  const qtyElements = document.querySelectorAll('.cart-quantity');
  qtyElements.forEach((input) => {
    input.addEventListener('change', changeQty);
  });

  const cartBtns = document.querySelectorAll('.add-cart');
  cartBtns.forEach((btn) => {
    btn.addEventListener('click', addCart);
  });

  updateTotal();
  updateCartCount();
}

function removeItem() {
  if (confirm('Are You Sure to Remove')) {
    const title = this.parentElement.querySelector('.cart-food-title').innerHTML;
    const cartItems = document.querySelectorAll('.cart-content .cart-food-title');
    cartItems.forEach((item) => {
      if (item.innerHTML === title) {
        item.parentElement.parentElement.remove();
        return;
      }
    });
    loadContent();
  }
}

function changeQty() {
  if (isNaN(this.value) || this.value < 1) {
    this.value = 1;
  }
  loadContent();
}

function addCart() {
  const food = this.parentElement;
  const title = food.querySelector('.food-title').innerHTML;
  const price = food.querySelector('.food-price').innerHTML;
  const imgSrc = food.querySelector('.food-img').src;

  const cartItems = document.querySelectorAll('.cart-content .cart-food-title');
  let exists = false;
  cartItems.forEach((item) => {
    if (item.innerHTML === title) {
      alert('Product Already in Cart');
      exists = true;
      return;
    }
  });

  if (!exists) {
    const cartContent = document.querySelector('.cart-content');
    const cartBox = document.createElement('div');
    cartBox.classList.add('cart-box');
    cartBox.innerHTML = `
      <img src="${imgSrc}" alt="" class="cart-img">
      <div class="detail-box">
        <div class="cart-food-title">${title}</div>
        <div class="price-box">
          <div class="cart-price">${price}</div>
          <div class="cart-amt">${price}</div>
        </div>
        <input type="number" value="1" class="cart-quantity">
      </div>
      <ion-icon name="trash" class="cart-remove"></ion-icon>`;
    cartContent.appendChild(cartBox);
    loadContent();
  }
}

function updateTotal() {
  const cartItems = document.querySelectorAll('.cart-box');
  const totalValue = document.querySelector('.total-price');
  let total = 0;

  cartItems.forEach((item) => {
    const priceElement = item.querySelector('.cart-price');
    const price = parseFloat(priceElement.innerHTML.replace("Php.", ""));
    const qty = item.querySelector('.cart-quantity').value;
    total += price * qty;
    item.querySelector('.cart-amt').innerHTML = "Php." + (price * qty);
  });

  totalValue.innerHTML = "Php." + total;
}

function updateCartCount() {
  const cartItems = document.querySelectorAll('.cart-box');
  const cartCount = document.querySelector('.cart-count');
  cartCount.innerHTML = cartItems.length;
}

function placeOrder() {
  const cartItems = document.querySelectorAll('.cart-box');
  if (cartItems.length === 0) {
    alert("There is no order to place yet! Please make an order first.");
    return;
  }

  const productNames = [];
  const quantities = [];

  cartItems.forEach((item) => {
    const productName = item.querySelector('.cart-food-title').innerHTML;
    const quantity = item.querySelector('.cart-quantity').value;
    productNames.push(productName);
    quantities.push(quantity);
  });

  const form = document.createElement('form');
  form.method = 'POST';
  form.action = 'placeOrder';

  productNames.forEach((productName) => {
    const input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'productNames';
    input.value = productName;
    form.appendChild(input);
  });

  quantities.forEach((quantity) => {
    const input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'quantities';
    input.value = quantity;
    form.appendChild(input);
  });

  document.body.appendChild(form);
  form.submit();
}
