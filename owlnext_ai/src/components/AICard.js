import React, { Component } from 'react';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import FashionImage from './fashion.jpg'
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';


export default class AICard extends Component{
    
    render(){

        let description;
        
        console.log("Props", this.props.title)

        switch(this.props.title){
            case "Casual":
                description = "A style that embodies streetwear with fashion. These are clothes that won’t cause a stir for trendsetters but are ideal for everyday trips where durability and fit are key"
                break
            case "Bohemian":
                description = "A style popularized during 1960s and 1970s, also known as Boho Chic. The essence of the style focuses on free and flowy fabrics with exotic patterns, where scarves, vests, and skirts are often worn on top of each other"
                break
            case "Business":
                description = "Your formal business outfit, typically shirts and slacks/skirts. Occassionally topped with suit and ties to sharpen your appeal"
                break
            case "Elegant":
                description = "As fashion icon Coco Chanel once said, “elegance is refusal”. An elegant piece skips the big jewelry and flashy clothes in favor of simple styles made from luxurious fabrics that one could wear forever"
                break
            case "Romantic":
                description ="A romantic style brings out the feminine and youthful side of women while not losing their glamor. The style is characterized by soft, flowing fabrics, ruffles, lace and often a bit of blings"
                break
            case "Vintage":
                description = "The Retro style imitating that of the previous era. Vintage clothings usually refer to those made before 1990s "
                break
            case "Eclectic" :
                description = "A fashion sense that draws out the essence of contrasting styles, putting together fashion pieces that usually wouldn’t go together"
                break
            case "Rocker":
                description = "A style commonly associated to rock fans, where one dons decorated motorcycle jackets, often adorned with metals studs and badges. A rocker outfit is not complete without ripped denim, vintage tees and leather jacket"
                break
            case "Sexy":
                description = "Sexy, exotic, revealing, and everything in between"
                break
            case "Denim":
                description = "A classic style that puts your favorite blues to work. Seriously, what can go wrong with jeans and denim jacket"
                break
            case "Outdoor":
                description = "A rugged, multi-purpose look suitable for all kind of outdoor activities and adventures. Sweatpants, tanks, cardigans and maybe even a cowboy hat"
                break
            case "90s":
                description = "Fashion sense at the 90’s was known to be rebellious, as compared to their more glamorous predecessors. Flared jeans, crop tops, corsets, gothic dresses, You name it"
                break
            default:
                description = "Visit our store for " + this.props.title + " items !"
                break
        }

        return(
            <Card style={{width : '60%', marginBottom : 20}}>
                <CardActionArea>
                    <CardMedia
                    image={FashionImage}
                    title={this.props.title}
                    />
                    <CardContent>
                    <Typography gutterBottom variant="h5" component="h2">
                        {this.props.title}
                    </Typography>
                    <Typography component="p">
                        {description}
                    </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <Button size="small" color="primary">
                    Share
                    </Button>
                    <Button size="small" color="primary">
                    Visit Store
                    </Button>
                </CardActions>
            </Card>
        )

    }
}