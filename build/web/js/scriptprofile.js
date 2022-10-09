//SCRIPT PROFILE DROPDOWN

const profile =document.querySelector('.top .sesion .profile');
const imgProfile = profile.querySelector('img');
const dropdownProfile = profile.querySelector('.profile-link');

imgProfile.addEventListener('click',function(){
    dropdownProfile.classList.toggle('show');
});

window.addEventListener('click',function(e){
   if(e.target !== imgProfile){
       if(e.target !== dropdownProfile){
           if(dropdownProfile.classList.contains('show')){
               dropdownProfile.classList.remove('show');
           }
       }
   } 
});