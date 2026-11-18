let gameFinished = false;
let stepsCounter = 0;
let userId = null;

window.onload = function() {
    
    let loginButton = document.getElementById("login");
    loginButton.onclick = loginHandler;

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
            stepsCounter++;

            if(cell.classList.contains("skull")){
                endGameRequest(false);
                alert("Game Over")
                gameFinished = true;

       } else if(cell.classList.contains("treasure")){
                endGameRequest(true);
                alert("Win!");
                gameFinished = true;
       }
            
            document.getElementById("steps").innerHTML = stepsCounter;
       }

    }
}

function loginHandler(event){
    let userNameElement = document.getElementById("username");
    let passwordElement = document.getElementById("password");

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
                throw new Error("User not found!");
               
            } else {
                return response.json();
            }
        }
    )
    .then(
        data => {
           
                alert("Successful login!")
                let gameTableElement = document.getElementById("gameTable");
                gameTableElement.style.display = "block";
                document.getElementById("name").innerHTML = data.username;
                document.getElementById("lives").innerHTML = data.lives;
                document.getElementById("record").innerHTML = data.record;
                userId = data.id;
                placeObject();
           
        }
    ).catch(
        error => {
            alert("User not found");
        }
    )
   
}

function endGameRequest(gameResult){
    let body = {
        id: userId,
        steps: stepsCounter,
        win: gameFinished
    }

    fetch("http://localhost:8080/finish",
        {
            method: "POST",
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(body)
        }
    ).then (
        response => {
            if(!response.ok){
                throw new Error("User not found!");
                
            } else {
                return response.json();
            }
        }
    ).then (
        data => {
            document.getElementById("lives").innerHTML = data.lives;
            document.getElementById("record").innerHTML = data.record;
        }
    ).catch(
        error => {
            alert("User not found!")
        }
    )
}