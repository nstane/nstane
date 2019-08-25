import React from 'react';
import Form from './Form';

class Container extends React.Component {

    constructor(props) {
        super(props);
        this.onContainerClick = this.onContainerClick.bind(this);
        console.log('Container.constructor');
    }

    onContainerClick(event) {
        console.log('Container.onContainerClick', event);
    }

    componentWillMount() {
        console.log('Container.componentWillMount');
    }
    componentDidMount() {
        console.log('Container.componentDidMount');
    }
    
    componentWillUnmount() {
        console.log('Container.componentWillUnmount');
    }

    componentWillReceiveProps(nextProps) {
        console.log('Container.componentWillReceiveProps');
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log('Container.shouldComponentUpdate');
        return false; //if false no update on parent update or any prop change.
    }

    componentWillUpdate() {
        console.log('Container.componentWillUpdate');
    }

    componentDidUpdate() {
        console.log('Container.componentDidUpdate');
    }

    render(){
        console.log('Container.render');
        return(
            <div onClick={this.onContainerClick}>
                Container ...... UI will be added here
                <Form/>
            </div>
        );
    }
}


export default Container;