import React from 'react';
import DivItem from './DivItem';

const DivItems = ({divIds}) => (divIds.map((id, index)=> <DivItem key = {index} value = {id}></DivItem>))

export default DivItems;