import React, { Component } from 'react';
import { getAllPolls, getUserCreatedPolls, getUserVotedPolls } from '../util/APIUtils';
import Poll from './Poll';
import { castVote } from '../util/APIUtils';
import LoadingIndicator  from '../common/LoadingIndicator';
import {Button, Icon, notification, Select} from 'antd';
import { POLL_LIST_SIZE } from '../constants';
import { withRouter } from 'react-router-dom';
import './PollList.css';
const Option = Select.Option;

class Interface extends Component {
    constructor(props) {
        super(props);
        this.state = {
            color: localStorage.getItem('interfaceColor') || 'Blue'
        };
    }

    handleColorChange = (value) => {
        localStorage.setItem('interfaceColor', value);
        this.setState({
            color: value
        });
        window.location.reload();
    }

    render() {

        return (
            <div className="color-select">
                Interface color: <Select
                    name="color"
                    defaultValue="red"
                    value={this.state.color}
                    onChange={this.handleColorChange}
                    style={{ width: 200 }} >
                    <Option key="Blue">Blue</Option>
                    <Option key="Orange">Orange</Option>
                    <Option key="Green">Green</Option>

                </Select>
            </div>
        );
    }
}

export default withRouter(Interface);