import { observable, action, decorate } from "mobx";

class Store {
    _items = ["Narender"];

    addItem(item){
        this._items.push(item);
    }
}

const store =  new Store();
export default store;

decorate(Store, {
    _items:observable,
    addItem: action
})