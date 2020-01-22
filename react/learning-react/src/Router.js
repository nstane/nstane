import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import App from './App';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import MoreVertIcon from '@material-ui/icons/MoreVert';
  
  const About = () => <h2>About</h2>;
  
  const Users = () => <h2>Users</h2>;
  
  function AppRouter() {

    const links = [
      {url:'/',label:'Home'},
      {url:'/about/',label:'About'},
      {url:'/users/',label:'Users'}
    ];
    
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

    const handleClick = event => {
      setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
      setAnchorEl(null);
    };
    return (

      <Router>
        
        <IconButton
        aria-label="more"
        aria-controls="long-menu"
        aria-haspopup="true"
        onClick={handleClick}
      >
        <MoreVertIcon />
      </IconButton>

      <Menu
        id="long-menu"
        anchorEl={anchorEl}
        keepMounted
        open={open}
        onClose={handleClose}
        PaperProps={{
          style: {
            maxHeight: 50 * 4.5,
            width: 200,
          },
        }}
      >
        {links.map(link => (
          <MenuItem key={link.label} selected={link.label === 'Home'} onClick={handleClose}>
            <Link to={link.url}>{link.label}</Link>
          </MenuItem>
        ))}
      </Menu>
  
          <Route path="/" exact component={App} />
          <Route path="/about/" component={About} />
          <Route path="/users/" component={Users} />
      </Router>
    );
  }
  
  export default AppRouter;