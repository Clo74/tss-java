class Giacca {

    constructor() {
        this.numeroTasche = 4;
        this.cappuccio = true;
        this.zipAperta = true;
    }

    chiudiZip() {
        this.zipAperta = false;
    }

}

let x = {
    colore: 'rosso',
    
}
console.log("sono in giacca.js");

let g = new Giacca();

g.chiudiZip();

console.log(g.zipAperta);
