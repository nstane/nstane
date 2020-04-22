import {useLocalStore, useObserver} from 'mobx-react'

export const store:any = useLocalStore(() => ({
    todos : ["Na"],
    add(todo: string) {
        store.todos.push(todo);
    },
    get size() { 
        return store.todos.length;
    }
}));
