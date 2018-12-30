const React = require('react');
const ReactDOM = require('react-dom');
const rest = require('rest');
const mime = require('rest/interceptor/mime');

function Character(props){
	return(
		<td>{props.character}</td>
	);
}

class Row extends React.Component{

	render(){
		const characters = this.props.row.split("").map(digit =>
			<Character character={digit} />
		);

		return(
			<tr>
				{characters}
			</tr>
		);
	}
}

class WordGrid extends React.Component{

	render(){

		const rows = this.props.grid.characterGrid.map(row => 
			<Row row={row} />	
		);

		return (

			<div>
				<h2>{this.props.grid.name}</h2>
				<table className="table table-sm table-bordered">
					<tbody>
						{rows}
					</tbody>
				</table>
			</div>
		);
	}
}

class App extends React.Component {

	constructor(props){
		super(props);
		this.state = {allGrids: []};
	}

	componentDidMount(){
		let client = rest.wrap(mime);
		client({method : 'GET', path: '/allGrids'}).done(response => {
			this.setState({allGrids: response.entity});
		});
	}


	render() {

		let grids;
		if(this.state.allGrids){
			grids = this.state.allGrids.map(grid =>
				<WordGrid key={grid.id} grid={grid} />
			);
		}

		return (
			<div>
				{grids}
			</div>
		);
	}
}



// ========================================



ReactDOM.render(
  <App />,
  document.getElementById('root')
);