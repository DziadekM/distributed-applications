
window.onload = function(){
    const convert = document.getElementById("convert");
    const option1 = document.getElementById("option1");
    const reset = document.getElementById("reset");
    const customer = document.getElementById("customer");
    const result = document.getElementById("result");
    const to = document.getElementById("currency");
    const amount = document.getElementById("euro");
    convert.addEventListener("click", function() {
       let fromCurrency = "EUR";
       console.log(fromCurrency);
       let toCurrency = to.value;
       let amt = amount.value;
       fetch(`https://api.exchangerate-api.com/v4/latest/${fromCurrency}`)
       .then(response => {
             return response.json();
       })
       .then(data => {
          let rate = data.rates[toCurrency];
          let total = rate * amt;
          result.innerHTML = `${amt} ${fromCurrency} = ${total}
          ${toCurrency}`;
          console.log(option1);
       });
    });  
    
    reset.addEventListener("click", function() {
        result.innerHTML = "";
        amount.value = "";
        customer.value = "";
        to.value = option1.value;
    });
 }