
function CalculateCWithR()
{
    var radius = prompt("Enter in the Radius");
    var c = 2 * Math.PI * radius;
    console.log(c);
}

function CalculateCWithD()
{
    var diameter = prompt("Enter in the Diameter");
    var c = Math.PI * diameter;
    console.log(c);
}

function FahrenheitToCelsius()
{
    var farenheit = prompt("Enter in the Fahrenheit");
    var celsius = (5/9) * (farenheit - 32);
    console.log(celsius);
}

function CelsiusToFahrenheit()
{
    var celsius = prompt("Enter in the Celsius");
    var farenheit = (9/5) * celsius + 32;
    console.log(farenheit);
}


function CompoundInterest()
{
    var principal = prompt("Enter in the principal amount");
    var interestRate = prompt("Enter in the interest rate (as decimal)");
    var numOfTimesInterestIsCompounded = 1; // compounded anually
    var time = prompt("Enter in the number of years (time) the amount is deposited for");

    var amount = principal * (1 + (interestRate / numOfTimesInterestIsCompounded))**(numOfTimesInterestIsCompounded * time);
    console.log(amount);
}