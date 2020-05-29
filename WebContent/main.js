function sendEmail() {
  document.getElementById("contactform").action = "mailto:info@sportsstore.com";
}

var quantity = 1;
var price = 0;
var quantityOptions = 1;
price = document.getElementById('unitPrice').innerHTML.substring(1);

var total = quantity * price;

function updatePrice() {
  quantityOptions = document.getElementById('quantity').value;
  price = document.getElementById('unitPrice').innerHTML.substring(1);
  quantity = quantityOptions;
  total = quantity * price;
  console.log(quantity);
  console.log(price);

}

// form validation
$(document).ready(function () {
  $("#orderform").submit(function (event) {
    event.preventDefault();
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var adr = $("#adr").val();
    var city = $("#city").val();
    var state = $("#state").val();
    var zip = $("#zip").val();
    var method = $("#method").val();
    var pid = $("#pid").val();
    var quantity = $("#quantity").val();
    var cardname = $("#cname").val();
    var cardnumber = $("#ccnum").val();
    var expmonth = $("#expmonth").val();
    var expyear = $("#expyear").val();
    var cvv = $("#cvv").val();
    var submit = $("#order-submit").val();
    $(".form-message").load("./php/insert.php", {
      firstname: fname,
      lastname: lname,
      email: email,
      phone: phone,
      address: adr,
      city: city,
      state: state,
      zip: zip,
      method: method,
      productid: pid,
      submit: submit,
      quantity: quantity,
      cardname: cardname,
      cardnumber: cardnumber,
      expmonth: expmonth,
      expyear: expyear,
      cvv: cvv
    });
  });
});

// using jQuery and Ajax for form autocomplete
$(document).ready(function () {

  var shipping = 9.50;

  $(document).mouseover(function () {  

    $('#total-price').html(total.toFixed(2));
       
    let final = (total + (total * taxRate) + shipping);
    
    $('#shipping').html(shipping.toFixed(2));

    $('#final-price').html(final.toFixed(2))
    $('input[id=totalPrice]').val(final.toFixed(2));
  })

 
});

