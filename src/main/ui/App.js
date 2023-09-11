import {ActivityIndicator, StyleSheet, View} from 'react-native';
import Beers from './components/Beers';
import { useEffect, useState } from 'react';

const apiUrl = 'http://192.168.1.55:8080/api';

const App = () => {
  const [isLoading, setLoading] = useState(true);
  const [beerTypes, setBeerTypes] = useState([]);

  const getBeers = async () => {
    try {
      const response = await fetch(apiUrl + '/beers/types');
      const json = await response.json();
      setBeerTypes(json);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    getBeers();
  }, []);

  return (
      <View style={styles.container}>
        {isLoading ? (
            <ActivityIndicator />
        ) : (
            <Beers
                types={beerTypes}
            />
        )}
      </View>
  );
};

export default App;


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
