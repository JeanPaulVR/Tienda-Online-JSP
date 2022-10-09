/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


$(function(){
    Count();
});

function Count(){
    $.getJSON("Controlador?URL=contar_usuarios",{},function(data){
       $("#usuarios").text(data);
    });
    $.getJSON("Controlador?URL=contar_categorias",{},function(data){
       $("#categorias").text(data);
    });
    $.getJSON("Controlador?URL=contar_productos",{},function(data){
       $("#productos").text(data);
    });
    $.getJSON("Controlador?URL=contar_pedidos",{tip : "PENDIENTE"},function(data){
       $("#pendientes").text(data);
    });
    $.getJSON("Controlador?URL=contar_pedidos",{tip : "REALIZADO"},function(data){
       $("#realizados").text(data);
    });
    $.getJSON("Controlador?URL=contar_pedidos",{tip : "ANULADO"},function(data){
       $("#anulados").text(data);
    });
}
