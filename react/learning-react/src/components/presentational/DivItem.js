import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import '../../styles/App.css';
import store from '../../stores/Store'

const DivItem = ({value}) => {
    const classes = useStyles();
    const handleClick = () => {
      console.log('handleClick', store.addItem("handle click"));
    }
return(
<Card className={classes.card}>
    <CardContent>
        <Typography className={classes.title} color="textSecondary" gutterBottom>
            <div className = "item" id = {value} > {value.toUpperCase()}</div>
        </Typography>
    </CardContent>
    <CardActions>
        <Button onClick={handleClick} size="small">Learn More</Button>
    </CardActions>
</Card>
);

}

const useStyles = makeStyles({
    card: {
      minWidth: 275,
      margin:20
    },
    bullet: {
      display: 'inline-block',
      margin: '0 2px',
      transform: 'scale(0.8)',
    },
    title: {
      fontSize: 14,
    },
    pos: {
      marginBottom: 12,
    },
  });
export default DivItem;