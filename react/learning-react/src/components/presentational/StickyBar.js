import React from 'react';
import PropTypes from 'prop-types';
import '../../styles/App.css';
import {onClickScrollToTarget} from '../../helpers/Helper'

const StickyBar = props => {
    const {price, refElement} = props;
    const onClick = ()=> {onClickScrollToTarget(refElement)};
    return(
        <div>
            <div className="Sticky">
                <div className="left StickyContent">
                    {price}
                </div>
                <div className="right StickyContent">
                    <button onClick= {onClick}>Chek Availibility</button>
                </div>
            </div>
        </div>
    )
}

StickyBar.prototype = {
    price : PropTypes.string.required,
    refElement : PropTypes.object.required
}

StickyBar.defaultProps = {
    price : '90' 
}
export default StickyBar;