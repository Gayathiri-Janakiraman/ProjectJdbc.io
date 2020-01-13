function validateform(){
    var title=document.forms["editMovie"]["title"].value;
    if(title==""){
            alert("Title is Required");
            return false;
                }
        var titleLength=title.length;
        if(titleLength < 2 || titleLength > 65){
                alert("Title should have 2 to 65 charecter");
                return false;
        }
       
        var gross=document.forms["editMovie"]["gross"].value;
        if(isNaN(gross)){
            alert("Gross has to be a number");
            return false;
        }
        if(gross==""){
            alert("Gross is required");
            return false;
        }
       
        var dateofLaunch=document.forms["editMovie"]["dateofLaunch"].value;
        if(dateofLaunch==""){
            alert("Date of Launch is Required");
            return false;
        }
       
        if(!dateofLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
        alert("Incorrect date format. Expected format(dd/mm/yyyy)");
        return false;
        }
        var Genre=document.forms["editMovie"]["Genre"].value;
        if(Genre=="0"){
            alert("Select one genre");
            return false;
        }
    }
        function deleteRow(r)
        {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("table_id").deleteRow(i);
            document.getElementById("span").innerHTML="Movie removed from Favorites successfully";
            addcolumn();
        }
        function addcolumn(){
            var totalrows=document.getElementById("table_id").rows.length;
            datarows =(totalrows-2);
            document.getElementById("val").innerHTML=datarows;
//            if(datarows==0){
//                window.open("favorites-empty.jsp");
//            }
            
            }
        


    