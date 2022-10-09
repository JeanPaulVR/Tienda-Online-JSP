/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


const open = document.getElementsByClassName("open");
const overlay1null = document.getElementById('overlay1null');
const popup1null = document.getElementById('popup1null');
const close = document.getElementsByClassName("close");



function Mostrar(id) {
    overlay1null.classList.replace('overlay1null', 'overlay1Open');
    popup1null.classList.replace('popup1null', 'popup1Open');

    $.getJSON("Controlador?URL=detalle_pedido&ID=" + id, {}, function (data) {
        $("#detalles").append(data);
    });
}
;

function Cerrar() {
    overlay1null.classList.replace('overlay1Open', 'overlay1null');
    popup1null.classList.replace('popup1Open', 'popup1null');
    document.getElementById("detalles").innerHTML = "";

}
;

function MostrarMsjCarrito(ptos, total) {
    var ptosD = document.getElementById("puntossel");
    if (ptosD >= ptos) {
        $("#ptosU").text(ptos);
        $("#dscp").text("$"+ptos/10);
        $("#txt-total").text(total-ptos/10);
        $("#ptosusa").values(ptos);
        $("#neto").values(total-ptos/10);
    } else if(ptosD<ptos){
        overlay1null.classList.replace('overlay1null', 'notification-toast');
    }
}
;
