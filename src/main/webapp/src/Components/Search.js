import React, {Component} from 'react';
import axios from 'axios';

class Search extends Component {
    state= {
        url:'',
    }

    handleUrlChange = (e) => {
        this.setState({
            [e.target.name]:e.target.value,
            isSubmitted: false
        })
    }
    handleSubmit = (e) => {
        e.preventDefault();
        axios.post("http://localhost:8080",  {
            origin: this.state.url,
        })
            .then(res => {
                if (res.data.success) {
                    //console.log(res);
                }
                console.log(res)
            })
            .catch(error => {
                console.log(error);
            })
    }
    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <input
                    name="url"
                    type="text"
                    id="test"
                    onChange={this.handleUrlChange}
                    value={this.state.url}
                    />
                    <button type="submit"> 확인 </button>
                </form>
            </div>
        );
    }
}

export default Search;