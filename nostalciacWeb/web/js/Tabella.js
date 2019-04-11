import Paginator from "./Paginator.js"

        /**
         titolo;
         service;
         idTabella;
         classeTabella;
         contenitore;
         page
         */

        export default class Tabella {

    constructor(properties) {
        this.prop = properties;
        this.el = document.querySelector(this.prop.contenitore);
        this.table = document.createElement("table");
        this.thead = document.createElement("thead");
        this.tbody = document.createElement("tbody");
        this.tfoot = document.createElement("tfoot");

        this.rowSelected = null;
        this.onPaginatorClick = this.onPaginatorClick.bind(this);
        this._loadData();
    }

    _loadData() {
        this.prop.service.all(0, this.prop.page)
                .then(data => this._render(data));
    }

    _reloadData() {
        this.prop.service.all((this.paginator.current - 1) * this.paginator.page, this.paginator.page)
                .then(json => {
                    this.data = json.data;
                    this.tbody.innerHTML = "";
                    this._createBody();
                });
    }
    _render(json) {
        this.data = json.data;
        this.count = json.count;
        this._readFields();
        this.table.id = this.prop.idTabella;
        this.table.className = this.prop.classeTabella;
        this._addCaption(this.prop.titolo);
        this._addHeaders();
        this._createBody();
        this._createFooter();
        this.el.appendChild(this.table);

    }

    _readFields() {
        const [first] = this.data;
        this.fields = Reflect.ownKeys(first);
    }

    _addCaption(titolo) {
        let caption = document.createElement("caption")
        caption.innerText = titolo
        this.table.appendChild(caption);
    }

    _addHeaders() {
        this.fields.map(name => this._createHeaderColumn(name))
                .forEach(cell => this.thead.appendChild(cell));
        this.table.appendChild(this.thead);
    }

    _createHeaderColumn(value) {
        const hcell = document.createElement("th");
        hcell.innerText = value;
        return hcell;
    }

    _createBody() {
        this.data
                .map(v => this._createRow(v))
                .forEach(v => this.tbody.appendChild(v));
        this.table.appendChild(this.tbody);
    }

    _createRow(rowData) {
        const row = document.createElement("tr");
        row.onclick = this.onRowClick;
        this.fields
                .map(v => Reflect.get(rowData, v))
                .map(v => this._createCol(v))
                .forEach(v => row.appendChild(v))
        return row;
    }

    _createCol(value) {
        const col = document.createElement("td");
        col.innerText = value;
        return col;
    }

    _createFooter() {
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
            page: this.prop.page,
            count: this.count,
            callback: this.onPaginatorClick
        });
        col.appendChild(this.paginator.first);
        col.appendChild(this.paginator.prev);
        col.appendChild(this.paginator.next);
        col.appendChild(this.paginator.last);
    }

    onRowClick(e) {
        
        if (this.rowSelected) {
            this.rowSelected.classList.toggle('row-select');
        }
        this.rowSelected = e.target.parentElement;
        this.rowSelected.classList.toggle('row-select');
    }

    onPaginatorClick() {
        this._reloadData();
    }
}


