function loginUser(form){
    var loginInfo = {userId: form.elements["inputEmail"].value,
                userPassword: form.elements["inputPassword"].value }
    $.ajax({
          type: 'POST',
          url: "/loginAction",
          data: loginInfo,
          success: function (data,status) {   // success callback function
                 if(data.result){
                    sessionStorage.setItem("userInfo", JSON.stringify(data.userInfo));
                    window.location.href = 'admin/home';
                 }else{
                    showAlert("failure", "Credentials are invalid");
                 }
          },
          error: function (jqXhr, textStatus, errorMessage) { // error callback
               var test = jqXhr;
               var ue = textStatus;
               var error = errorMessage;
          }
    });
}

function signout(){
	sessionStorage.removeItem("userInfo");
	window.location.href = '/login';
}

function showAlert(model, alert){
	if(model == "success"){
		$("#successContent").html(alert);
		$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
		      $("#success-alert").slideUp(500);
		});
	}else if(model == "failure"){
		$("#failedContent").html(alert);
		$("#failure-alert").fadeTo(2000, 500).slideUp(500, function() {
		      $("#failure-alert").slideUp(500);
		});
	}
	 
}

function checkSession(){
	var sessionValueString = sessionStorage.getItem("userInfo");
	if(sessionValueString != null){
		//Load Products
		fetchProductDetails(sessionValueString);

	}else{
        window.location.href = '/login';
	}
}

var productDetails = null;
function fetchProductDetails(sessionValueString){
    var userInfo = JSON.parse(sessionValueString);
    $("#userName").html(userInfo.username);
    $.ajax({
          type: 'POST',
          url: "/admin/fetchProduct",
          data: {userId: userInfo.userId},
          success: function (data,status) {   // success callback function
                 if(data.result){
                    productDetails = data.productList;
                    createTable(data.productList);
                 }else{
                    showAlert("failure", "Failed to fetch product details");
                 }
          },
          error: function (jqXhr, textStatus, errorMessage) { // error callback
              alert(textStatus);
          }
    });
}

function createTable(productList) {
        var myTableDiv = document.getElementById("product-content");  //indiv

        var html = generateHeader();
            for (var i = 0; i < productList.length; i++){
            html +="<tr>"+
                    "<td> <input type='checkbox' id='product-"+i+"' name='products' value='"+productList[i].productId+"' /> </td>"+
                    "<td>"+ productList[i].productName + "</td>"+
                    "<td>"+ productList[i].productDec + "</td>"+

                    "<td>"+ productList[i].ageCriteria + "</td>"+"<td><button data-toggle='modal' data-target='#myModal' data-arrayIndex='"+ i +"' onclick='viewData("+i+")'>View</button></td>"+"</tr>";
        }
        html += "</table>"
        $("#product-content").html(html);

}

function generateHeader(){
        var html = "<table id='rDataTable' class='table table-striped'>";
        html+="<tr class=''>";
        html+="<td class='tb-heading ui-state-default'>"+''+"</td>";
        html+="<td class='tb-heading ui-state-default'>"+'Product Name'+"</td>";
        html+="<td class='tb-heading ui-state-default'>"+'product Description'+"</td>";
        html+="<td class='tb-heading ui-state-default'>"+'Age Criteria'+"</td>";
        html+="<td class='tb-heading ui-state-default'>"+'Options'+"</td>";
        html+="</tr>";
        return html;
}

function deleteProduct(){
    var fav = [];
    $.each($("input[name='products']:checked"), function(){
        fav.push($(this).val());
    });
    console.log(fav);
    removeProduct(fav);
}

function removeProduct(prodListVal){
var postData = {
    "prodList" : JSON.stringify(prodListVal)
}
    $.ajax({
              type: 'DELETE',
              url: "/admin/products",
              data: postData,
              success: function (data,status) {
                     if(data.result){
                        showAlert("success", data.message);
                        //Manage Refersh
                        fetchProductDetails(sessionStorage.getItem("userInfo"));
                     }else{
                        showAlert("failure", data.message);
                     }
              },
              error: function (jqXhr, textStatus, errorMessage) { // error callback
                  alert(textStatus);
              }
        });

}

function viewData(index){
    var data = productDetails[index];
    $('#productName').html(data.productName);
    $('#productDesc').html(data.productDec);
    $('#productAge').html(data.ageCriteria);
    $('#productExp').html(data.expireDt);
    $('#productAva').html(data.available);
    $('#productStatus').html(data.status);
}


setTimeout(function(){
	$("#success-alert").hide();
	$("#failure-alert").hide();
}, 10);

