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

export default class NavigationButton extends React.Component {
  render() {

    return (
        
      <View >
      
          <VrButton style={this.props.style}>
            <Image source={asset('info.png')} style={{width : 80, height : 80}}/>
          </VrButton>

      </View>
    );
  }

};
