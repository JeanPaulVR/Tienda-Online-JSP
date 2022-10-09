/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


$(function () {
    MostrarPP();
    MostrarPR();
    MostrarPA();
});

function MostrarPP() {
    var desde = $("#f_desdep").val();
    var hasta = $("#f_hastap").val();
    $.getJSON("Controlador?URL=mostrar_pp", {f_desde : desde, f_hasta : hasta}, function(data){
        $("#pedidos_p > tbody").empty();
        $("#pedidos_p").append(data);
    });
}

function MostrarPR() {
    var desde = $("#f_desder").val();
    var hasta = $("#f_hastar").val();
    $.getJSON("Controlador?URL=mostrar_pr", {f_desde : desde, f_hasta : hasta}, function(data){
        $("#pedidos_r > tbody").empty();
        $("#pedidos_r").append(data);
    });
}

function MostrarPA() {
    var desde = $("#f_desdea").val();
    var hasta = $("#f_hastaa").val();
    $.getJSON("Controlador?URL=mostrar_pa", {f_desde : desde, f_hasta : hasta}, function(data){
        $("#pedidos_a > tbody").empty();
        $("#pedidos_a").append(data);
    });
}