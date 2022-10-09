/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */



$(function () {
    MostrarLista();
});


function MostrarLista() {
    var busq = $("#buscador").val();
    $.getJSON("Controlador?URL=mostrar_productos", {busq : busq}, function (data) {
        $("#productost").empty();
        $("#productost").append(data);
    });
    $.getJSON("Controlador?URL=mostrar_categorias", {}, function (data) {
        $("#categorias").empty();
        $("#categorias").append(data);
    });
    $.getJSON("Controlador?URL=mejores_productos", {}, function (data) {
        $("#mejoresproductos").empty();
        $("#mejoresproductos").append(data);
    });
    $.getJSON("Controlador?URL=mas_nuevo", {}, function (data) {
        $("#masnuevo").empty();
        $("#masnuevo").append(data);
    });
}


function Categoria(busq) {
    
    $.getJSON("Controlador?URL=mostrar_productos", {busq : busq}, function (data) {
        $("#productost").empty();
        $("#productost").append(data);
    });
    $.getJSON("Controlador?URL=mostrar_categorias", {}, function (data) {
        $("#categorias").empty();
        $("#categorias").append(data);
    });
    $.getJSON("Controlador?URL=mejores_productos", {}, function (data) {
        $("#mejoresproductos").empty();
        $("#mejoresproductos").append(data);
    });
}