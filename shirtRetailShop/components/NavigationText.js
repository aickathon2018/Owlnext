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
                Cote Mid-Century Sofa
          </Text>
          <Text>Width 87"</Text>
          <Text>Depth 38"</Text>
          <Text>Height 35"</Text>

          <Text style={{fontSize : 18, color : '#ffffff'}}>
            The Monroe collection is the epitome of effortless, casual style and extreme comfort. Its transitional style is highlighted by its padded roll arm, exposed block leg, contrasting throw pillows, and deep comfortable seat. Available as a sectional, sofa, loveseat, chair, ottoman, chair and a half, ottoman and a half, and twin, full, and queen sleeper. Take a look at our Leah collection for an all leather version of this silhouette.
          </Text>
        </View>
    );
  }

};
