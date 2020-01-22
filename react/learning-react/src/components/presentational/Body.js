import React from 'react';
import DivItems from './DivItems'
import store from '../../stores/Store'
//import {createReactClass} from 'create-react-class';


const Body = (props) => {

    /*var CommentList = reactCreateClass({ render: function() {
        return (
        <div className="commentList">
                Hello, world! I am a CommentList.
              </div>
        ); }
        });
        var CommentForm = reactCreateClass({ render: function() {
        return (
        <div className="commentForm">
                Hello, world! I am a CommentForm.
              </div>
        ); }
        });
        var CommentBox = reactCreateClass({ render: function() {
        return (
        <div className="commentBox">
        <h1>Comments</h1>
        <CommentList /> // Which was defined above and can be reused <CommentForm /> // Same here
        </div> );
        } });
        */
    const {listRef} = props;
    const ids = ['a', 'b', 'c', 'id']
    console.log(store._items);
    return(
        <div ref = {listRef}>
            <DivItems divIds = {ids}></DivItems>
        </div>
    );
}

export default Body;