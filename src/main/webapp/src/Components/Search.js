import React, {Component} from 'react';
import axios from 'axios';
import "../index.css"

class Search extends Component {
    state= {
        url:'',
        shorten:'',
        list:[]
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/getall")
            .then(res => {
                if (res.data) {
                    this.setState({list:res.data})
                }
                //console.log(res.data);
            })
            .catch(error => {
                console.log(error);
            })
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
                if (res.data) {
                    this.setState({
                        shorten:res.data,
                        list: this.state.list.concat({"origin": this.state.url, "shortened": res.data})
                    });

                }
                console.log(res.data)
            })
            .catch(error => {
                console.log(error);
            })
    }

    render() {

        const urlList = this.state.list.map(
            x => (

                <tr>
                    <td> {x["origin"]}</td>
                    <td className="align-middle">
                        <a target="_blank" href={`http://localhost:8080/${x["shortened"]}`}> {x["shortened"] } </a>
                    </td>
                </tr>
            )
        );
        return (
            <div class="search-box">
                <div class="search">

                    <input
                    name="url"
                    type="text"
                    id="input"
                    className="form-control"
                    placeholder="원본 주소를 입력하세요"
                    onChange={this.handleUrlChange}
                    value={this.state.url}
                    />

                    <button type="button" className="btn btn-outline-dark" onClick={this.handleSubmit}>확인</button>
                    <br />

                </div>
                <div class="result">
                    {this.state.shorten ? <div className=""> Shortened URL -> <a href={this.state.shorten} class="atag"> {this.state.shorten } </a></div> : null}
                </div>
                <div>
                    <table className="table table-hover table-bordered table-sm">
                        <thead className="thead-dark">
                        <tr>
                            <th class="th-origin">Original</th>
                            <th class="th-short">Shortened</th>
                        </tr>
                        </thead>
                        <tbody>
                        {urlList}

                        </tbody>
                    </table>

                </div>
            </div>
        );
    }
}

export default Search;