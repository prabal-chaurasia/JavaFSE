import {CalculateScore} from '../src/Components/CalculateScore.js';

function App() {
    return (
        <div>
            <CalculateScore 
                Name={"Steeve"}
                School={"DNV Public School"}
                total={284}
                goal={3}
            />
        </div>
    );
}

export default App;
