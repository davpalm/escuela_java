var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Animal = /** @class */ (function () {
    function Animal(especie, edad, volador) {
        this.especie = especie;
        this.edad = edad;
        this.volador = volador;
    }
    Animal.prototype.stringfy = function () {
        return "Animal " + this.especie + " con " + this.edad + " años y " + this.volador + " volador";
    };
    Animal.prototype.mostrar = function () {
        console.log(this.stringfy());
    };
    return Animal;
}());
var perro = new Animal("Perro", 7, false);
perro.mostrar();
var Mamifero = /** @class */ (function (_super) {
    __extends(Mamifero, _super);
    function Mamifero(especie, edad, volador, mamas) {
        var _this = _super.call(this, especie, edad, volador) || this;
        _this.mamas = mamas;
        Mamifero.contador++;
        return _this;
    }
    Mamifero.total = function () {
        return this.contador;
    };
    Mamifero.contador = 0;
    return Mamifero;
}(Animal));
var gato = new Mamifero("Gato", 3, false, 4);
gato.mostrar();
console.log("Variable privada " + gato.mamas);
console.log(Mamifero.total());
var Pajaro = /** @class */ (function (_super) {
    __extends(Pajaro, _super);
    function Pajaro(numAlas, huevos, edad) {
        var _this = _super.call(this, "Pajaro", edad, true) || this;
        _this.numAlas = numAlas;
        _this.huevos = huevos;
        return _this;
    }
    return Pajaro;
}(Animal));
var avestruz = new Pajaro(2, 1, 8);
avestruz.mostrar();
