import React from 'react';
import logo from './logo.svg';
import './styles/App.css';
import StickyBar from './components/presentational/StickyBar';
import Body from './components/presentational/Body'
import Container from './components/container/Container'

class App extends React.Component {

  listReference;
  constructor(props) {
    super(props);
    this.updateStickyProps = this.updateStickyProps.bind(this);
    console.log('App.constructor');
  }

  updateStickyProps(el) { 
    this.listReference = el;
  }

  componentWillMount() {
    const evtSource = new EventSource("http://localhost:8080/api/user");

    evtSource.onmessage = function(event) {
      console.log(event.data);
    };

    evtSource.onerror = function(err) {
      console.error("EventSource failed:", err);
    };
    console.log('App.componentWillMount');
  }
  
  componentDidMount() {
    console.log('App.componentDidMount');
  }

  componentWillUnmount() {
    console.log('App.componentWillUnmount')
    //this.stickyHelper.unResisterScrollEvent();
  }

  componentWillReceiveProps(nextProps) {
    console.log('App.componentWillReceiveProps');
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log('App.shouldComponentUpdate', nextProps, nextState, this.props, this.state);
    return true;
  }

  componentWillUpdate() {
    console.log('App.componentWillUpdate');
  }

  componentDidUpdate() {
    console.log('App.componentDidUpdate');
  }

  render(){
    console.log('App.render');
    const element = <div>{this.props.children}</div>;
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>
          Sticky Bar Demo
        </h1>
      </header>
      <Body listRef = {this.updateStickyProps}/>
        <StickyBar price = {"123.11"} refElement = {this.listReference}></StickyBar>
      {element}

      <Container/>
    </div>
  );
}
}

export default App;