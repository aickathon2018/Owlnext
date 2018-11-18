import React, { Component } from 'react';
import axios from 'axios';
import FormControl from '@material-ui/core/FormControl';
import Input from '@material-ui/core/Input';
import { FormLabel } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import FashionImage from './fashion.jpg'
import Button from '@material-ui/core/Button';
import AICard from './AICard';
import CircularProgress from '@material-ui/core/CircularProgress';


export default class AIPicture extends Component{

    constructor(){
        super();
        this.state= {"message":"",
                    "styles" : [],
                    "garments" : [],
                    "uploading" : false,
                    "nothing" : false}
    }

    inputUploaded = () => {
        
        this.setState({
            "message":"",
            "styles" : [],
            "garments" : []
        })

        let inputForm = document.getElementById('photoInput');

        var reader = new FileReader();

        if (inputForm.files && inputForm.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById("fashion").src = e.target.result;
            }
            reader.readAsDataURL(inputForm.files[0]);
          }
    }

    performAIAlgorithms = () => {

        this.setState({
            uploading : true,
            nothing : false
        })

        const API_URL = 'https://fashion.recoqnitics.com/analyze'
        const ACCESS_KEY = '617db9c5604c31bab250'
        const SECRET_KEY = 'e42aaa85b9f207ab33cbe7bcf686df9835376608'

        let formData = new FormData(document.forms.namedItem('fileinfo'))
        // if you are using node.js to upload local file
        // var formData = new FormData()
        
        // formData.append('filename', fs.createReadStream(__dirname + '/my_photo.jpg'))
        
        formData.append('access_key', ACCESS_KEY)
        formData.append('secret_key', SECRET_KEY)
      
        // Method 3: axios library
        axios.post(API_URL, formData).then(response => this.getAIResults(response.data))

    }

    getAIResults = (data) => {
        this.setState({
            uploading : false
        })
        console.log(data)

        if (data.person.styles === undefined || data.person.garments === undefined){
            console.log("person is empty")
            this.setState({
                nothing : true
            })
            return
        }

        this.setState({
            message : data,
            styles : data.person.styles,
            garments : data.person.garments
        })
    }
    

    render() {

      return (
          <div style={{flexDirection: "column", display: "flex", alignItems: "center", justifyContent: "center"}}>

            {this.state.nothing?
                <h1>Error ! No person is found. Please try a better image </h1>
                :
                <div/>
            }
            
            {this.state.uploading?
                <canvas style={{position : "fixed", width : '100%', height : '120%', backgroundColor: "#00000066",zIndex : 30}}/>
                :
                <div/>
            }

            {this.state.uploading?
                <CircularProgress style={{position: "fixed", top : '50%', left : '50%', width : 50,height : 50, zIndex :50}} />
                :
                <div/>
            }

            {this.state.styles.length > 0?
                this.state.styles.map((style) =>
                <AICard title={style.styleName} style={{marginBottom : 20}}/>
                )
                :
                <div></div>
            }

            {this.state.garments.length > 0?
             this.state.garments.map((garment) =>
                <AICard title={garment.typeName} style={{marginBottom : 20}}/>
            )
            :
            <div/>}

            <img id="fashion" src={FashionImage}
                style={{width : 300, height : 400, margin : 30, zIndex : 0}}/>
            
            <form name="fileinfo" style={{marginBottom : 30}}>
                <FormLabel>Photo : 
                    <Input id="photoInput" type="file" name="filename" required onChange={this.inputUploaded}/>
                </FormLabel>
            </form>  
            <Button style={{backgroundColor:"#0abab5", color:'#fff', width : "30%", textAlign : 'center'}} onClick={this.performAIAlgorithms}>Upload</Button>

          </div>

        )
    }
}

