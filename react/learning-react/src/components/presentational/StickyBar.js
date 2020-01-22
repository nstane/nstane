import React from 'react';
import '../../styles/App.css';
import {onClickScrollToTarget, StickyHelper} from '../../helpers/Helper'

class StickyBar extends React.Component{
    constructor(props){
        super(props)
        this.state = {stickyhide: true};
        this.stickyHelper = StickyHelper(this);
    }

    componentDidMount(){
        this.stickyHelper.resisterScrollEvent()
    }

    componentWillUnmount() {
        this.stickyHelper.unResisterScrollEvent();
    }

    onClick(){
        onClickScrollToTarget(this.props.refElement)
    }

    render() {
        return(
        <div>
            <div className="Sticky">
                <div className="left StickyContent">
                    {this.props.price}
                </div>
                <div className="right StickyContent">
                    <button onClick= {this.onClick}>Chek Availibility</button>
                </div>
            </div>
        </div>
    )}
}
export default StickyBar;