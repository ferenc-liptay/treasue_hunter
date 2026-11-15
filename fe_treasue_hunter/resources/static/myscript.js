let gameFinished = false;

window.onload = function() {
    
    let loginPostElement = document.getElementById("loginForm");
    loginPostElement.onsubmit = loginHandler;

    let cellArray = document.getElementsByClassName("cell");
    
   

    for(let index = 0; index < cellArray.length; index++){
        let cell = cellArray[index];
        cell.onclick = function(){
            clickHandler(cell);
        }
    }
}

function placeObject(){
    let cellArray = document.getElementsByClassName("cell");
    let skullQuantity = 2;
    let treasureQuantity = 1;
    let randomIndex = 0;
    let randomCell = null;

    for(let index = 0; index < cellArray.length; index++){
        cellArray[index].classList.add("empty");
        cellArray[index].classList.add("covered");
    }

    for(let index = 0; index < skullQuantity + treasureQuantity; index++){

        randomIndex = Math.floor(Math.random() * cellArray.length);
        randomCell = cellArray[randomIndex];

        while(!randomCell.classList.contains("empty")){
            randomIndex = Math.floor(Math.random() * cellArray.length);
            randomCell = cellArray[randomIndex];
        }

        if(index < skullQuantity) {
            randomCell.classList.add("skull");
            randomCell.classList.remove("empty");
        } else {
            randomCell.classList.add("treasure");
            randomCell.classList.remove("empty");
        }

    }
}

function clickHandler(cell){

    if(!gameFinished){

       if(cell.classList.contains("covered")){
            cell.classList.remove("covered");

            if(cell.classList.contains("skull")){
                alert("Game Over")
                gameFinished = true;

       } else if(cell.classList.contains("treasure")){
                alert("Gyozelem!");
                gameFinished = true;
       }
       }

    }
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
                placeObject();
            } else {
                alert("Sikertelen bejelentkezes")
            }
        }
    )
   
}