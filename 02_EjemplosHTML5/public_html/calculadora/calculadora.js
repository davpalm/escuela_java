class Calculadora {
    constructor(){
        //this.result = document.getElementById("resultado");
        this.result =  $("#resultado");
        //this.anterior = document.getElementById("anterior");
        this.anterior = $("#anterior");
        this.mem = 0;
        this.operador = "";
        this.nuevoNum = false;
    };
    numeroPulsado(eventObj) {
        
        if(this.nuevoNum)
        {
            //this.result.value = "0";
            this.result.val("0");
            this.nuevoNum = false;
        }
        
        let valor= eventObj.currentTarget.innerHTML;
        //alert("Pulsado " + valor);
        
        if (valor ==="+/-")
        {
            //this.result.value = - (parseFloat(this.result.value));
            this.result.val("" + (- (parseFloat(this.result.val()))));
        }
        else if(valor === ".")
        {
//            if(!this.result.value.includes("."))
//            {
//                this.result.value +=valor;
//            }
            if(!this.result.val().includes("."))
            {
                this.result.val(this.result.val() + valor);
            }
        }
        else 
        {
            //this.result.value += valor;
            this.result.val(this.result.val() + valor);
            //this.result.value = parseFloat(this.result.value);
            this.result.val(parseFloat(this.result.val()));
        }
    }
    
    operadorPulsado(evObj){
        
        let operadorActual= evObj.currentTarget.innerHTML;
        //alert("OP! " + operadorActual);
        
        if(this.operador !== "" || operadorActual === "=")
        {
            this.calcular();
        }
        
        //this.mem = parseFloat(this.result.value);
        this.mem = parseFloat(this.result.val());
        
        if(this.operador !== "=" && operadorActual !== "=")
        {
            //this.anterior.value = `${this.mem} ${operadorActual}`;
            this.anterior.val(`${this.mem} ${operadorActual}`);
            //this.result.value = "0";
            this.result.val("0");
            this.operador = operadorActual;
        }
        else
        {
            this.operador = "";
        }
        
        this.nuevoNum = true;
    }
    
    calcular()
    {
        if(this.operador !== "" && this.operador !== "=")
        {
            //let valActual = parseFloat(this.result.value);
            let valActual = parseFloat(this.result.val());
            let resultado = eval(this.mem.toString() + this.operador + valActual);
            //this.result.value = resultado;
            this.result.val(resultado);
        }
    }
};

let calculadora = null;

//window.onload = function(){
//    calculadora = new Calculadora();
//    
//    let botonesNum = document.getElementsByClassName("num"); //array de botones con numero
//    for(let btnNum of botonesNum)
//    {
//        btnNum.addEventListener("click", (evtObj) => {
//            calculadora.numeroPulsado(evtObj);
//        });
//    }
//    
//    let botonesOp = document.getElementsByClassName("oper"); //array de botones con operadores
//    for(let btnOp of botonesOp)
//    {
//        btnOp.addEventListener("click", (evObj) => {
//            calculadora.operadorPulsado(evObj);
//        });
//    }
//};

let inicializacion = function(){
    calculadora = new Calculadora();

    //Todos los elementos con la clase .num
    $(".num").click((evtObj) => {
            calculadora.numeroPulsado(evtObj);
        });
    
    $(".oper").click((evtObj) => {
            calculadora.operadorPulsado(evtObj);
        });
};
jQuery(document).ready(inicializacion); //tambien se puede poner con $ en vez de JQuery





