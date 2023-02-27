$(document).ready(function(){
    $("#myCarousel").carousel({interval: 3000})
});

function navigation() {
    var x = document.getElementById("mynav");
    if (x.className === "nav") {
      x.className += " responsive";
    } else {
      x.className = "nav";
    }
  }

  function adminForm() {
    let x = document.forms["myForm"]["user"].value;
    let y = document.forms["myForm"]["pass"].value;
    if (x == "" || y=="") {
      alert("Name/Password must be filled out");
      return false;
    }
    if(y.length<6){
      alert("Password must be at least 6 characters long.");  
  return false; 
    }
  }

  function passForm(){  
    var firstpassword=document.f1.password.value;  
    var secondpassword=document.f1.password2.value;  
      
    if(firstpassword==secondpassword){  
    return true;  
    }  
    else{  
    alert("password must be same!");  
    return false;  
    }  
    }  