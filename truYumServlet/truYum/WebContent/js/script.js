function validateMenuItemForm() {
	var name = document.forms["MenuItemForm"]["name"].value;
	if (name == "") {
		alert("Name is Required");
		return false;
	}
	var nameLength = name.length;
	if (nameLength < 2 || nameLength > 65) {
		alert("Name should have 2 to 65 character");
		return false;
	}
	var price = document.forms["MenuItemForm"]["price"].value;
	if (isNaN(price)) {
		alert("Price has to be a number");
		return false;
	}
	if (price == "") {
		alert("Price is required");
		return false;
	}
	var dateofLaunch = document.forms["MenuItemForm"]["dateofLaunch"].value;
	if (dateofLaunch == "") {
		alert("Date of Launch is Required");
		return false;
	}
	if (!dateofLaunch
			.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)) {
		alert("Incorrect date format. Expected format(dd/mm/yyyy)");
		return false;
	}
	var category = document.forms["MenuItemForm"]["category"].value;
	if (category == "0") {
		alert("Select one category");
		return false;
	}

}
// function deleteRow(r)
// {
// var i = r.parentNode.parentNode.rowIndex;
// document.getElementById("table_id").deleteRow(i);
// document.getElementById("span").innerHTML="Item Removed from Cart
// Successfully";
// addcolumn();
// }
// function addcolumn(){
// var table=document.getElementById("table_id"), sum=0.00;
// if(table.rows.length==2){
// sum=0.00;
// window.open("cart-empty.html");
// document.getElementById("val").innerHTML=sum;
// }
// else{
// for(var i=1; i<table.rows.length-1; i++){
// var str=table.rows[i].cells[2].innerHTML;
// sum +=parseFloat(str.substring(3));
// }
// document.getElementById("val").innerHTML=sum.toFixed(2);

