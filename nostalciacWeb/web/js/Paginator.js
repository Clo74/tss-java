/*
 * page
 * count
 * callback
 */
export default class Paginator {
    constructor(properties) {
        this.prop = properties;
        this.current = 1;
        this.page = this.prop.page;
        this.count = this.prop.count;
        this.onFirst = this.onFirst.bind(this);
        this.onPrev = this.onPrev.bind(this);
        this.onNext = this.onNext.bind(this);
        this.onLast = this.onLast.bind(this);
        this.create();
        this.checkButtons();
    }

    create() {
        this.first = this.createButton("btnFirst", "First", this.onFirst);
        this.prev = this.createButton("btnFirst", "Prev", this.onPrev);
        this.next = this.createButton("btnFirst", "Next", this.onNext);
        this.last = this.createButton("btnFirst", "Last", this.onLast);
    }

    createButton(id, label, clickHandler) {
        const b = document.createElement("button");
        console.dir(b);
        b.id = id;
        b.innerText = label;
        b.addEventListener("click", clickHandler);
        if (this.prop.callback) {
            b.addEventListener("click", this.prop.callback);
        }
        return b;
    }

    checkButtons() {
        //this.first.classList.add("pure-button-disabled");
        //this.prev.classList.add("pure-button-disabled");
    }

    onFirst() {
        console.log("first -> " + this.current)
        this.current = 1;
    }

    onPrev(e) {
        this.current--;
    }

    onNext(e) {
        this.current++;
    }

    onLast(e) {
        this.current = Math.floor(this.count / this.page);
        this.current = this.count % this.page !== 0 ? this.current + 1 : this.current;
        console.log("last -> " + this.current)
    }
}


