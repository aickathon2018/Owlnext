import React from 'react';
import {
  asset,
  AppRegistry,
  StyleSheet,
  Text,
  View,
  VrButton,
  Image
} from 'react-360';
import NavigationButton from './components/NavigationButton';
import NavigationText from './components/NavigationText';
import NavigationText2 from './components/NavigationText2';

export default class shirtRetailShop extends React.Component {
  constructor(){
    super();
    this.state = {
      firstVisible : false,
      secondVisible : false
    }
  }

  handleFirstVisible = () => {
    if (this.state.firstVisible === true)
      this.setState({
        firstVisible : false
      })
    else
      this.setState({
        firstVisible : true
      })

    console.log('state : ', this.state.firstVisible)
  }

  handleSecondVisible = () => {
    if (this.state.secondVisible === true)
      this.setState({
        secondVisible : false
      })
    else
      this.setState({
        secondVisible : true
      })
  }

  render() {
    return (
      <View style={styles.panel}>

        <NavigationButton style={styles.firstButtonView} onHandleClick = {this.handleFirstVisible} />
        <NavigationButton style={styles.secondButtonView} onHandleClick = {this.handleSecondVisible}/>

        {/* <NavigationButton style={styles.thirdButtonView} onHandleClick = {console.log("hello")}/> */}

        <NavigationText style={styles.firstText}/>
        <NavigationText2 style={styles.secondText}/>

      </View>
    );
  }
};

const styles = StyleSheet.create({
  panel: {
    width : '5000',
    height : '5000'
    // Fill the entire surface
  },
  firstText: {
    padding: 20,
    height : 300,
    width : 500,
    backgroundColor: '#0abab5',
    borderColor: '#ffffff',
    borderWidth: 2,
    transform : [{translateX : 0},{translateY : 150}],
  },
  secondText: {
    padding: 20,
    height : 300,
    width : 300,
    backgroundColor: '#0abab5',
    borderColor: '#ffffff',
    borderWidth: 2,
    transform : [{translateX : 700},{translateY : 400}],
  },
  firstButtonView : {
    transform : [{translateX : 300},{translateY : -400},],
    width : 80,
    height : 80
  },
  secondButtonView : {
    transform : [{translateX : 800},{translateY : -450}],
    width : 80,
    height : 80
  },
  thirdButtonView : {
    transform : [{translateX : 500},{translateY : -700}],
    width : 80,
    height : 80
  }

});

AppRegistry.registerComponent('shirtRetailShop', () => shirtRetailShop);
