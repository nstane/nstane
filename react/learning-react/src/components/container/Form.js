import React from 'react';
import '../../styles/App.css'

class Form extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            text : ''
        };
        this.onChangeEvent = this.onChangeEvent.bind(this);
    }

    onChangeEvent(event) {
        this.setState({text : event.target.value});
    }
    render() {

        return(
            <div>
            <div className='item'>
                <label>Value : </label> {this.state.text}
            </div>
            <div className='item'>
                <label htmlFor='name' >Name : </label>
                <input id='name' type='text' onChange={this.onChangeEvent} defaultValue={this.state.text} /><br></br>
            </div>
            </div>
        );
    }
}

export default Form;