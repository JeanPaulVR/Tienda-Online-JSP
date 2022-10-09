/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


$(function () {
    Mostrar();
});

function Mostrar() {
    var b_cate = $("#b_cat").val();
    $.getJSON("Controlador?URL=mostrar_categoriaA", {busq : b_cate}, function(data){
        $("#tabla_cate > tbody").empty();
        $("#tabla_cate").append(data);
    });
}