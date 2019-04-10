export default class Tabella {

    constructor(titolo,
            service,
            idTabella,
            classeTabella,
            contenitore = "body",
            ) {

        this.titolo = titolo;
        this.service = service;
        this.id = idTabella;
        this.class = classeTabella;
        this.el = document.querySelector(contenitore);

        this.table = document.createElement("table");
        this.thead = document.createElement("thead");
        this.tbody = document.createElement("tbody");

        this.loadData();
          
    }

     loadData(){
         this.service.all()
                .then(data => this.createTable(data));
    }
    
    createTable(data) {
        this.data = data;
        const [first] = data;
        this.fields = Reflect.ownKeys(first);
        this.table.id = this.id;
        this.table.className = this.class;
        this.addCaption(this.titolo);
        this.addHeaders();
        this.el.appendChild(this.table);
    }

    addCaption(titolo) {
        let caption = document.createElement("caption")
        caption.innerText = titolo
        this.table.appendChild(caption);
    }

    addHeaders() {
        this.fields.forEach(key => this.addHeader(key));
        this.table.appendChild(this.thead);
    }

    addHeader(...names) {
        names.map(name => this.createHeaderColumn(name))
                .forEach(cell => this.thead.appendChild(cell));
    }
    
    createHeaderColumn(value){
        const hcell = document.createElement("th");
        hcell.innerText = value;
        return hcell;
    }
}


