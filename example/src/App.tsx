import { restart } from '@homielab/react-native-hot-restart';
import { useState } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function App() {
  const [time] = useState(() => new Date().toLocaleTimeString());

  return (
    <View style={styles.container}>
      <Text style={styles.text}>App loaded at: {time}</Text>
      <Button title="Restart App" onPress={() => restart()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    marginBottom: 20,
    fontSize: 16,
  },
});
