import React from "react";
import { NavigationContainer, useNavigation } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import StartScreen from "./screens/StartScreen";
import SettingsScreen from "./screens/SettingsScreen";

class App extends React.Component {
    constructor(props: any) {
        // TODO fix any type declaration
        super(props);
    }

    private Stack = createStackNavigator();

    render() {
        return (
            <NavigationContainer>
                <this.Stack.Navigator initialRouteName="Start">
                    <this.Stack.Screen name="Start" component={StartScreen} />
                    <this.Stack.Screen
                        name="Settings"
                        component={SettingsScreen}
                    />
                </this.Stack.Navigator>
            </NavigationContainer>
        );
    }
}

export default App;
