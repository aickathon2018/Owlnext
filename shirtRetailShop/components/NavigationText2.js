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

export default class NavigationText extends React.Component {
  render() {

    return (
        
        <View style={this.props.style}>
          <Text style={{fontSize : 30}}>
            Wing Chair - Black
          </Text>

          <Text>Seat depth: 57 cm</Text>
          <Text>Seat height: 49 cm</Text>
          <Text>Back height: 104 cm</Text>

          <Text style={{fontSize : 18, color : '#ffffff'}}>
Designed with low arms and sculpted solid wood legs, our Owen Chair is our modern interpretation of the traditional wingback chair</Text>
        </View>
    );
  }

};
