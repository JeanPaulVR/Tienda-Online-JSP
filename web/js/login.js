const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

let getMode = localStorage.getItem("mode");
if(getMode && getMode ==="sign-up-mode"){
    container.classList.toggle("sign-up-mode");
}

sign_up_btn.addEventListener('click',()=>{
    container.classList.toggle('sign-up-mode');
    if(container.classList.toLocaleString("sign-up-mode")){
        localStorage.setItem("mode", "sign-up-mode");
    }
});

sign_in_btn.addEventListener('click',()=>{
    container.classList.toggle('sign-up-mode');
    if(container.classList.toLocaleString("sign-in-mode")){
        localStorage.setItem("mode", "sign-in-mode");
    }
});



