class  Animal {
    especie: string;
    edad: number;
    volador: boolean;

    constructor(especie: string, edad: number, volador: boolean){
        this.especie = especie;
        this.edad = edad;
        this.volador = volador;
    }

    stringfy(): string {

        return "Animal " + this.especie + " con " + this.edad + " años y " + this.volador + " volador";
    }

    mostrar(): void {
        console.log(this.stringfy());
    }
}

let perro: Animal = new Animal("Perro", 7, false);
perro.mostrar();

class Mamifero extends Animal{
    private mamas: number;
    static contador: number = 0;

    static total(){
        return this.contador;
    }

    public constructor(especie: string, edad: number, volador: boolean, mamas: number){
        super(especie, edad, volador);
        this.mamas = mamas;
        Mamifero.contador++;
    }
}


let gato = new Mamifero("Gato", 3, false, 4);
gato.mostrar();

console.log("Variable privada " + gato.mamas);
console.log(Mamifero.total());

class Pajaro extends Animal{
    constructor(private numAlas: number, public huevos: number, edad: number){
        super("Pajaro", edad, true);
    }
}

let avestruz: Pajaro = new Pajaro(2, 1,8);
avestruz.mostrar();