/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$(function () {
    Mostrar();
});

function Mostrar() {
    var busq = $("#b_prod").val();
    $.getJSON("Controlador?URL=mostrar_productosA", {busq : busq}, function(data){
        $("#tabla_productos > tbody").empty();
        $("#tabla_productos").append(data);
    });
}
