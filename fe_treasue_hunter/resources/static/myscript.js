window.onload = function() {
    
    let loginPostElement = document.getElementById("loginForm");
    loginPostElement.onsubmit = loginHandler;
}

function loginHandler(event){
    event.preventDefault();
    let userNameElement = document.getElementsByName("username")[0];
    let passwordElement = document.getElementsByName("password")[0];

    let loginRequest = {
        username : userNameElement.value,
        password : passwordElement.value
    }

    fetch(
        "http://localhost:8080/user/login",
        {
            method: "POST",
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(loginRequest)
        }
    )
    .then(
        response => {
            if(!response.ok){
                alert("Hiba tortent")
            } else {
                return response.json();
            }
        }
    )
    .then(
        data => {
            if(data.response == "OK"){
                alert("Sikeres bejelentkezes")
                let gameTableElement = document.getElementById("gameTable");
                gameTableElement.style.display = "block";
            } else {
                alert("Sikertelen bejelentkezes")
            }
        }
    )
   
}