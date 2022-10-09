/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
   $('tr #deleteitem').click(function(e){
       e.preventDefault();
       var elemento = $(this);
       var idproducto = elemento.parent().find('#idarticulo').text();
       $.ajax({
           url : 'Controlador?URL=eliminar_carrito',
           type : 'post',
           data : {idproducto : idproducto},
           success: function(r){
               elemento.parent().parent().remove();
               var elementostabla = $('#shop-table tr');
               if(elementostabla.length <= 1){
                   $('#cart-container').append("<h4 align=\"center\">No hay Articulos en el Carrito</h4>");
               }
               $('#txt-subtotal').text(r);
               $('#txt-total').text(r);
           }           
       });
       $.ajax({
           url : 'Controlador?URL=eliminar_puntos',
           type : 'post',
           success: function(r){
               $('#txt-pts').text(r);
           }           
       });
   });
   
  
});

