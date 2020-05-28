
 $(document).ready(function () {  
		  
		var shipping = 9.50;
		var taxRate = 0;
		var totalPrice = document.getElementById('total-price').textContent;
		
  $('#method').change(function () {
	  
    var choice = $(this).val();
    if (choice == "Overnight ($11.00)") {
      shipping = 11.00;
    }
    if (choice == "2-day expedited ($9.50)") {
      shipping = 9.50;
    }
    if (choice == "7-day ground ($6.25)") {
      shipping = 6.25;
    }
  });
  
  
  $("#zip").keypress(function(){
	
	  let zip = $(this).val();
	  console.log(zip);
	  
	  
  })
  

  $(document).mouseover(function () {  
	  

    $('#tax-amount').html((totalPrice * taxRate).toFixed(2));
    //console.log(quantityOptions);
    //let totalPrice = document.getElementById('unitPrice').innerHTML.substring(1);
    //console.log(price*quantity);
    //console.log(totalPrice);
    let final = ( parseFloat(totalPrice) + parseFloat(shipping));
    //console.log(parseFloat(totalPrice));
    //console.log(parseFloat(final));

    //console.log(final);
   $('#shipping').html(shipping.toFixed(2));

    $('#final-price').text(final);
    $('input[id=totalPrice]').val(final);
  })

  // billing address
  $('#billing-address').hide();

  $('#same-address').change(function () {
    $('#billing-address').slideToggle();
  })

});

