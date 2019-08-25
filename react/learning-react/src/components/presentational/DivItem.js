import React from 'react';
import '../../styles/App.css';
const DivItem = ({value}) => <div className = "item" id = {value} > {value.toUpperCase()}</div>
export default DivItem;