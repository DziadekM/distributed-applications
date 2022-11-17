window.onload = function () {
  const convert = document.getElementById("convert");
  const option1 = document.getElementById("option1");
  const reset = document.getElementById("reset");
  const customer = document.getElementById("customer");
  const result = document.getElementById("result");
  const to = document.getElementById("currency");
  const amount = document.getElementById("euro");
  const options = document.getElementsByClassName("options");

  convert.addEventListener("click", function () {
    let fromCurrency = "EUR";
    let toCurrency = to.value;
    let amt = amount.value;

    if (toCurrency === "USD") {
      let a = toUSD(amt);
      console.log(a);
      result.innerHTML = `${amt} ${fromCurrency} = ${a} ${toCurrency}`;
    }

    if (toCurrency === "GBP") {
      //result.innerHTML = "";
      let b = toGBP(amt);
      console.log(b);
      result.innerHTML = `${amt} ${fromCurrency} = ${b} ${toCurrency}`;
    }

    if (toCurrency === "INR") {
      let c = toINR(amt);
      console.log(c);
      result.innerHTML = `${amt} ${fromCurrency} = ${c} ${toCurrency}`;
    }

    if (toCurrency === "EUR") {
      let d = toEUR(amt);
      result.innerHTML = `${amt} ${fromCurrency} = ${d} ${toCurrency}`;
    }

    if (toCurrency === "JPY") {
      let e = toJPY(amt);
      result.innerHTML = `${amt} ${fromCurrency} = ${e} ${toCurrency}`;
    }

    if (toCurrency === "CHF") {
      let f = toCHF(amt);
      result.innerHTML = `${amt} ${fromCurrency} = ${f} ${toCurrency}`;
    }
  });

  reset.addEventListener("click", function () {
    result.innerHTML = "";
    amount.value = "";
    customer.value = "";
    to.value = option1.value;
  });
};

function toUSD(euro) {
  let result1 = euro / 0.99;
  return result1;
}

function toGBP(euro) {
  let result2 = euro / 1.15;
  return result2;
}
function toINR(euro) {
  let result3 = euro / 0.012;
  return result3;
}

function toEUR(euro) {
  let result4 = euro;
  return result4;
}

function toJPY(euro) {
  let result5 = euro / 0.0068;
  return result5;
}

function toCHF(euro) {
  let result6 = euro / 1.007;
  return result6;
}

//euro:wechselkurs = dollar
//euro: dollar = wechselkurs

//Wechselkurs GBP = 1,15
//Wechselkurs INR = 0,012
//Wechselkurs EUR = 1
//Wechselkurs JPY = 0,0068
//Wechselkurs CHF = 1,007
