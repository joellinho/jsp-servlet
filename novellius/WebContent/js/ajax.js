
function cargarImagen() {
	document.getElementById("respuesta").innerHTML ="cargando Imagen....";//insertaremos un texto a el div con id respuesta que etsa en la vista
	
	var formdata = new FormData(); //crea un nuevo formulario para enviar por http
	formdata.append("file", document.getElementById("file").files[0]);//agregamos al formulario la teqieuta file con id file de la vista como envia un array enviamos el primer elemento
	var xhr = new XMLHttpRequest();//variable de contexto http tipo xml que se manejagar
	xhr.open("POST", "/ServletAjax?accion=cargarImagen", true); //nos conectamos al recurso por post y que se asincrono
	xhr.send(formdata);  //enviamos el nodo de dom creado
	
	xhr.onload = function() { //se ejecuta la carga
		if (this.status == 200) { // si se encontro el recurso 
		   alert(xhr.responseText);
			document.getElementById("respuesta").innerHTML =xhr.responseText;//insertaremos un texto(que venga del servidor) a el div con id respuesta que etsa en la vista
			
		}
	}

}