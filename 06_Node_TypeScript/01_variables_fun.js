// 'usestrict';
// Ultimo codigo JS
var hola = "Hola";
console.log("Guay " + hola);
function otroHola(saludo) {
    console.log("Saludo " + saludo);
}
otroHola(" adios JS!");
// Type Script
var variablenum;
// console.log(variableNoDeclarada);
variablenum = 100;
console.log(variablenum);
var miUnion;
// miUnion = new Object();
miUnion = true;
miUnion = "....";
var miCumple = { dia: 7, mes: 10, anio: 1999 };
console.log("Cumple el " + miCumple.dia + " del " + miCumple.mes);
// any: tipo que dice que puede ser de cualquier tipo, un buen tipo (tambien se puede poner sin tipo)
function concatenar(texto1, texto2) {
    console.log("Concatenado: " + texto1 + " " + texto2);
}
concatenar("Total, ", "que recibe una cosa");
concatenar("u otra ", miCumple);
