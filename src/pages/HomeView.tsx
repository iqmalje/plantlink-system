import React from "react";
import Button from "../components/button";


class HomeView extends React.Component<{}, {count:number}> {

    constructor(props:any) {
        super(props);
        this.state = {
            count:0
        }
    }
    
    

    // A function that will increment the count!
    incrementCount() {
        if(this.state.count + 1 === 69) {
            alert("nice")
        }
        this.setState({
            count: this.state.count+1
        })
        
    }
    render(): React.ReactNode {
        return <>
        <p>Hii this is homeview, and this is a button</p><br />

        <Button text="Click me" onPressed={() => alert("hii")}/>

        <p>There's another button down here, click here and see what happens!</p>
        <p>You have clicked <b>{this.state.count}</b> times!</p>
        <Button text="See what happens" onPressed={() => this.incrementCount()}/>
        <p>This button is actually another component (components/button.tsx), you may go check the code there!</p>
        </>
    }
}

export default HomeView;