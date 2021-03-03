import * as React from "react";
import { Button, StyleSheet } from "react-native";
import { Text, View } from "../components/Themed";

interface StartScreenProps {
    navigation: any; // TO DO: Fix any type declaration
}

class StartScreen extends React.Component<StartScreenProps> {
    constructor(props: StartScreenProps) {
        super(props);
    }

    navigateToSettings(props: StartScreenProps) {
        props.navigation.navigate("Settings");
        console.log("did something!");
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.title}>This is the StartScreen</Text>
                <Button
                    title="Start Game"
                    onPress={() => this.navigateToSettings(this.props)}
                />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: "center",
        justifyContent: "center",
    },
    title: {
        fontSize: 20,
        fontWeight: "bold",
        padding: 30,
    },
    separator: {
        marginVertical: 30,
        height: 1,
        width: "80%",
    },
});

export default StartScreen;
