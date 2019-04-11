import Paginator from "./Paginator.js"
        /**
         titolo;
         service;
         idTabella;
         classeTabella;
         contenitore;
         */

export default class Tabella {

    constructor(properties) {
        this.prop = properties;
        this.el = document.querySelector(this.prop.contenitore);
        this.table = document.createElement("table");
        this.thead = document.createElement("thead");
        this.tbody = document.createElement("tbody");
        this.tfoot = document.createElement("tfoot");

        this.loadData();
    }

    loadData() {
        this.prop.service.all()
                .then(data => this.render(data));
    }

    render(data) {
        this.data = data;
        this.readFields();
        this.table.id = this.prop.idTabella;
        this.table.className = this.prop.classeTabella;
        this.addCaption(this.prop.titolo);
        this.addHeaders();
        this.createBody();
        this.createFooter();
        this.el.appendChild(this.table);
    }

    readFields() {
        const [first] = this.data;
        this.fields = Reflect.ownKeys(first);
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

    createHeaderColumn(value) {
        const hcell = document.createElement("th");
        hcell.innerText = value;
        return hcell;
    }

    createBody() {
        this.data
                .map(v => this.createRow(v))
                .forEach(v => this.tbody.appendChild(v));
        this.table.appendChild(this.tbody);
    }

    createRow(rowData) {
        const row = document.createElement("tr");
        row.onclick = this.onRowClick;
        this.fields
                .map(v => Reflect.get(rowData, v))
                .map(v => this.createCol(v))
                .forEach(v => row.appendChild(v))
        return row;
    }

    createCol(value) {
        const col = document.createElement("td");
        col.innerText = value;
        return col;
    }

    createFooter() {
        const row = document.createElement("tr");
        const col = document.createElement("td");
        console.dir(col);
        col.colSpan = this.fields.length;
        this.createPaginator(col)
        row.appendChild(col);
        this.tfoot.appendChild(row);
        this.table.appendChild(this.tfoot);
    }

    createPaginator(col) {
        this.paginator = new Paginator({
            page: 5,
            count: this.data.length,
            callback: this.onPaginatorClick
        });
        col.appendChild(this.paginator.first);
        col.appendChild(this.paginator.prev);
        col.appendChild(this.paginator.next);
        col.appendChild(this.paginator.last);
    }

    onRowClick(e) {
        console.log("row click");
    }

    onPaginatorClick() {
        console.log("paginator click");
    }
}


