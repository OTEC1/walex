/**
 * 
 */

let header=document.querySelector('header');
let hamburgermenu=document.querySelector('hamburger-menu');
hamburgermenu.addListener('click',function(){
header.classList.toggle('menu-open');
})
