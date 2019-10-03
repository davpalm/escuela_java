window.onload = function() {
  let data_table = document.getElementById("data_table")  ;
  // Que va en casi todos los navegadores excepto IE
  let ajaxObj = new XMLHttpRequest();
  
  // Evento de cambio de estado de la llamada HTTP
  ajaxObj.onreadystatechange = function() {
      /*alert("State changed: " + this.readyState
              + ", status: " + this.status);*/
      if (this.readyState === 4 && this.status === 200) {
          let jsonResp = this.responseText;
          // Convertir texto JSON en obj JS
          let objRespListUsers = JSON.parse(jsonResp);
          data_table.innerHTML = "";
          for (let user of objRespListUsers) {
              data_table.innerHTML += 
                `<tr><td>${user.email}</td>
                    <td>${user.name}</td>
                </tr>`;
          }
      }
  };
  ajaxObj.open("GET", "api/users");
  ajaxObj.send();
};



$("#formJSON").submit(function(e) {
    e.preventDefault();
    var test = {name: $("#name").val(), email: $("#email").val(), password: $("#password").val(), age: $("#age").val()};
    $.ajax({
        type: 'post', // it's easier to read GET request parameters
        url: 'api/users',
        dataType: 'JSON',
        contentType: "application/json",
        data: JSON.stringify(test),
        success: function(data) {
            alert("ID: " + data.id + "\nNAME: " + data.name + "\nEMAIL: " + data.email + "\nAGE: " + data.age);
        }
    });
});