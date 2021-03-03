import * as React from "react";
import { StyleSheet } from "react-native";
import { Text, View } from "../components/Themed";

interface SettingsScreenProps {}

class SettingsScreen extends React.Component<SettingsScreenProps> {
    constructor(props: SettingsScreenProps) {
        super(props);
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.title}>This is the settings page.</Text>
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

export default SettingsScreen;
